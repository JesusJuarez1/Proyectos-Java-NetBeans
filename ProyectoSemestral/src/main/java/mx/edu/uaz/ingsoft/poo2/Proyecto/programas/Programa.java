package mx.edu.uaz.ingsoft.poo2.Proyecto.programas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ClienteDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.Conector;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ProductoDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.TicketDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;
/**
 *
 * @author jesus
 */
public class Programa {
    
    public static void main(String[] args) throws SQLException {
        
        System.out.println("PRODUCTOS!!!!!!! \n");
        ProductoDAO pro = new ProductoDAO();
        Productos unProducto;
        Conector unConector = new Conector();
        unProducto = pro.createProducto("vjsd", 12.5, 30);
        try (Connection connect = unConector.conectar()) {
            pro.saveProducto(unProducto, connect);
            unConector.close();
        }
        //Imprime en pantalla una lista de los prodcutos registrados, el precio de cada uno y el inventario que tienen.
        for(Productos p: pro.findAll(unConector)){
            System.out.println(p.toString());
        }
        
        System.out.println("\n CLIENTE!!!!!!! \n");
        ClienteDAO clien = new ClienteDAO();
        Cliente unCliente;
        unCliente = clien.createCliente("Pedro");
        try(Connection connect = unConector.conectar()){
            clien.saveCliente(unCliente, connect);
            unConector.close();
        }
        //Imprime una lista con los clientes registrados
        for(Cliente c: clien.findAll(unConector)){
            System.out.println(c.toString());
        }
        
        System.out.println("\n TICKET!!!!!!!!! \n");
        TicketDAO ticket = new TicketDAO();
        Ticket unTicket;
        unProducto = null;
        List<Productos> compraProductos;
        compraProductos = new ArrayList<>();
        compraProductos.add(pro.findById(13, unConector));
        compraProductos.add(pro.findById(16, unConector));
        compraProductos.add(pro.findById(29, unConector));
        unTicket = ticket.createTicket(compraProductos);
        try(Connection connect = unConector.conectar()){
            ticket.saveTicket(unTicket, connect);
            unConector.close();
        }
        //Imprime una lista de todos los ticket que estan guardados en la base de datos.
        for(Ticket t: ticket.findAll(unConector)){
            System.out.println(t.toString());
            System.out.println("****************************");
        }
        //Le pasamos el id del producto que deseamos eliminar y tambine le pasamos el conector con la base de datos
        //pro.delete(11, unConnect);
        
        //Le pasamos el id del producto que deseamos actualizar y tambine le pasamos el conector con la base de datos
        //pro.update(17, unConnect, "sddj",2.3, 1); 
    }
    
}