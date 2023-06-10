package todos;
import java.util.List;

public class OpcionMenu {

    private String textoMenu;
    private boolean estado;
    int contador;
    public OpcionMenu(String texto, boolean est){
        textoMenu = texto;
        estado = est;
    }

    public String getTextoMenu() {
        return textoMenu;
    }

    public void setTextoMenu(String textoMenu) {
        this.textoMenu = textoMenu;
    }

    public boolean getEstado(){
    	return estado;
    }

    public void setEstado(boolean estado){
    	this.estado = estado;
    }

    public String toString(OpcionMenu opcion){
    	if(opcion.getEstado()==true){

    		return String.format(".-%s", textoMenu);
    	}else{
    		return String.format("*.-%s", textoMenu);
    	}
        
    }
}