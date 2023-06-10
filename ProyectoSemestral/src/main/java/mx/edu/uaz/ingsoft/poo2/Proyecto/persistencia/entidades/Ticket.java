package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ticket_table")
public class Ticket implements Serializable{
    private final static long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    @Column
    private String lista;
    @Column
    private double total;
    private final String nombreEmpresa;
    
    public Ticket(){
        nombreEmpresa = "LA TIENDITA";
    }

    public String getListaCompra() {
        return lista;
    }

    public double getTotal() {
        return total;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setListaCompra(String lista) {
        this.lista = lista;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    @Override
    public String toString(){
        return nombreEmpresa+" \n"+lista+"\n TOTAL: "+total+"\n ID de compra: "+idCompra;
    }
    
    public double calcularTotal(List<Productos> listaCompra){
        double totalCompra = 0.0;
        for(Productos p: listaCompra){
            totalCompra += p.getPrecioProduc();
        }
        return totalCompra;
    }
    
    public String obtenerLista(List<Productos> listaCompra){
        String listaSalida = "";
        for(Productos p: listaCompra){
            listaSalida += p.toString()+"\n";
        }
        return listaSalida;
    }
    
}
