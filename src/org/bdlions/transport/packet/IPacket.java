/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.packet;

import java.net.InetAddress;
import org.bdlions.session.ISession;
import org.bdlions.transport.sender.IClientPacketSender;
import org.bdlions.transport.sender.IRelayPacketSender;

/**
 *
 * @author alamgir
 */
public interface IPacket {
    IPacketHeader getPacketHeader();
    String getPacketBody();
    InetAddress getRemoteIP();
    int getRemotePort();
    long getSentTime();
    int getSentCount();
    int setSentCount(int count);
    IClientPacketSender getClientPacketSender();
    IRelayPacketSender getRelayPacketSender();
    void setResponseData(byte[] data);
    byte[] getResponseData();
    byte[] getPacketHeaderData();
}
