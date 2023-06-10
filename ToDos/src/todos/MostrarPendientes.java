package todos;

public class MostrarPendientes {
    
    public MostrarPendientes(Pendiente listPendiente[]){
        for(Pendiente p:listPendiente){
            if(p!=null){
                p.toString();
            }
        }
    }
}
