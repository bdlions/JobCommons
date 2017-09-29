/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.transport.packet;

import com.bdlions.util.ACTION;
import com.bdlions.util.REQUEST_TYPE;

/**
 *
 * @author alamgir
 */
public interface IPacketHeader {
    ACTION getAction();
    REQUEST_TYPE getRequestType();
    String getSessionId();
    String getPacketId();
    boolean isBroken();
}
