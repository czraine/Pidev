/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 *
 * @author Nasr
 */
public class Place {
    private Image img ; 
    private Label name ; 
    JFXButton chs ;

    public Place(Image img, Label name, JFXButton chs) {
        this.img = img ;
        this.name = name;
        this.chs = chs;
    }
    
    
    
}
