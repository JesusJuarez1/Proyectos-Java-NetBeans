/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesus
 */
public class Conector {
    private Connection connect;
    
    //Se conecta con la base de datos y regresa la conexion.
    public Connection conectar(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:Proyecto.db");
            if (connect!=null) {
                //System.out.println("Conectado");
                return connect;
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
        return null;
    }
    
    //Se desconecta de la base de datos.
    public void close(){
        try {
            connect.close();
            //System.out.println("Desconectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
