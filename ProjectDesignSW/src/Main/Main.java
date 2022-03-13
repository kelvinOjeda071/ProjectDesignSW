/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Facade.CheckFacade;
import Login.JFLogInMultiUser;
import Login.JFLogInUserMono;

/**
 *
 * @author KelvinOjeda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFLogInMultiUser jfLoginMultiUser = new JFLogInMultiUser();
        jfLoginMultiUser.setVisible(true);
    }
    
}
