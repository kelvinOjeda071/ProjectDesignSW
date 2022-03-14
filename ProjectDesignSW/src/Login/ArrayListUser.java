/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.ArrayList;

/**
 *
 * @author KelvinOjeda
 */
public class ArrayListUser {
    private User user;
    private ArrayList <User> arrayListUser;

    public ArrayListUser() {
         this.arrayListUser= new ArrayList<>();
    }
    
    public void add(User user){
        this.arrayListUser.add(user);
    }
    
    public void remove(User user){
        this.arrayListUser.add(user);
    }
    
}
