/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.Main;

import roadrevel.entities.User.ServiceUser;


/**
 *
 * @author abdel
 */
public class MainProg {
    
    public static void main(String[] args) {
        ServiceUser sp1 = new ServiceUser();
        //sp1.ajouter(new Personne("Fedi", "Ahmed"));
        //sp1.modifier(new Personne(1, "Zaher", "Hamdi"));
        //sp1.supprimer(new Personne(1));
        System.out.println(sp1.afficher().get(0).getUserName());
        
	}


        
     
    }

