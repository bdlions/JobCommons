/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.repository;

import java.util.Map;
import java.util.Set;
import org.bdlions.transport.repository.exceptions.DuplicacyException;
import java.util.concurrent.ConcurrentHashMap;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.transport.packet.IRepositoryCallBack;

/**
 *
 * @author saikat
 * @param <Level1>
 * @param <Level2>
 * @param <V>
 */
public class HierarchicalRepository<Level1, Level2, V> {

    private ConcurrentHashMap<Level1, ConcurrentHashMap<Level2, V>> hierachicalRepository;
    private long timeout;
    private int level2_capacity;
    private final int TWO_MINUTES = 2 * 1000 * 60;
    private final int RESETN_COUNT = 7;

    public HierarchicalRepository(int level1_capacity, int level2_capacity, long timeout) {
        if (level1_capacity <= 0 || timeout <= 0 || level2_capacity <= 0) {
            throw new UnsupportedOperationException("capacity and timeout must be positive");
        }
        hierachicalRepository = new ConcurrentHashMap<>(level1_capacity);
        this.timeout = timeout;
        this.level2_capacity = level2_capacity;
    }

    public HierarchicalRepository(int level1_capacity, long timeout) {
        if (level1_capacity <= 0 || timeout <= 0) {
            throw new UnsupportedOperationException("capacity and timeout must be positive");
        }
        hierachicalRepository = new ConcurrentHashMap<>(level1_capacity);
        this.timeout = timeout;
        level2_capacity = 16;
    }

    public void put(Level1 outerKey, Level2 innerKey, V value) throws DuplicacyException {
        ConcurrentHashMap<Level2, V> repository;

        if (containsOuterKey(outerKey)) {
            repository = hierachicalRepository.get(outerKey);
            if (repository.containsKey(innerKey)) {
                throw new DuplicacyException();
            }
            repository.put(innerKey, value);
        } else {
            repository = new ConcurrentHashMap<>(level2_capacity);
            repository.put(innerKey, value);
            hierachicalRepository.put(outerKey, repository);
        }
    }

    private boolean containsOuterKey(Level1 outerKey) {
        return hierachicalRepository.containsKey(outerKey);
    }

    private boolean containsInnerKey(Level1 outerKey, Level2 innerKey) {
        return hierachicalRepository.get(outerKey).containsKey(innerKey);
    }

    public ConcurrentHashMap<Level2, V> get(Level1 outerKey) {
        return hierachicalRepository.get(outerKey);
    }

    public V get(Level1 outerKey, Level2 innerKey) {
        if (!containsOuterKey(outerKey) || !containsInnerKey(outerKey, innerKey)) {
            return null;
        }

        return hierachicalRepository.get(outerKey).get(innerKey);
    }

    public V remove(Level1 outerKey, Level2 innerKey) {
        if (containsOuterKey(outerKey) && containsInnerKey(outerKey, innerKey)) {
            return hierachicalRepository.get(outerKey).remove(innerKey);
        }
        return null;
    }

    public Set<Level1> getOuterKeys() {
        return hierachicalRepository.keySet();
    }

    public Set<Level2> getInnerKeys(Level1 outterKey) {
        if (!containsOuterKey(outterKey)) {
            throw new NullPointerException("search key doesn't exist");
        }
        return hierachicalRepository.get(outterKey).keySet();
    }

    public void remove(Level1 key) {
        ConcurrentHashMap<Level2, V> singleRepository = hierachicalRepository.remove(key);
        if (singleRepository != null) {
            singleRepository = null;
        }
    }

    public void resendPackets(IRepositoryCallBack callBack) {
        if (hierachicalRepository.size() > 0) {
            for (Level1 key : hierachicalRepository.keySet()) {
                ConcurrentHashMap<Level2, V> resendPacketMap = hierachicalRepository.get(key);
                for (Level2 innerKey : resendPacketMap.keySet()) {
                    IPacket resendPacket = (IPacket) resendPacketMap.get(innerKey);
                    long timeDiff = System.currentTimeMillis() - resendPacket.getSentTime();
                    if (timeDiff < TWO_MINUTES && timeDiff > RESETN_COUNT) {
                        if (resendPacket.getSentCount() < RESETN_COUNT) {
                            resendPacket.setSentCount(resendPacket.getSentCount() + 1);
                            callBack.setPacket(resendPacket);
                        }
                    }
                }
            }
        }
    }

    public void clearTimeoutPackets() {
        Set<Level1> outterKeySet = hierachicalRepository.keySet();
        for (Level1 outterKey : outterKeySet) {
            ConcurrentHashMap<Level2, V> hashMap = hierachicalRepository.get(outterKey);
            if (hashMap != null && hashMap.isEmpty()) {
                hierachicalRepository.remove(outterKey);
            } else {
                for (Map.Entry<Level2, V> entry : hashMap.entrySet()) {
                    IPacket packet = (IPacket) entry.getValue();
                    if (packet.getSentTime() + timeout > System.currentTimeMillis()) {
                        V removeValue = remove(outterKey, entry.getKey());
                        if (removeValue != null) {
                            removeValue = null;
                        }
                    }
                }
            }
        }
    }

    public int getSize() {
        return hierachicalRepository.size();
    }
}
