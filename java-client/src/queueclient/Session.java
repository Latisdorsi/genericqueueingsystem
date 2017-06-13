/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueclient;

/**
 *
 * @author alber
 */
public final class Session {
    private Session(){}
    
    private static String sesh;
    private static int counter;
    private static String name;
    private static String branch;
    
    static{
    sesh = null;
    counter = 0;
    name = null;
    branch = null;
    }

    
    public static String getBranch() {
        return branch;
    }

    public static void setBranch(String branch) {
        Session.branch = branch;
    }
   
    
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Session.counter = counter;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Session.name = name;
    }
    

    public static String getSesh() {
        return sesh;
    }

    public static void setSesh(String sesh) {
        Session.sesh = sesh;
    }
    
    
}
