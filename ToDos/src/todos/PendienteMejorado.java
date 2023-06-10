package todos;
import java.util.Date;

public class PendienteMejorado extends Pendiente {
    private Date fecha;
    public PendienteMejorado(String descripcion, boolean estado,Date fecha) {
        super(descripcion, estado);
        this.fecha=fecha;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setDate(){
        this.fecha=fecha;
    }
    
    public String toString(){
        return super.toString()+"---> Fecha: "+fecha.toString();
    }
}