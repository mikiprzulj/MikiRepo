package ooit;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class DrawingPanel extends JPanel {
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Line l1 = new Line(new Point(100, 100), new Point(200, 200));
		l1.draw(g);
		
		Line l2 = new Line(new Point(100, 100), new Point(200, 100));
		l2.draw(g);
		
		Rectangle r1 = new Rectangle(new Point(300, 300), 400, 200);
		r1.draw(g);
		
		Circle c1 = new Circle(new Point(200, 200), 150);
		c1.draw(g);
		
		Donut d1 = new Donut(new Point(500, 500), 70, 130);
		d1.draw(g);
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		DrawingPanel panel = new DrawingPanel();
		
		frame.getContentPane().add(panel);		
		frame.setBounds(100, 100, 800, 600);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}

}
