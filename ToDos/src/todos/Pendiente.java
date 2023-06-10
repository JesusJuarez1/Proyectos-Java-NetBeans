package todos;

import java.util.Scanner;

public class Pendiente {
    private String descripcion;
    private boolean estado;

    public Pendiente(String descripcion,boolean estado){
        this.descripcion=descripcion;
        this.estado=estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString(){
        return "Pendiente: "+getDescripcion()+"--->"+getEstado();
    }
    
    public static Pendiente[] borrarPendiente(String n, Pendiente[] listPendiente) {
        int num,i;
        num=Integer.parseInt(n);
        listPendiente[num]=null;
        return listPendiente;
    }
    public static PendienteMejorado[] borrarPendienteMejorado(String n, PendienteMejorado[] listPendiente) {
        int num,i;
        num=Integer.parseInt(n);
        listPendiente[num-1]=null;
        return listPendiente;
    }
    
    
}
