/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.Entities.Tourist;


/**
 *
 * @author user
 */
 



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roadrevel.database.DatabaseHandler;
import roadrevel.resources.IService;

/**
 *
 * @author Nasr
 */
public class ServiceTourist implements IService<Tourist>{
  
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    public void ajouter(Tourist p) {
        String req = "INSERT INTO user(User_FirstName , User_lastName ,Username, User_mail ,Password,role, User_phone ,nationality,langue) VALUES(?, ? ,? ,? ,? ,? ,? ,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getFname());
            pst.setString(2, p.getLname());
             pst.setString(3, p.getUserName());
            pst.setString(4, p.getUemail());
               pst.setString(5, p.getPassword());
         
           
            pst.setString(6, p.getRole());
             pst.setInt(7, p.getUphone());
          
            pst.setString(8, p.getLangue());
            pst.setString(9, p.getNationality());
            
           pst.executeUpdate();
            System.out.println("Tourist ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Tourist p) {
        String req = "UPDATE  user SET User_FirstName =? , User_lastName =? ,Username =?, User_mail =? ,Password =?, User_phone =? ,Nationality=?,Langue=?, where id_User= ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
  
            pst.setString(1, p.getFname());
            pst.setString(2, p.getLname());
      
            pst.setString(3, p.getUserName());
             pst.setString(4, p.getUemail());
            pst.setString(5, p.getPassword());
            pst.setString(6, p.getRole());
           
            pst.setInt(7, p.getUphone());
          
           
            pst.setString(8, p.getNationality());
            pst.setString(9, p.getLangue());
         
            pst.executeUpdate();
            System.out.println("Tourist modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Tourist p) {
        String req = "DELETE FROM user WHERE id_User=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getUser_Id());
            pst.executeUpdate();
            System.out.println("User supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Tourist> afficher() {
        List<Tourist> list = new ArrayList<>();
        
        String req = "SELECT * FROM user";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
           list.add(new Tourist(result.getInt("id_User"),result.getString("User_FirstName"), result.getString("User_lastName"), result.getString("Username"),result.getString("User_mail"),result.getString("Password"),result.getInt("User_phone"), result.getString("Nationality"), result.getString("Langue")));
            }
            System.out.println("Tourists récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}
