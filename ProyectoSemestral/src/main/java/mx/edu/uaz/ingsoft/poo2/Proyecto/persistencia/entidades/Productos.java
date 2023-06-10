package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="producto_table")
public class Productos implements Serializable{
    
    private final static long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduc;
    @Column
    private String nombreProduc;
    @Column
    private double precioProduc;
    @Column
    private int cantidadProduc;
    
    public Productos(){
        
    }
    
    public String getNombreProduc(){
        return nombreProduc;
    }
    
    public void setNombreProduc(String nombreProduc){
        this.nombreProduc = nombreProduc;
    }
    
    public Integer getIdProduc(){
        return idProduc;
    }
    
    public void setIdProduc(Integer idProduc){
        this.idProduc = idProduc;
    }
    
    public double getPrecioProduc(){
        return precioProduc;
    }
    
    public void setPrecioProduc(double presioProduc){
        this.precioProduc = presioProduc;
    }
    
    public int getCantidadProduc(){
        return cantidadProduc;
    }
    
    public void setCantidadProduc(int cantidadProduc){
        this.cantidadProduc = cantidadProduc;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombreProduc + "\t Precio: "+precioProduc + "\t ID: "+idProduc;
    }
}
