/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojtable;

import static java.awt.PageAttributes.MediaType.D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHAPARRO
 */
public class Logica {
    
    public DefaultTableModel mostrarClientes()
    {
        String []  nombresColumnas = {"id","Nombre","Telefono","Seleccionado"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM cliente";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("telefono");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    public boolean eliminarRegistro(int id)
    {
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        Connection cn;
        
        PreparedStatement pst;
        
        try
        {
            cn = Conexion.conectar();
            
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            int i = pst.executeUpdate();
            
            return i != 0;
            
        }
        catch(SQLException e )
        {
            System.out.println("Errero al eliminar registro "+e.getMessage());
            
            return false;
        }
    }
    
}
