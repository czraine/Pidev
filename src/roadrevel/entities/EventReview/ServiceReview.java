/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities.EventReview;

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
 * @author GAMING A15
 */
public class ServiceReview implements IService<Review>{
    
    private Connection cnx = DatabaseHandler.getInstance().getCnx();
     @Override
    public void ajouter(Review p) {
        String req = "INSERT INTO eventsreview(Event_name ,Review_txt ,id_user,	Event_id) VALUES( ?, ? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, p.getEvent_name());
            pst.setString(2, p.getReview_txt());
            pst.setInt(3, p.getId_user());
            pst.setInt(4, p.getEvent_id());
            pst.executeUpdate();
            System.out.println("review ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Review p) {
        String req = "UPDATE  eventsreview SET Event_name=?, Review_txt= ?  , id_user = ?  WHERE Review_id =?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);

          pst.setString(1, p.getEvent_name());
            pst.setString(2, p.getReview_txt());
            pst.setInt(3, p.getId_user());
            pst.setInt(4, p.getReview_id());
            pst.executeUpdate();
            System.out.println("review modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Review p) {
        String req = "DELETE FROM eventsreview WHERE Review_id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getReview_id());
            pst.executeUpdate();
            System.out.println("review supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Review> afficher() {
        List<Review> list = new ArrayList<>();
        
        String req = "SELECT * FROM eventsreview";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Review(result.getInt("Review_id"), result.getString("Event_name"),result.getString("Review_txt"),result.getInt("id_user"),result.getInt("Event_id")));
            }
            System.out.println("review récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
        /*public List<Review> showByPlace(int placeId  ) {
        List<Review> list = new ArrayList<>();
        
        String req = "SELECT * FROM place_reviews WHERE place_Id= ? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,placeId);
            
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Reviews(result.getInt("Review_id"), result.getString("Place_Name"), result.getDouble("Rating"),result.getString("Review_txt"), result.getInt("place_id"),result.getDate("Review_date"),result.getInt("id_User")));
            }
            System.out.println("review récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
                public List<Reviews> showByUser(int placeId ,int userid ) {
        List<Reviews> list = new ArrayList<>();
        
        String req = "SELECT * FROM place_reviews WHERE place_Id= ? and id_User = ? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,placeId);
            pst.setInt(2,userid);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Reviews(result.getInt("Review_id"), result.getString("Place_Name"), result.getDouble("Rating"),result.getString("Review_txt"), result.getInt("place_id"),result.getDate("Review_date"),result.getInt("id_User")));
            }
            System.out.println("review récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    */
    
    
    
}
