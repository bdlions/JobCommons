/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.session;

import com.bdlions.dto.Credential;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author alamgir
 */
public interface ISessionManager {
    public ISession getSessionBySessionId(String sessionId);
    public ISession getOnlineSessionByUserId(long userId) throws Exception;
    public ISession createSession(Credential iSession);
    public void destroySession(String sessionId);
    public void updateSession(String sessionId , InetAddress address, int port);
    public ISession getSession(String userName, int device);
    public ISession getLatestSession(String userName);
    public ArrayList<ISession> getSessions(String userName);
}
