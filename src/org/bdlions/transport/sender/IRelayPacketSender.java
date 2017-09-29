/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.sender;

import org.bdlions.session.ISession;
import org.bdlions.transport.packet.IPacket;

/**
 *
 * @author saikat
 */
public interface IRelayPacketSender {
    @Deprecated
    public void send(byte[] data);
    @Deprecated
    public void send(ISession session , IPacket packet);
    public void send(IPacket packet);
    public boolean requestAccepted(long userId, long serverPacketId);
}
