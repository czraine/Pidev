/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.circuit_touristique.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import roadrevel.circuit_touristique.entities.ReservationCircuit;
import roadrevel.circuit_touristique.utils.DataSource;

/**
 *
 * @author arwar
 */
public class ReservationService {

    private Connection cnx = DataSource.getInstance().getCnx();

    public void ajouter(ReservationCircuit reservationCircuit) {
        String req = "INSERT INTO reservationcircuit(id_client, nc, date_debut_circuit , nbr_places) VALUES('" + reservationCircuit.getId_client() + "', '" + reservationCircuit.getNc() + "','" + reservationCircuit.getDate_debut_circuit() + "','" + reservationCircuit.getNbr_places() + "');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reservation ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
