package com.bdlions.dto.response;

import com.bdlions.util.ReasonCode;

/**
 *
 * @author nazmul hasan
 */
public abstract class ClientResponse {
    
    private int reasonCode = ReasonCode.FAILED;
    private boolean success;
    private String message;

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
