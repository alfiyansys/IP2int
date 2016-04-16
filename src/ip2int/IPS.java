/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip2int;

import static java.lang.Math.pow;
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
        
        num = (long)((ipoct[0]*(pow(256,3)))+(ipoct[1]*(pow(256,2)))+(ipoct[2]*(pow(256,1)))+(ipoct[3]));
        return num;        
    }
}
