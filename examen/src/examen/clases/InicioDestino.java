
package examen.clases;
public class InicioDestino {
    public InicioDestino(int aSubir,int[] capacidad,int m,int n){
        int[] ocupados=new int[aSubir];
        for(int bajar=0;bajar<ocupados.length;bajar++){
            int a=(int)(Math.random()*n+m);
            ocupados[bajar]=a;
        }
        Camion Ba = new Camion(ocupados, capacidad);
    }   
}