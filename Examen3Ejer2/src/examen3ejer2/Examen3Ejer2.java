
package examen3ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Examen3Ejer2 {
    ArrayList<String> lista;

    public static void main(String[] args) {
        final String eol="EOL";
        Scanner entrada=new Scanner(System.in);
        String nomArc;
        System.out.println("Ingresa el nombre del archivo junto a su extencion (.txt).");
        nomArc = entrada.nextLine();
        File archivo;
        archivo= new File(nomArc);
        try{
            if(archivo.exists()==false){
                boolean a;
                while((a=archivo.exists())==false){
                    System.out.println("Ingresa el nombre del archivo junto a su extencion (.txt).");
                    nomArc = entrada.nextLine();
                    archivo=new File(nomArc);
                }
            }
            String nomArc2="Salida_"+nomArc;
            File archivo2=new File(nomArc2);
            archivo2.createNewFile();
            FileWriter entra;
            FileReader leAr= new FileReader(archivo);
            BufferedReader lee = new BufferedReader(leAr);
            String lineas="";
            int con=1;
            while((lineas=lee.readLine())!=null){
                //lista.add(lineas);
                entra = new FileWriter(archivo2,true);
                entra.write(con+" "+lineas+" "+eol+"\n");
                entra.close();
                con+=1;
            }
            lee.close();
            
        }catch(IOException ex){
            
        }
    } 

    public Examen3Ejer2() {
        
    }
}
