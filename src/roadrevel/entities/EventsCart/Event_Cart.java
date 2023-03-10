/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities.Cart;

/**
 *
 * @author GAMING A15
 */
public class Event_Cart {
    
    private int cart_id ;
    private int Event_id;
    private int User_id ;
    private float Total_Price; 

    public Event_Cart(int cart_id, int Event_id, int User_id, float Total_Price) {
        this.cart_id = cart_id;
        this.Event_id = Event_id;
        this.User_id = User_id;
        this.Total_Price = Total_Price;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getEvent_id() {
        return Event_id;
    }

    public void setEvent_id(int Event_id) {
        this.Event_id = Event_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public float getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(float Total_Price) {
        this.Total_Price = Total_Price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event_Cart other = (Event_Cart) obj;
        if (this.cart_id != other.cart_id) {
            return false;
        }
        if (this.Event_id != other.Event_id) {
            return false;
        }
        if (this.User_id != other.User_id) {
            return false;
        }
        if (Float.floatToIntBits(this.Total_Price) != Float.floatToIntBits(other.Total_Price)) {
            return false;
        }
        return true;
    }

    
    
   

    @Override
    public String toString() {
        return "Cart{" + "cart_id=" + cart_id + ", Event_id=" + Event_id + ", User_id=" + User_id + ", Total_Price=" + Total_Price + '}';
    }
    
    
    
    
    
}
