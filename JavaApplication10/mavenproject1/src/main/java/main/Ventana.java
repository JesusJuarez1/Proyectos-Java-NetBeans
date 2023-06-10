package main;

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

    private final JPanel pnlInferior,pnlInferior2;
    private final JPanel pnlCentral, pnlCentral2,pnlCentral3;
    private final JPanel pnlSuperior,pnlSuperior2;
    private final JLabel etPendiente,etEstado,etFecha;
    JLabel etMostrarPendiente;
    private final JButton btnGuardar;
    private final JButton btnSalir;
    JComboBox<String> estado;
    JTextField txtNomPendiente, txtFecha;
    String[] estados={"ACTIVO","HACIENDO","TERMINADO","CANCELADO","POSPUESTO"};
    Date fecha;

    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cristal;
        cristal = getContentPane();
        cristal.setLayout(new BorderLayout());
        Container cristal2;
        cristal2=getContentPane();
        cristal2.setLayout(new BorderLayout());
        pnlCentral2 = new JPanel();
        pnlSuperior = new JPanel();
        pnlInferior2 = new JPanel();
        cristal2.add(pnlSuperior,BorderLayout.PAGE_START);
        cristal2.add(pnlCentral2,BorderLayout.CENTER);
        cristal2.add(pnlInferior2,BorderLayout.PAGE_END);
        Container cristal3;
        cristal3 = getContentPane();
        cristal3.setLayout(new BorderLayout());
        pnlSuperior2 = new JPanel();
        pnlCentral3 = new JPanel();
        cristal3.add(pnlSuperior2,BorderLayout.PAGE_START);
        cristal3.add(pnlCentral3,BorderLayout.CENTER);

        pnlInferior = new JPanel();
        pnlCentral = new JPanel();

        cristal.add(cristal2,BorderLayout.CENTER);
        cristal.add(cristal3,BorderLayout.PAGE_END);

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
        btnGuardar = new JButton("Guardar");
        txtFecha.setText(date);
        etMostrarPendiente = new JLabel("Aqui se mostrara el pendiente");
        btnSalir = new JButton("Salir");

        pnlCentral.add(etPendiente);
        pnlCentral.add(txtNomPendiente);
        pnlSuperior.add(etEstado);
        pnlSuperior.add(estado);
        pnlCentral2.add(etFecha);
        pnlCentral2.add(txtFecha);
        pnlInferior2.add(btnGuardar);
        pnlSuperior2.add(etMostrarPendiente);
        pnlCentral3.add(btnSalir);
	}
}