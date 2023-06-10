import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaCliente extends JFrame {
    JPanel pnlSuperior,pnlInferior,pnlCentral,pnlInfCen;
    JLabel etIP,etNum,etRespuesta;
    JTextField txtIP;
    JTextArea txtRespuesta;
    JComboBox numero;
    JButton btnEnviar;
    String iP;
    public static int num;
    public VentanaCliente(){
        super("Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container cristal;
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        pnlSuperior = new JPanel();
        pnlInferior = new JPanel();
        pnlCentral = new JPanel();
        cristal.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal.add(pnlInferior,BorderLayout.PAGE_END);
        cristal.add(pnlCentral,BorderLayout.CENTER);

        etIP = new JLabel("IP: ");
        txtIP = new JTextField(20);
        txtIP.setColumns(20);
        pnlSuperior.add(etIP);
        pnlSuperior.add(txtIP);
        etNum = new JLabel("Numero ");
        numero= new JComboBox();
        numero.addItem("1");
        numero.addItem("2");
        numero.addItem("3");
        pnlCentral.add(etNum);
        pnlCentral.add(numero);
        pnlInfCen= new JPanel();
        pnlCentral.add(pnlInfCen,BorderLayout.PAGE_END);
        
        btnEnviar = new JButton("Enviar");
        pnlInfCen.add(btnEnviar);
        
        etRespuesta= new JLabel("Respuesta: ");
        txtRespuesta=new JTextArea(4,20);
        pnlInferior.add(etRespuesta);
        pnlInferior.add(txtRespuesta);
        
        btnEnviar.addActionListener((ActionEvent e)->{
            iP= txtIP.getText();
            try{
                   num=Integer.parseInt(numero.getSelectedItem().toString());
            }catch(NumberFormatException nfe){
            
            }try {
                //System.out.println("holaaaaaa");
		Socket s1 = new Socket(iP, 5430);
		InputStream is = s1.getInputStream();
		DataInputStream dis = new DataInputStream(is);
                System.out.println(dis.readLine());
		txtRespuesta.setText(dis.readLine());
                //Servidor a;
                //a= new Servidor(num);
                //txtRespuesta.setText(a.toString());
		dis.close();
		s1.close();
            } catch (ConnectException connExc) {
		System.out.println(connExc+"  pidhfnanbfoñsbcn");
            } catch (IOException ex) {
		
            }  
        }
        );
    }
}