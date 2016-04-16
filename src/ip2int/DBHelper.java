/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip2int;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfiyan
 */
public class DBHelper {
    private Connection conn = null;
    public void estConn(){
        if(conn != null){
            return;
        }
        String uri = "jdbc:postgresql://127.0.0.1:5432/mg";
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(uri,"mg","mg");
        }catch(Exception e){
            System.out.println("Err conn");
        }
    }
    
    public ResultSet giveName(){
        ResultSet rs = null;
        Statement s = null;
        try{
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM menu");
        }catch(Exception e){
            System.out.println("Err select");
        }
        
        return rs;
    }
    
    public void insertData(long lower, long upper, String country){
        Statement s = null;
        try {
            s = conn.createStatement();
            s.executeQuery("INSERT INTO geoip(lower,upper,country) VALUES("+lower+","+upper+",'"+country+"');");
        } catch (SQLException ex) {
            //Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void truncate(){
        Statement s = null;
        try {
            s = conn.createStatement();
            s.executeQuery("TRUNCATE TABLE geoip;");
        } catch (SQLException ex) {
            //Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConn(){
        try{
            conn.close();
        }catch(Exception e){
            System.out.println("Err");
        }
    }
    
    public static void main(String[] args) {
        DBHelper test = new DBHelper();
        ResultSet rs = null;
        String string = "";
        
        test.estConn(); //init database
        
        //fetch data test
        /*
        rs = test.giveName();
        
        try{
            while(rs.next()){
                string += rs.getString(2);
            }
        }catch(Exception e){
            
        }
        
        System.out.println(string);
                */
        
        test.truncate();
        test.insertData(1, 10, "ID");
    }
}
