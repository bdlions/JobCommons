///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.bdlions.transport.packet;
//
//import java.net.InetAddress;
//import org.bdlions.transport.packet.IPacket;
//import org.bdlions.transport.sender.IClientPacketSender;
//import org.bdlions.transport.sender.IRelayPacketSender;
//import com.auction.util.REQUEST_TYPE;
//
///**
// *
// * @author saikat
// */
//public class GenericPacket implements IPacket {
//
//    private InetAddress address;
//    private int port;
//    private byte[] data;
//    private boolean store = true;
//    private IClientPacketSender clientPacketSender;
//    private IRelayPacketSender relayPacketSender;
//    private REQUEST_TYPE socket_type;
//    private int actn;
//    private String pckId;
//    private String sId;
//    private boolean success;
//    private long serverPacketId;
//    private long sentTime;
//    private long receivedTime;
//    private int sentCount;
//    private int dvc;
//    private int tbid;
//
//    public void setSocketType(REQUEST_TYPE socket_type) {
//        this.socket_type = socket_type;
//    }
//
//   
//
//    public void setClientPacketSender(IClientPacketSender clientPacketSender) {
//        this.clientPacketSender = clientPacketSender;
//    }
//
//    @Override
//    public IClientPacketSender getClientPacketSender() {
//        return clientPacketSender;
//    }
//
//    public void setRelayPacketSender(IRelayPacketSender relayPacketSender) {
//        this.relayPacketSender = relayPacketSender;
//    }
//
//    @Override
//    public IRelayPacketSender getRelayPacketSender() {
//        return relayPacketSender;
//    }
//
//    public void setClientAddress(InetAddress address) {
//        this.address = address;
//    }
//
//
//    public void setClientPort(int port) {
//        this.port = port;
//    }
//
//
//    public void setSessionId(String sId) {
//        this.sId = sId;
//    }
//
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }
//
//
//    public void setStore(boolean store) {
//        this.store = store;
//    }
//
//
//
//    public void setClientPacketID(String packetId) {
//        this.pckId = packetId;
//    }
//
//
//    public void setServerPacketID(long serverPacketId) {
//        this.serverPacketId = serverPacketId;
//    }
//
//
//    public void setReceivedTime(long receivedTime) {
//        this.receivedTime = receivedTime;
//    }
//
//
//
//    public void setSentTime(long sentTime) {
//        this.sentTime = sentTime;
//    }
//
//    @Override
//    public long getSentTime() {
//        return sentTime;
//    }
//
//    public void setAction(int action) {
//        this.actn = action;
//    }
//
//
//    @Override
//    public int getSentCount() {
//        return sentCount;
//    }
//
//
//    
//    public int getDevice() {
//        return dvc;
//    }
//
//    public void setDevice(int device) {
//        this.dvc = device;
//    }
//    
//    public int getTabID() {
//        return tbid;
//    }
//
//    public void setTabID(int tabID) {
//        this.tbid = tabID;
//    }
//
//    @Override
//    public IPacketHeader getPacketHeader() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getPacketBody() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public InetAddress getRemoteIP() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getRemotePort() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int setSentCount(int count) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getAction() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getServerPacketId() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
