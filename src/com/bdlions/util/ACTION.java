package com.bdlions.util;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author nazmul hasan
 */
public enum ACTION {
    @SerializedName("1001")
    SIGN_IN(1001, REQUEST_TYPE.AUTH),
    @SerializedName("1002")
    SIGN_OUT(1002, REQUEST_TYPE.AUTH),
    @SerializedName("1003")
    SIGN_UP(1003, REQUEST_TYPE.AUTH),
    
    @SerializedName("2001")
    FETCH_PROFILE_INFO(2001, REQUEST_TYPE.REQUEST),
    @SerializedName("2002")
    FETCH_USER_INFO(2002, REQUEST_TYPE.REQUEST),
    
    @SerializedName("3001")
    UPDATE_PROFILE_INFO(3001, REQUEST_TYPE.UPDATE),
    ;

    private int id;
    private REQUEST_TYPE requestType;
    private ACTION(int id, REQUEST_TYPE requestType) {
        this.id = id;
        this.requestType = requestType;
    }
    
    public int getId(){
        return id;
    }
    
    public REQUEST_TYPE getRequestType(){
        return requestType;
    }
}
