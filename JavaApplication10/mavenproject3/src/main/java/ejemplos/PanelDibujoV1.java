import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelDibujoV1 extends JPanel{
	private int inicioXEstrella;
	private int inicioYEstrella;
	private int anchoEtrella;
	private int altoEstrella;
	private int polyX[];
	private int polyY[];
	public PanelDibujoV1(){
		inicioXEstrella=300;
		inicioYEstrella=70;
		anchoEtrella=100;
		altoEstrella=100;
		polyX= new int[5];
		polyY= new int[5];
	}
	public void setAnchoAltoEstrella(int ancho, int alto){
		anchoEtrella=ancho;
		altoEstrella=alto;
		calcularPosicionesEstrella();
		repaint();
	}
	public void setXYEstrella(int x, int y){
		inicioXEstrella=x;
		inicioYEstrella=y;
		calcularPosicionesEstrella();
		repaint();
	}
	private void calcularPosicionesEstrella(){
		int alto3y4=(int)(altoEstrella/3);
		polyX[0]=inicioXEstrella+(anchoEtrella/2); polyY[0]=inicioYEstrella;
		polyX[1]=inicioXEstrella+anchoEtrella; polyY[1]=inicioYEstrella+altoEstrella;
		polyX[2]=inicioXEstrella; polyY[2]=inicioYEstrella+alto3y4;
		polyX[3]=inicioXEstrella+anchoEtrella; polyY[3]=inicioYEstrella+alto3y4;
		polyX[4]=inicioXEstrella; polyY[4]=inicioYEstrella+altoEstrella;
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawString("Opciones de dibujo",20,50);
		g2d.drawLine(200,50,400,50);
		g2d.drawRect(20,70,100,50);
		g2d.drawArc(20,140,100,50);
		g2d.drawOval(150,140,100,50);
		g2d.drawPolygon(polyX,polyY,5);
		g2d.drawOval(150,250,200,200);
		g2d.drawOval(200,310,30,30);
		g2d.drawOval(270,310,30,30);
		g2d.drawArc(200,350,100,50,180,180);
		g2d.drawRect(240,400,10,15);
		g2d.drawRect(250,400,10,15);
	}
}
