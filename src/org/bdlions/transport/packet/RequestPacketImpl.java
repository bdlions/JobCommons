/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.packet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.bdlions.transport.sender.IClientPacketSender;
import org.bdlions.transport.sender.IRelayPacketSender;

/**
 *
 * @author alamgir
 */
public class RequestPacketImpl implements IPacket {

    private IPacketHeader packetHeader;
    private String packetBody;
    private String remoteAddress;
    private int remotePort;
    private byte[] data;

    public RequestPacketImpl(IPacketHeader packetHeader, String packetBody, String remoteAddress, int remotePort) {
        this.remoteAddress = remoteAddress;
        this.remotePort = remotePort;;
        this.packetBody = packetBody;
        this.packetHeader = packetHeader;
    }

    @Override
    public IPacketHeader getPacketHeader() {
        return packetHeader;
    }

    @Override
    public String getPacketBody() {
        return packetBody != null ? packetBody : null;
    }

    @Override
    public InetAddress getRemoteIP() {
        try {
            return InetAddress.getByName(remoteAddress);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int getRemotePort() {
        return remotePort;
    }

    @Override
    public long getSentTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSentCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setSentCount(int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IClientPacketSender getClientPacketSender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRelayPacketSender getRelayPacketSender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResponseData(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] getResponseData() {
        return data;
    }

    @Override
    public byte[] getPacketHeaderData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


}
