/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Produit;

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
 * @author Fatma
 */
public class ServiceProduit implements IService<Produiit>{

        private Connection cnx = DatabaseHandler.getInstance().getCnx();

        @Override
        public void ajouter(Produiit p) {
            String req = "INSERT INTO Produit(Name_prod ,Type_Prod ,Price_prod ,quantité , image_prod , status ) VALUES( ? ,? ,? ,? ,? ,? );";
            try {
                //Statement st = cnx.createStatement();
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, p.getName_prod());
                pst.setString(2, p.getType_prod());
                pst.setDouble(3, p.getProduct_Price());
                pst.setString(4, p.getQte());
                pst.setString(5, p.getProduct_img());
                pst.setString(6, p.getProduct_img());
                pst.executeUpdate();
                System.out.println("produit ajoutée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public void modifier(Produiit p) {
            String req = "UPDATE  Produit SET Name_prod=?, Type_Prod= ? , Price_prod= ? , quantité= ? , image_prod=? , status=? WHERE id_Produit=?";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, p.getName_prod());
                pst.setString(2, p.getType_prod());
                pst.setDouble(3, p.getProduct_Price());
                pst.setString(4, p.getQte());
                pst.setString(5, p.getProduct_img());
                pst.setString(6, p.getProduct_img());
                pst.setInt(7, p.getId_Produit());
                pst.executeUpdate();
                System.out.println("produit modifiée !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public void supprimer(Produiit p) {
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
        public List<Produiit> afficher() {
            List<Produiit> list = new ArrayList<>();

            String req = "SELECT * FROM Produit";
            try {
                PreparedStatement pst = cnx.prepareStatement(req);
                ResultSet result = pst.executeQuery();
                while(result.next()) {
                    list.add(new Produiit(result.getInt("id_Produit"), result.getString("Name_prod"), result.getString("Type_prod"),result.getDouble("Price_prod"), result.getString("quantité"),result.getString("image_prod"), result.getString("status")));
                }
                System.out.println("produit récupérées !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return list;
        }
    }

