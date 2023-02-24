/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Guide;


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
public class ServiceGuide implements IService<Guide>{
  
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    public void ajouter(Guide p) {
        String req = "INSERT INTO user(User_FirstName , User_lastName , User_mail , User_phone ,Username,Password,role ,Lang1 ,Lang2 ,Lang3 ,Cityname) VALUES(?, ? ,? ,? ,? ,? ,? ,?,?,?,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getFname());
            pst.setString(2, p.getLname());
            pst.setString(3, p.getUemail());
            pst.setInt(4, p.getUphone());
            pst.setString(5, p.getUserName());
            pst.setString(6, p.getPassword());
            pst.setString(7, p.getRole());
          
            pst.setString(8, p.getLang1());
            pst.setString(9, p.getLang2());
            pst.setString(10, p.getLang3());
            pst.setString(11, p.getCityname());
            pst.executeUpdate();
            System.out.println("Guide ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Guide p) {
        String req = "UPDATE  user SET User_FirstName =? , User_lastName =? , User_mail =? , User_phone =? ,Username =? ,Password =?,Lang1=? ,Lang2=? ,Lang3=? ,Cityname=? where id_User= ?";
           try{
               PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, p.getFname());
            pst.setString(2, p.getLname());
            pst.setString(3, p.getUemail());
            pst.setInt(4, p.getUphone());
            pst.setString(5, p.getUserName());
            pst.setString(6, p.getPassword());
            pst.setString(7, p.getLang1());
            pst.setString(8, p.getLang2());
            pst.setString(9, p.getLang3());
            pst.setString(10, p.getCityname());
            pst.setInt(11, p.getUser_Id());
            pst.executeUpdate();
            System.out.println("Guide modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Guide p) {
        String req = "DELETE FROM user WHERE id_User=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getUser_Id());
            pst.executeUpdate();
            System.out.println("Guide supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Guide> afficher() {
        List<Guide> list = new ArrayList<>();
        
        String req = "SELECT * FROM user";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
           list.add(new Guide(result.getInt("id_User"),result.getString("User_FirstName"), result.getString("User_lastName"), result.getString("User_mail"),result.getInt("User_phone"), result.getString("Username"),result.getString("Password"),result.getString("Lang1"),result.getString("Lang2"),result.getString("Lang3"),result.getString("Cityname")));
            }
            System.out.println("Guide récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

