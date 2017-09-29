package com.bdlions.dto;

import java.net.InetAddress;

/**
 *
 * @author nazmul hasan
 */
public class Credential {

    private String userName;
    private long userId;
    private String sessionId;
    private int device;
    private int remotePort;
    private InetAddress remoteIP;
    private int appType;
    private int version;
    private int liveStatus;
    private int mood;
    private String fullName;
    private String firstName;
    private String lastName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public void setRemoteIP(InetAddress remoteIP) {
        this.remoteIP = remoteIP;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getUserName() {
        return userName;
    }

    public long getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getDevice() {
        return device;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public InetAddress getRemoteIP() {
        return remoteIP;
    }

    public int getAppType() {
        return appType;
    }

    public int getVersion() {
        return version;
    }

    public int getLiveStatus() {
        return liveStatus;
    }

    public int getMood() {
        return mood;
    }

    public String getFullName() {
        return fullName;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
