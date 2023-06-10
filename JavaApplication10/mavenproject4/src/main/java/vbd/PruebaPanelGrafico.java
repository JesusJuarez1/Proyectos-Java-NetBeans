
package vbd;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaPanelGrafico {

    public static void main(String[] args) {
JFrame nuevaVentana= new JFrame();
Container cristal = nuevaVentana.getContentPane();
cristal.add(new PanelDibujoV1());
nuevaVentana.setSize(500,500);
nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
nuevaVentana.setVisible(true);
    }

}
