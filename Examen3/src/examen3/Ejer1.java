
package examen3;
import java.io.IOException;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;

public class Ejer1{

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String nomArc;
        System.out.println("Ingresa el nombre del archivo junto a su extencion (.txt).");
        nomArc = entrada.nextLine();
        try{
            File archivo= new File(nomArc);
            archivo.createNewFile();
            FileWriter entra;
            entra = new FileWriter(archivo);
            int contador=0;
            while(contador!=5){
                System.out.println("Ingresa una palabra o frase.");
                String palabra=entrada.nextLine();
                if(palabra.equals("")){
                    System.out.println("No ingresaste texto.");
                    contador-=1;
                }else{
                    entra.write(palabra+"\n");
                }
                contador+=1;
            }
            entra.close();
            
            
        }catch(IOException ex){
            
        }
    }
} 

