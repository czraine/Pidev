/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Favourites;

import roadrevel.entities.Produit.Reviews.*;
import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class Favourites {
    private int  id_Favs ;
        private int  id_User ;
            private int  id_Place ;

    public Favourites(int id_User, int id_Place) {
        this.id_User = id_User;
        this.id_Place = id_Place;
    }

    public Favourites(int id_Favs, int id_User, int id_Place) {
        this.id_Favs = id_Favs;
        this.id_User = id_User;
        this.id_Place = id_Place;
    }

    public int getId_Favs() {
        return id_Favs;
    }

    public void setId_Favs(int id_Favs) {
        this.id_Favs = id_Favs;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getId_Place() {
        return id_Place;
    }

    public void setId_Place(int id_Place) {
        this.id_Place = id_Place;
    }


}
