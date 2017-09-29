package com.bdlions.dto.response;

/**
 *
 * @author nazmul hasan
 */
public class GeneralResponse extends ClientResponse {
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
