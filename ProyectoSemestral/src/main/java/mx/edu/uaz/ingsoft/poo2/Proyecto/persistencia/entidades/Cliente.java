package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="cliente_table")
public class Cliente implements Serializable{
    
    private final static long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column
    private String nombreCliente;
    
    public Cliente(){
        
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreClien){
        this.nombreCliente = nombreClien;
    }
    
    public Integer getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(Integer idCliente){
        this.idCliente = idCliente;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombreCliente;
    }
    
    /*public void comprar(Ticket unTicket,TicketDAO ticket){
        if(unTicket.getListaProductos().isEmpty() == true){
            System.out.println("Agrega un producto para poder hacer la compra");
        }else{
            ticket.createTicket(unTicket);
            int cantidad;
            for(Productos p: unTicket.getListaProductos()){
                cantidad=p.getCantidadProduc()-1;
                p.setCantidadProduc(cantidad);
            }
        }
    }*/
}
