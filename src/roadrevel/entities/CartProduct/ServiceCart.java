package roadrevel.entities.CartProduct;



import roadrevel.entities.Product.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.CartProd;
import roadrevel.entities.Product.Product;
import roadrevel.resources.IService;

/**
 *
 * @author Fatma
 */
public class ServiceCart implements IService<Cart>{

    private Connection cnx = DatabaseHandler.getInstance().getCnx();

    public void ajouter(Cart p) {
        String req = "INSERT INTO shopping_cart(id_Product  ,price,quantity,user_id  ) VALUES( ?,? ,? ,?);";
        try {
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setDouble(2, p.getPrice());
            pst.setDouble(3, p.getQte());
            pst.setInt(4, p.getId_User());
            pst.setInt(1, p.getId_Product());
            pst.executeUpdate();
            System.out.println("item added to the cart !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(Cart p) {
        String req = "UPDATE  shopping_cart SET price=?, quantity= ? WHERE id_Cart=? and  user_id= ? and id_Product=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setDouble(1, p.getPrice());
            pst.setDouble(2, p.getQte());
            pst.setInt(3, p.getId_Cart());
            pst.setInt(4, p.getId_User());
            pst.setInt(5, p.getId_Product());
            pst.executeUpdate();
            System.out.println("cart modified !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Cart p) {
        String req = "DELETE FROM shopping_cart WHERE id_Cart=? and user_id=? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId_Cart());
            pst.setInt(2, p.getId_User());

            pst.executeUpdate();
            System.out.println("product deleted from cart!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void supprimer(CartProd p) {
        String req = "DELETE FROM shopping_cart WHERE id_Cart=? and user_id=?  and  id_Product=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId_Cart());
            pst.setInt(2, p.getId_User());
            pst.setInt(3, p.getId_prod());

            pst.executeUpdate();
            System.out.println("product deleted from cart!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Cart> afficher() {
        List<Cart> list = new ArrayList<>();

        String req = "SELECT * FROM shopping_cart";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                list.add(new Cart(result.getInt("id_Cart"), result.getInt("id_Product"), result.getDouble("price"), result.getDouble("quantity"), result.getInt("id_User")));
            }
            System.out.println("produit récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }




}
