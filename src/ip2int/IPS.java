/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip2int;

import java.util.Arrays;

/**
 *
 * @author Alfiyan
 */
public class IPS {
    long ip2int(String ip){
        long num;        
        String[] array = ip.split("\\.",-1);
        long[] ipoct = Arrays.stream(array).mapToLong(Long::parseLong).toArray();
        
        num = (ipoct[0]*(256*256*256))+(ipoct[1]*(256*256))+(ipoct[2]*(256))+(ipoct[3]);
        return num;        
    }
}
