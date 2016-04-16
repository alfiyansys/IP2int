/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip2int;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alfiyan
 */
public class CSVHandler {

    final String path;

    public CSVHandler(String path) {
        this.path = path;
    }

    public void load() {
        //Reference: http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

        String csvFile = path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        DBHelper db = new DBHelper();

        IPS ips = new IPS();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            int i = 0; //Limiter
            
            db.estConn();
            db.truncate();
            
            while ((line = br.readLine()) != null) {
                //Limiter
                /*
                 if(!(i<100)){
                 break;
                 }
                 i++;
                 */

                // use comma as separator
                String[] elements = line.split(cvsSplitBy);

                for (int j = 0; j < elements.length; j++) {
                    elements[j] = elements[j].replace("\"", "");
                }
                
                long lower = ips.ip2int(elements[0]);
                long upper = ips.ip2int(elements[1]);
                String country = elements[2];
                System.out.println(lower + " " + upper +" "+ country);
                
                db.insertData(lower, upper, country);
            }
            
            db.closeConn();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
