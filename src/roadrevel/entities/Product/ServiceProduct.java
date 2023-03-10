/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Product.Product;
import roadrevel.resources.IService;

/**
 *
 * @author Fatma
 */
public class ServiceProduct implements IService<Product>{

        private Connection cnx = DatabaseHandler.getInstance().getCnx();

        @Override
        public void ajouter(Product p) {
            String req = "INSERT INTO produit(Name_prod ,Prod_Description,Type_Prod ,Price_prod ,quantité , image_prod , status ) VALUES( ?,? ,? ,? ,? ,? ,? );";
            try {
                //Statement st = cnx.createStatement();
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, p.getName_prod());
                pst.setString(2, p.getProdDescrp());
                pst.setString(3, p.getType_prod());
                pst.setDouble(4, p.getProduct_Price());
                pst.setDouble(5, p.getQte());
                pst.setString(6, p.getProduct_img());
                pst.setString(7, p.getStatus());
                pst.executeUpdate();
                System.out.println("produit ajoutée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public void modifier(Product p) {
            String req = "UPDATE  Produit SET Name_prod=?,Prod_Description=?, Type_Prod= ? , Price_prod= ? , quantité= ? , image_prod=? , status=? WHERE id_Produit=?";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, p.getName_prod());
                pst.setString(2, p.getType_prod());
                pst.setDouble(3, p.getProduct_Price());
                pst.setDouble(4, p.getQte());
                pst.setString(5, p.getProduct_img());
                pst.setString(6, p.getStatus());
                pst.setInt(7, p.getId_Produit());
                pst.executeUpdate();
                System.out.println("produit modifiée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        public void modifier(int id_prod , Double qte){
             String req = "UPDATE  Produit SET quantité= ?  WHERE id_Produit=?";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);

                pst.setDouble(1, qte);

                pst.setInt(2, id_prod);
                pst.executeUpdate();
                System.out.println("produit modifiée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        
        }

        @Override
        public void supprimer(Product p) {
            String req = "DELETE FROM produit WHERE id_Produit=?";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setInt(1, p.getId_Produit());
                pst.executeUpdate();
                System.out.println("produit supprimée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public List<Product> afficher() {
            List<Product> list = new ArrayList<>();

            String req = "SELECT * FROM Produit";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                ResultSet result = pst.executeQuery();
                while(result.next()) {
                    list.add(new Product(result.getInt("id_Produit"), result.getString("Name_prod"), result.getString("Prod_Description"), result.getString("Type_prod"),result.getDouble("Price_prod"), result.getDouble("quantité"),result.getString("image_prod"), result.getString("status")));
                }
                System.out.println("produit récupérées !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return list;
        }
    }

