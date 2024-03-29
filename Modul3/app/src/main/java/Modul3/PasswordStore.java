/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul3;

import Modul3.Encryptor;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordStore {
    public String name, username;
    private String password, hashkey;
    private double score;
    private int category;
    
    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;
    
    public PasswordStore(String name, String username, String plainPass){
        
    }
    
    public PasswordStore(String name, String username, String plainPass, int category){
        
    }
    
    public void setPassword(String plainPass){
        
    }
    public String getPassword(){
        return null;
    }
    
    public void setCategory(int category){
        
    }
    
    public String getCategory(){
        return "";
    }
    
    private void calculateScore(String plainPass){
        
    }
    
    @Override
    public String toString() {
        return "";
    }
}
