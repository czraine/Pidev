/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Produit.Reviews;


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
public class ServiceProductReviews implements IService<Reviews>{
 
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(Reviews p) {
        String req = "INSERT INTO Productreview(Product_Name ,Rating ,Review_txt ) VALUES(? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, p.getProduct_Name());
            pst.setInt(2, p.getRating());
            pst.setString(3, p.getReview_txt());

            pst.executeUpdate();
            System.out.println("review ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reviews p) {
        String req = "UPDATE  Productreview SET Product_Name=?, Rating= ? , Review_txt= ?  WHERE Review_id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getProduct_Name());
            pst.setInt(2, p.getRating());
            pst.setString(3, p.getReview_txt());

            pst.setInt(4, p.getReview_id());
            pst.executeUpdate();
            System.out.println("review modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reviews p) {
        String req = "DELETE FROM Productreview WHERE Review_id=?";
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
        
        String req = "SELECT * FROM Productreview";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Reviews(result.getInt("Review_id"), result.getString("Product_Name"), result.getInt("Rating"),result.getString("Review_txt")));
            }
            System.out.println("Users récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
}

