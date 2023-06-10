package todos;

public class MostrarPendienteMejorado {
    
    public MostrarPendienteMejorado(PendienteMejorado[] listPendiente) {
        for(PendienteMejorado p:listPendiente){
            if(p!=null){
                System.out.println(p.toString());;
            }
        }
    }
    
}
