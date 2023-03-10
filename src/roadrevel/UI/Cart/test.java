/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.CartProd;

/**
 *
 * @author Nasr
 */
public class test  {
        private Connection cnx = DatabaseHandler.getInstance().getCnx();

public void tess(){
        String req1 = "SELECT * FROM  shopping_cart where user_id = 1 ";
        Double price, qte;
        Double res = 0.0;
        PreparedStatement pst1;
        try {
            pst1 = cnx.prepareStatement(req1);

            ResultSet result = pst1.executeQuery();
            while (result.next()) {
                
                price = result.getDouble("price");
                qte = result.getDouble("quantity");
                String req = "SELECT * FROM produit where id_Produit = ?";
                res = res + price;
                PreparedStatement pst;
                try {
                    pst = cnx.prepareStatement(req);
                    pst.setInt(1, result.getInt("id_Product"));
                    ResultSet result1 = pst.executeQuery();
                    while (result1.next()) {
                        //ImageView prodimg = new ImageView(new Image(this.getClass().getResourceAsStream(result1.getString("image_prod"))));
                        System.out.println( result1.getString("Name_prod"));
                        System.out.println( result1.getString("Prod_Description"));
                                System.out.println(qte+" "+ price) ;
                                        System.out.println(result.getInt("id_Cart") + " id prod is  " +result1.getInt("id_Produit"));
                    }
                } catch (SQLException ex) {               
                    System.out.println(ex.getMessage());
                }
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        

}}

