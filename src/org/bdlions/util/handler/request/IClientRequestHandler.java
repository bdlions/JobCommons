/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.util.handler.request;

import org.bdlions.transport.packet.IPacket;

/**
 *
 * @author alamgir
 */
public interface IClientRequestHandler {
    Object executeRequest(IPacket packet) throws Exception, Throwable;
}
