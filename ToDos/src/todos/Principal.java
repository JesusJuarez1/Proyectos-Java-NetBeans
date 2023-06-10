package todos;

import java.util.Date;
import java.util.Scanner;

public class Principal {
    String opcion;
    PendienteMejorado[] listPendiente;
    Scanner entrada;
    Scanner teclado;
    String letraNumero="";
    String txtLeido = "";
    MenuTexto mt;

    public Principal(){
        
        opcion="";
        listPendiente= new PendienteMejorado[5];
        entrada=new Scanner(System.in);
        while(!("n".equals(txtLeido)) | !("l".equals(txtLeido))){
            System.out.println("Ordenar por numero(n) o letra(l)");
            txtLeido = entrada.nextLine();
            if("n".equals(txtLeido)){
                letraNumero="1";
                break;
            }if("l".equals(txtLeido)){
                letraNumero="a";
                break;
            }
        }
        mt = new MenuTexto(letraNumero);
        mt.addOpcion("Capturar pendiente",true);
        mt.addOpcion("Mostrar pendiente",true);
        mt.addOpcion("Eliminar pendiente",true);
        mt.addOpcion("Salir",true);
    }

    public void elegirOpcion(){
        while(!"4".equals(opcion) | !"d".equals(opcion)){
            opcion = mt.leerOpcion();
            if(opcion.equals("1") | opcion.equals("a")){
                for(int i=0;i<listPendiente.length;i++){
                    if(listPendiente[i]!=null){
                        System.out.println("No valido");
                    } else {
                        agregarPendiente(i, listPendiente);
                        System.out.println("Pendiente agregado");
                        break;
                    }
                }
            }if(opcion.equals("2") | opcion.equals("b")){
                MostrarPendienteMejorado mostrar=new MostrarPendienteMejorado(listPendiente);
            }if(opcion.equals("3") | opcion.equals("c")){
                System.out.println("Dime el numero del pendiente a eliminar: ");
                String n="";
                n=entrada.nextLine();
                listPendiente=Pendiente.borrarPendienteMejorado(n,listPendiente);
            }
            if(opcion.equals("4") | opcion.equals("d")){
                break;
            }
        }
    }
    public void agregarPendiente(int i, PendienteMejorado listPendiente[]){
        System.out.println("Escribe la descripcion del pendiente: ");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        entradaTeclado = entradaEscaner.nextLine ();
        boolean estado=colocarEstado();
        Date fecha= new Date();
        listPendiente[i]=new PendienteMejorado(entradaTeclado, estado, fecha);
    }

    public boolean colocarEstado(){
        boolean rep=true;
        boolean b = false;
        while(rep==true){
            System.out.println("Cual es el estado del pendiente A(activo) o I(inactivo): ");
            String estado="";
            Scanner entradaEscaner = new Scanner (System.in);
            estado = entradaEscaner.nextLine();
            if(estado.equals("A")){
                b=true;
                rep=false;
            }else if(estado.equals("I")){
                b=false;
                rep=false;
            }else{
                System.out.println("Error, elige una opcion valida");
            }
        }
        return b;
    }
}