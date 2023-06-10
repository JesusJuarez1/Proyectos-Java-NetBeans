package todos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTexto {
    public final int OP_INVALIDO = -999_999_999;
    List<OpcionMenu> opciones;
    Scanner teclado;
    String ordenar;
    String[] abc={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","W","x","y","z"};
    int contador=0;
    public MenuTexto(String orden){
        opciones = new ArrayList<>();
        teclado = new Scanner(System.in);
        ordenar=orden;
    }
    public void addOpcion(OpcionMenu nuevaOpcion){
        if(nuevaOpcion != null){
            opciones.add(nuevaOpcion);
        }
    }
    public void addOpcion(String textoOpcion,boolean est){
        OpcionMenu nuevaOpcion = new OpcionMenu(textoOpcion,est);
        addOpcion(nuevaOpcion);
    }
    public String ordenarLetra(){
    	contador++;
    	return abc[contador-1];
    }
    public int ordenarNumero(){
    	contador++;
    	return contador;
    }
    public String getListaOpciones(){
        StringBuilder sb = new StringBuilder();
        if(ordenar == "a"){
        	opciones.forEach(opcion -> sb.append(ordenarLetra()).append(opcion.toString(opcion)).append("\n"));
        }else if(ordenar == "1"){
        	opciones.forEach(opcion -> sb.append(ordenarNumero()).append(opcion.toString(opcion)).append("\n"));
        }
        if(contador == opciones.size()){
            contador=0;
        }
        return sb.toString();
    }

    public String leerOpcion(String mensajePeticion, String mensajeError){
        System.out.println(mensajePeticion);
        System.out.println(getListaOpciones());
        String txtLeido;
        int opLeido;
        txtLeido = teclado.nextLine();
        for (String i:abc) {
            if(i.equals(txtLeido)){
                return txtLeido;
            }
        }
        try{
            opLeido= Integer.parseInt(txtLeido);
        }catch(NumberFormatException nfe){
            System.out.println(mensajeError);
            return "opcion invalida";
        }
        if((opLeido-1)<=opciones.size()){
            return txtLeido;
        }
        return "opcion invalida";
    }
    public int getCantidadOpciones(){
        return opciones.size();
    }
    public String getOpcion(int numOpcion){
        int n = opciones.size();
        if(numOpcion<=n && numOpcion>0){
            OpcionMenu op=opciones.get((numOpcion-1));
        	return op.toString(op);
        }else{
        	return null;
        }
    }
    public String leerOpcion(){
        return leerOpcion("Selecciona la opcion", "Error en la seleccion");
    }
}