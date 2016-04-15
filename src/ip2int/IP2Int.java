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
public class IP2Int {    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IPS ipc = new IPS();
        CSVHandler hand = new CSVHandler("F:/geoipsensei/dbip-full-2014-11.csv/dbip-full.csv");
        hand.load();
        
        //System.out.println(ipc.ip2int("180.254.51.199"));
    }
    
}
