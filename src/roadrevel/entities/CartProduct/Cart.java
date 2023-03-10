/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.CartProduct;

import roadrevel.entities.Product.*;
import java.util.Objects;

/**
 *
 * @author Fatma
 */
public class Cart {
    private int id_Cart ;
        private int id_Product ;
    private int id_User ;

    private Double Qte ;
private Double Price ;

    public Cart(int id_Cart, int id_Product, Double Qte, Double Price, int id_User) {
        this.id_Cart = id_Cart;
        this.id_Product = id_Product;
        this.id_User = id_User;
        this.Qte = Qte;
        this.Price = Price;
    }

    public Cart(int id_Product, int id_User, Double Qte, Double Price) {
        this.id_Product = id_Product;
        this.id_User = id_User;
        this.Qte = Qte;
        this.Price = Price;
    }

    public int getId_Cart() {
        return id_Cart;
    }

    public void setId_Cart(int id_Cart) {
        this.id_Cart = id_Cart;
    }

    public int getId_Product() {
        return id_Product;
    }

    public void setId_Product(int id_Product) {
        this.id_Product = id_Product;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public Double getQte() {
        return Qte;
    }

    public void setQte(Double Qte) {
        this.Qte = Qte;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cart other = (Cart) obj;
        if (this.id_Cart != other.id_Cart) {
            return false;
        }
        if (this.id_Product != other.id_Product) {
            return false;
        }
        if (this.id_User != other.id_User) {
            return false;
        }
        if (!Objects.equals(this.Qte, other.Qte)) {
            return false;
        }
        if (!Objects.equals(this.Price, other.Price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" + "id_Cart=" + id_Cart + ", id_Product=" + id_Product + ", id_User=" + id_User + ", Qte=" + Qte + ", Price=" + Price + '}';
    }
  



   
    
    
}
