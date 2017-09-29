/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.repository;

/**
 *
 * @author saikat
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.transport.packet.IRepositoryCallBack;

public class SimpleRepository<K, V> {

    private ConcurrentHashMap<K, V> repository;
    private long timeout;
    private final int sendingLimit = 5;

    public SimpleRepository(int capacity, long timeout) {
        if (capacity <= 0 || timeout <= 0) {
            throw new UnsupportedOperationException("capacity and timeout must be positive");
        }
        repository = new ConcurrentHashMap<>(capacity);
        this.timeout = timeout;
    }

    public void put(K key, V value){ // throws DuplicacyException {
//        if (containsKey(key)) {
//            throw new DuplicacyException();
//        }
        repository.put(key, value);
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean containsKey(K key) {
        return repository.containsKey(key);
    }

    public V get(K key) {
        if (!containsKey(key)) {
            return null;
        }
        return repository.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        if (!containsKey(key)) {
            throw new NullPointerException("Given key " + key +" doesn't exist");
        }
        return repository.remove(key);
    }

    public Set<K> getKeySet() {
        return repository.keySet();
    }
    
    public int getSize(){
        return repository.size();
    }
    
    
    public void resendPackets(IRepositoryCallBack callBack){
        for (Iterator iterator = repository.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry)iterator.next();
            IPacket packet = (IPacket)entry.getValue();
            long currentTime = System.currentTimeMillis();
            if(packet.getSentTime() + timeout < currentTime && packet.getSentCount() < sendingLimit){
                packet.setSentCount(packet.getSentCount() + 1);
                callBack.setPacket(packet);
            }
            
        }
    }
    
    public void clearTimeoutPackets(){
        for (Iterator iterator = repository.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry)iterator.next();
            long sentTime = 0;
            if(entry.getValue() instanceof IPacket){
                IPacket packet = (IPacket)entry.getValue();
                sentTime = packet.getSentTime();
            }
            else if(entry.getValue() instanceof Long){
                sentTime = (Long)entry.getValue();
            }
            else{
                System.err.println("Unknown instance in clear timeout packets");
            }
            
            long currentTime = System.currentTimeMillis();
            if(sentTime + timeout > currentTime){
                iterator.remove();
            }
        }
    }

}
