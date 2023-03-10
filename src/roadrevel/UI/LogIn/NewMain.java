/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roadrevel.UI.Login;

import java.sql.SQLException;
import java.util.List;
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
    public static void main(String[] args) throws SQLException {
        ServiceUser su = new ServiceUser();
         List<User> touristList = su.findTourist();
                    for (User u : touristList) {
                        System.out.println("Mine  id ich : " + u.getId_User() + u.getCityname1()+ u.getDateBegin()+ u.toString());
List<User> guideList = su.findGuides(u.getCityname1(), u.getDateBegin(), u.getDateEnd());
if (guideList== null ){
    System.out.println("i am null");
}
                        for (User uis : guideList) {
                            System.out.println(uis.getUser_FirstName());
                        
                        }    }}
    
}
