/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.PlaceToVisit;

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
public class ServicePlace implements IService<PlaceToVisit> {

    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(PlaceToVisit p) {
        String req = "INSERT INTO placetovisit(  Place_Name , CityName , Place_Type, Place_Description , Place_Address , Tickets_Price , Place_Img , 	Place_Img2 , 	Place_Img3 ) VALUES( ?,?,? ,? ,? ,? ,? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getPlace_name());
            pst.setString(2, p.getCityname());
            pst.setString(3, p.getPlace_Type());
            pst.setString(4, p.getPlace_Description());
            pst.setString(5, p.getPlace_Address());
            pst.setInt(6, p.getTickets_Price());
            pst.setString(7, p.getPlace_img());
            pst.setString(8, p.getPlace_img2());
            pst.setString(9, p.getPlace_img3());

            pst.executeUpdate();
            System.out.println("placetovisit added  !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(PlaceToVisit p) {
        String req = "UPDATE  placetovisit SET Place_Id=?, Place_Name= ? , CityName= ? , Place_Type= ? , Place_Description=? , Place_Address= ? , Tickets_Price= ? , Place_Img =? , Place_Img2 = ? , Place_Img3 = ?  WHERE Place_Id =?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getPlace_Id());
            pst.setString(2, p.getPlace_name());
            pst.setString(3, p.getCityname());
            pst.setString(4, p.getPlace_Type());
            pst.setString(5, p.getPlace_Description());
            pst.setString(6, p.getPlace_Address());
            pst.setInt(7, p.getTickets_Price());
            pst.setString(8, p.getPlace_img());
            pst.setString(9, p.getPlace_img2());
            pst.setString(10, p.getPlace_img3());
            pst.setInt(11, p.getPlace_Id());

            pst.executeUpdate();
            System.out.println("placetovisit modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(PlaceToVisit p) {
        String req = "DELETE FROM placetovisit WHERE Place_Id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getPlace_Id());
            pst.executeUpdate();
            System.out.println("placetovisit supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<PlaceToVisit> afficher() {
        List<PlaceToVisit> list = new ArrayList<>();

        String req = "SELECT * FROM placetovisit";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                list.add(new PlaceToVisit(result.getInt("Place_Id"), result.getString("Place_Name"), result.getString("CityName"), result.getString("Place_Type"), result.getString("Place_Description"), result.getString("Place_Address"), result.getInt("Tickets_Price"), result.getString("Place_Img"), result.getString("Place_img2"), result.getString("Place_Img3")));
            }
            System.out.println("placetovisit récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public PlaceToVisit Search(String cname) {

        String req = "SELECT * FROM placetovisit where CityName =? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, cname);

            ResultSet result = pst.executeQuery();
            while (result.next()) {
                return new PlaceToVisit(result.getInt("Place_Id"), result.getString("Place_Name"), result.getString("CityName"), result.getString("Place_Type"), result.getString("Place_Description"), result.getString("Place_Address"), result.getInt("Tickets_Price"), result.getString("Place_Img"), result.getString("Place_img2"), result.getString("Place_Img3"));
            }
            System.out.println("placetovisit récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null ;   }
}
