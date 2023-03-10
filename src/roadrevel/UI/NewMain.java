/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roadrevel.UI;

import org.mindrot.jbcrypt.BCrypt;
import roadrevel.entities.User.ServiceUser;
import roadrevel.entities.User.User;

/**
 *
 * @author Nasr
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String login = "tourist";
        String pass = "tourist";
       ServiceUser su = new ServiceUser();
       User user =su.existe(login);
                System.out.println(user.getPassword());   
          boolean etat = BCrypt.checkpw(pass,user.getPassword());
       System.out.println("pass hash =" +etat);
    }
    
}
