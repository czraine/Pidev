/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Events;


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
public class ServiceEvents implements IService<Events>{
 
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(Events e) {
        String req = "INSERT INTO events( Event_name , Event_Descp , Event_pic , Event_pic2 , Event_pic3 ) VALUES(  ? ,? ,? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, e.getEvent_name());
            pst.setString(2, e.getEvent_descp());
            pst.setString(3, e.getEvent_img());
            pst.setString(4, e.getEvent_img2());
            pst.setString(5, e.getEvent_img3());
            pst.executeUpdate();
            System.out.println("Event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Events e) {
        String req = "UPDATE  events SET Event_name=?, Event_Descp= ? , Event_pic= ? , Event_pic2= ? , Event_pic3=?  WHERE events_Id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, e.getEvent_id());
            pst.setString(1, e.getEvent_name());
            pst.setString(2, e.getEvent_descp());
            pst.setString(3, e.getEvent_img());
            pst.setString(4, e.getEvent_img2());
            pst.setString(5, e.getEvent_img3());
            pst.executeUpdate();
            System.out.println("Event modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Events e) {
        String req = "DELETE FROM events WHERE events_Id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getEvent_id());
            pst.executeUpdate();
            System.out.println("Event supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Events> afficher() {
        List<Events> list = new ArrayList<>();
        
        String req = "SELECT * FROM events";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Events(result.getInt("events_Id"), result.getString("Event_name"), result.getString("Event_Descp"),result.getString("Event_pic"), result.getString("Event_pic2"), result.getString("Event_pic3")));
            }
            System.out.println("Events récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

