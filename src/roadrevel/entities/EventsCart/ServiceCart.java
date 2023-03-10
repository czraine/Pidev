/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities.Cart;

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
public class ServiceCart implements IService<Event_Cart> {

    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    @Override
    public void ajouter(Event_Cart c) {
        String req = "INSERT INTO event_cart(cart_id , Event_id, User_id, Total_Price) VALUES( ?, ? ,?, ? );";
        try {

            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(1, c.getCart_id());
            pst.setInt(2, c.getEvent_id());
            pst.setInt(3, c.getUser_id());
            pst.setFloat(4, c.getTotal_Price());

            pst.executeUpdate();

            System.out.println("Cart ajoutée !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Event_Cart c) {
        String req = "UPDATE  event_cart SET Event_id= ?  , User_id = ?, Total_Price=?  WHERE cart_id =?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(4, c.getCart_id());
            pst.setInt(1, c.getEvent_id());
            pst.setInt(2, c.getUser_id());
            pst.setFloat(3, c.getTotal_Price());

            pst.executeUpdate();

            System.out.println("Cart modifiée !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Event_Cart c) {
        String req = "DELETE FROM event_cart WHERE cart_id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getCart_id());
            pst.executeUpdate();
            System.out.println("Cart supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Event_Cart> afficher() {
        List<Event_Cart> list = new ArrayList<>();

        String req = "SELECT * FROM event_cart";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                list.add(new Event_Cart(result.getInt("cart_id"), result.getInt("Event_id"), result.getInt("User_id"), result.getFloat("Total_Price")));
            }
            System.out.println("Cart récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
