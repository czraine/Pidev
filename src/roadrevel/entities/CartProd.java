/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author Nasr
 */
public class CartProd {
    private ImageView img ;
    private String ProdName ;
    private String ProdDescrp ;
    private Double qte ; 
    private Double Price ;
    private int id_Cart ; 
    private int id_User ; 
    private int id_prod ;

    public int getId_Cart() {
        return id_Cart;
    }

    public void setId_Cart(int id_Cart) {
        this.id_Cart = id_Cart;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public CartProd(ImageView img, String ProdName, String ProdDescrp, Double qte, Double Price, int id_Cart, int id_User, int id_prod) {
        this.img = img;
        this.ProdName = ProdName;
        this.ProdDescrp = ProdDescrp;
        this.qte = qte;
        this.Price = Price;
        this.id_Cart = id_Cart;
        this.id_User = id_User;
        this.id_prod = id_prod;
    }

    public CartProd(ImageView img, String ProdName, String ProdDescrp, Double qte, Double Price) {
        this.img = img;
        this.ProdName = ProdName;
        this.ProdDescrp = ProdDescrp;
        this.qte = qte;
        this.Price = Price;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String ProdName) {
        this.ProdName = ProdName;
    }

    public String getProdDescrp() {
        return ProdDescrp;
    }

    public void setProdDescrp(String ProdDescrp) {
        this.ProdDescrp = ProdDescrp;
    }

    public Double getQte() {
        return qte;
    }

    public void setQte(Double qte) {
        this.qte = qte;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }
    
}
