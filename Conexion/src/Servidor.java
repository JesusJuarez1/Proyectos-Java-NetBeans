
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
    public static void main(String[] args){
        ServerSocket s = null;
	try {
            s = new ServerSocket(5430);
	} catch (IOException e) {
            e.printStackTrace();
	}
	while (true) {
            try {
                System.out.println("haobcsnoakn");
		Socket s1;
                s1 = s.accept();
		InputStreamReader si;
                si = new InputStreamReader(s1.getInputStream());
                OutputStreamWriter so;
                so = new OutputStreamWriter(s1.getOutputStream());
                char[] buffe=new char[254];
                si.read(buffe,0,254);
                switch (VentanaCliente.num) {
                    case 1:
                        System.out.println("haobcsnoakn");
                        so.write("Hola");
                        break;
                    case 2:
                        System.out.println("haobcsnoakn");
                        so.write("Bienvenido");
                        break;
                    case 3:
                        System.out.println("haobcsnoakn");
                        so.write("Adios");
                        break;
                    default:
                        System.out.println("haobcsnoakn");
                        so.write("Adios");
                        break;
                }
                so.close();
                s1.close();
            } catch (IOException e) {
		e.printStackTrace();
            } 
	}
    }
}