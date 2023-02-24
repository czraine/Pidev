/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.PlaceToVisit.Reviews;


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
public class ServiceReviews implements IService<Reviews>{
 
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(Reviews p) {
        String req = "INSERT INTO place_reviews(Place_Name ,Rating ,Review_txt , place_Id , Review_date ,id_User) VALUES( ?, ? ,? ,? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, p.getPlace_Name());
            pst.setDouble(2, p.getRating());
            pst.setString(3, p.getReview_txt());
            pst.setInt(4, p.getPlace_id());
            pst.setDate(5,new java.sql.Date(p.getReview_date().getTime()));
            pst.setInt(6, p.getId_User());
            pst.executeUpdate();
            System.out.println("review ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reviews p) {
        String req = "UPDATE  place_reviews SET Place_Name=?, Rating= ? , Review_txt= ? , place_id= ? , Review_date= ? id_User = ?  WHERE Review_id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, p.getPlace_Name());
            pst.setDouble(2, p.getRating());
            pst.setString(3, p.getReview_txt());
            pst.setInt(4, p.getPlace_id());
            pst.setDate(5, p.getReview_date());
            pst.setInt(6, p.getId_User());
            pst.setInt(7, p.getReview_id());
            pst.executeUpdate();
            System.out.println("review modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reviews p) {
        String req = "DELETE FROM place_reviews WHERE Review_id=?";
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
    public List<Reviews> afficher() {
        List<Reviews> list = new ArrayList<>();
        
        String req = "SELECT * FROM place_reviews";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
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
        public List<Reviews> showByPlace(int placeId  ) {
        List<Reviews> list = new ArrayList<>();
        
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
}

