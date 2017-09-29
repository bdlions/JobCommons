/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author alamgir
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String value){
        if(value == null || value.equals("")){
            return true;
        }
        return false;
    }
    
    public static String getRandomString()
    {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
