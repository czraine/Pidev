/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Favourites;


import roadrevel.entities.Produit.Reviews.*;
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
public class ServiceFavourites implements IService<Favourites>{
 
    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(Favourites p) {
        String req = "INSERT INTO user_favsplaces(id_User ,id_Place ) VALUES(? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);

            
            pst.setInt(1, p.getId_User());
            pst.setInt(2, p.getId_Place());

            pst.executeUpdate();
            System.out.println("Favourite ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void modifier(Favourites p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Favourites p) {
        String req = "DELETE FROM user_favsplaces WHERE id_User=? and id_Place=? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId_User());
            pst.setInt(2, p.getId_Place());
            pst.executeUpdate();
            System.out.println("Favourite removed !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public List<Favourites> afficher() {
        List<Favourites> list = new ArrayList<>();
        
        String req = "SELECT * FROM user_favsplaces";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Favourites(result.getInt("id_Favs"),result.getInt("id_User"),result.getInt("id_Place")));
            }
            System.out.println("placetovisit récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;    }
        public boolean validate(int uid , int pid) {
         
        String vd = "SELECT * FROM user_favsplaces WHERE id_User= ? and id_Place= ?";
        try {
        PreparedStatement pst = cnx.prepareStatement(vd);
            pst.setInt(1,uid);
            pst.setInt(2, pid);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false ;
    }
                public boolean checkfavs(int uid ) {
         
        String vd = "SELECT * FROM user_favsplaces WHERE id_User= ?";
        try {
        PreparedStatement pst = cnx.prepareStatement(vd);
            pst.setInt(1,uid);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false ;
    }

}

