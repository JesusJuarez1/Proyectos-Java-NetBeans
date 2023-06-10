import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.JComboBox;

public class Ventana extends JFrame{

	private final JPanel pnlInferior;
    private final JPanel pnlCentral, pnlCentral2;
    private final JPanel pnlSuperior,pnlSuperior2,pnlSuperior3;
    private final JLabel etPendiente,etEstado,etFecha;
    JLabel etMostrarPendiente;
    private final JButton btnGuardar;
    private final JButton btnSalir;
    JComboBox<String> estado;
    JTextField txtNomPendiente, txtFecha;
    String[] estados={"ACTIVO","HACIENDO","TERMINADO","CANCELADO","POSPUESTO"};
    Date fecha;

	public Ventana(){
		super("ToDos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cristal,cristal2,cristal3;
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        cristal2 = getContentPane();
        cristal2.setLayout(new BorderLayout());
        cristal.add(cristal2,BorderLayout.CENTER);
        cristal3 = getContentPane();
        cristal3.setLayout(new BorderLayout());
        cristal.add(cristal3,BorderLayout.PAGE_END);

        pnlSuperior = new JPanel();
        pnlSuperior2 = new JPanel();
        pnlCentral = new JPanel();
        pnlInferior = new JPanel();
        pnlSuperior3 = new JPanel();
        pnlCentral2 = new JPanel();

        cristal.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal2.add(pnlSuperior2,BorderLayout.PAGE_START);
        cristal2.add(pnlCentral,BorderLayout.CENTER);
        cristal2.add(pnlInferior,BorderLayout.PAGE_END);
        cristal3.add(pnlSuperior3,BorderLayout.PAGE_START);
        cristal3.add(pnlCentral2,BorderLayout.CENTER);

        etPendiente = new JLabel("Descripcion: ");
        txtNomPendiente = new JTextField(20);
        txtNomPendiente.setColumns(20);
        etEstado = new JLabel("Estado: ");
        estado = new JComboBox(estados);
        estado.setEditable(true);
        etFecha = new JLabel("Fecha Planeada: ");
        txtFecha = new JTextField(20);
        txtFecha.setColumns(10);
        fecha = new Date();
        String date ="";
        date+=fecha;
        txtFecha.setText(date);
        btnGuardar = new JButton("Guardar");
        etMostrarPendiente = new JLabel("Aqui se mostrara el pendiente");
        btnSalir = new JButton("Salir");

        pnlSuperior.add(etPendiente);
        pnlSuperior.add(txtNomPendiente);
        pnlSuperior2.add(etEstado);
        pnlSuperior2.add(estado);
        pnlCentral.add(etFecha);
        pnlCentral.add(txtFecha);
        pnlInferior.add(btnGuardar);
        pnlSuperior3.add(etMostrarPendiente);
        pnlCentral2.add(btnSalir);
	}
}