import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class Applet extends JApplet {

	
	
	public void init(){
		
		setBackground(Color.pink);
		
	}
	
	public void start(){
		
		
	}
	
	public void paint(Graphics g){
		
		setBackground(Color.pink);
		g.drawString("Hi Mom", 100, 99);
		
	}
	
}
