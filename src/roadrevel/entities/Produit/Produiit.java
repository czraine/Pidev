/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Produit;

import java.util.Objects;

/**
 *
 * @author Fatma
 */
public class Produiit {
    private int id_Produit ;
    private String Name_prod;
    private String Type_prod ;
    private Double Product_Price ;
    private String Qte ;
    private String  Product_img ;
    private String status ;

    public Produiit(int id_Produit) {
        this.id_Produit = id_Produit;
    }

    public Produiit(int id_Produit, String Name_prod, String Type_prod, Double Product_Price, String Qte, String Product_img, String status) {
        this.id_Produit = id_Produit;
        this.Name_prod = Name_prod;
        this.Type_prod = Type_prod;
        this.Product_Price = Product_Price;
        this.Qte = Qte;
        this.Product_img = Product_img;
        this.status = status;
    }

    public Produiit(String Name_prod, String Type_prod, Double Product_Price, String Qte, String Product_img, String status) {
        this.Name_prod = Name_prod;
        this.Type_prod = Type_prod;
        this.Product_Price = Product_Price;
        this.Qte = Qte;
        this.Product_img = Product_img;
        this.status = status;
    }

    public int getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(int id_Produit) {
        this.id_Produit = id_Produit;
    }

    public String getName_prod() {
        return Name_prod;
    }

    public void setName_prod(String Name_prod) {
        this.Name_prod = Name_prod;
    }

    public String getType_prod() {
        return Type_prod;
    }

    public void setType_prod(String Type_prod) {
        this.Type_prod = Type_prod;
    }

    public Double getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(Double Product_Price) {
        this.Product_Price = Product_Price;
    }

    public String getQte() {
        return Qte;
    }

    public void setQte(String Qte) {
        this.Qte = Qte;
    }

    public String getProduct_img() {
        return Product_img;
    }

    public void setProduct_img(String Product_img) {
        this.Product_img = Product_img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produiit other = (Produiit) obj;
        if (this.id_Produit != other.id_Produit) {
            return false;
        }
        if (!Objects.equals(this.Name_prod, other.Name_prod)) {
            return false;
        }
        if (!Objects.equals(this.Type_prod, other.Type_prod)) {
            return false;
        }
        if (!Objects.equals(this.Product_Price, other.Product_Price)) {
            return false;
        }
        if (!Objects.equals(this.Qte, other.Qte)) {
            return false;
        }
        if (!Objects.equals(this.Product_img, other.Product_img)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    @Override
    public String toString() {
        return "Produiit{" + "id_Produit=" + id_Produit + ", Name_prod=" + Name_prod + ", Type_prod=" + Type_prod + ", Product_Price=" + Product_Price + ", Qte=" + Qte + ", Product_img=" + Product_img + ", status=" + status + '}';
    }



   
    
    
}
