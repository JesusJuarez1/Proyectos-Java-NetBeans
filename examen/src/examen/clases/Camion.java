
package examen.clases;

public class Camion {
    public Camion(int[] ocupados,int[] capacidad){
        for(int a:ocupados){
            for(int i=0;i<capacidad.length;i++){
                if (capacidad[i]==0 ){
                    capacidad[i]=a;
                    break;
                }
            }
        }
    }
}
