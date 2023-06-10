
package examen.clases;

public class Paradas {
    int capacidad[] = new int[10];
    int m,n;
    public Paradas(){
        int num=0;
        String[] paradas = {"Zacatecas", "Fresnillo", "Valparaiso","Huejuquilla"};
        
        for (String posicion : paradas) {
            if("Zacatecas".equals(posicion)){
                m=1;
                n=3;
                System.out.println("ZACATECAS:");
                int aSubir=(int)(Math.random()*10);
                System.out.println("Personas a subir: "+aSubir);
                int subir=10-aSubir;
                System.out.println("Lugares Disponibles: "+subir);
                InicioDestino persona=new InicioDestino(aSubir,capacidad,m,n);
            }
            
            if("Fresnillo".equals(posicion)){
                m=2;
                n=2;
                System.out.println("FRESNILLO:");
                int aSubir=(int)(Math.random()*10);
                int cont=0;
                int cont2=0;
                for(int a=0;a<capacidad.length;a++){
                    if(capacidad[a]==1){
                        capacidad[a]=0;
                        cont2+=1;
                    }
                }
                for(int i:capacidad){
                    if(i==0){
                    cont+=1;
                    }
                }
                System.out.println("Bajaron: "+cont2+" personas.\n"+"Lugares Disponibles: "+cont);
                System.out.println("Personas a subir: "+aSubir);
                if(aSubir>cont){
                    int a=aSubir-cont;
                    System.out.println("No caben todas las personas. Se quedaron "+a+" personas");
                    aSubir=cont;
                    InicioDestino persona=new InicioDestino(aSubir,capacidad,m,n);
                }else{
                    InicioDestino persona=new InicioDestino(aSubir,capacidad,m,n);
                }
            }

            if("Valparaiso".equals(posicion)){
                m=3;
                n=1;
                System.out.println("VALPARAISO: ");
                int aSubir=(int)(Math.random()*10);
                int cont=0;
                int cont2=0;
                for(int a=0;a<capacidad.length;a++){
                    if(capacidad[a]==2){
                        capacidad[a]=0;
                        cont2+=1;
                    }
                }
                for(int i:capacidad){
                    if(i==0){
                    cont+=1;
                    }
                }
                System.out.println("Bajaron: "+cont2+" personas \n"+"Lugares Disponibles: "+cont);
                System.out.println("Personas a subir: "+aSubir);
                if(aSubir>cont){
                    int a=aSubir-cont;
                    System.out.println("No caben todas las personas. Se quedaron "+a+" personas");
                    aSubir=cont;
                    InicioDestino persona=new InicioDestino(aSubir,capacidad,m,n);
                }else{
                    InicioDestino persona=new InicioDestino(aSubir,capacidad,m,n);
                }
            }
            
             if("Huejuquilla".equals(posicion)){
                System.out.println("HUEJUQUILLA:");
                int cont=0;
                int cont2=0;
                for(int a=0;a<capacidad.length;a++){
                    if(capacidad[a]==3){
                        capacidad[a]=0;
                        cont2+=1;
                    }
                    if(capacidad[a]==0){
                        cont+=1;
                    }
                }
                System.out.println("Bajaron: "+cont2+" personas \n"+"Lugares Disponibles: "+cont+"\n"+"FIN DEL TRAYECTO");
                
            }
        }
    }
}


