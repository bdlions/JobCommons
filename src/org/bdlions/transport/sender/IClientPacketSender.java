/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.sender;

import org.bdlions.session.ISession;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.transport.repository.HierarchicalRepository;
import org.bdlions.transport.repository.SimpleRepository;


/**
 *
 * @author saikat
 */
public interface IClientPacketSender {
    @Deprecated
    public void send(ISession clientSession , byte[] data );
    public void send(ISession clientSession , IPacket iPacket);
    public void reSend(IPacket iPacket);
    public SimpleRepository getRepliedPacketRepository();
    public HierarchicalRepository getMissingFullPackRepository();
    public HierarchicalRepository getMissingBrokenPackRepository();
    public boolean isRequestProcessing(String userName, int action);
}
