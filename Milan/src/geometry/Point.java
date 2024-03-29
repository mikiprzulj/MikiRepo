package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Point extends Shape {
	
	private int x;
	private int y;
		
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		super(selected);
		this.x = x;
		this.y = y;	
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public double distance(Point p) {
	
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
				
	}
	
	public void finalize() {
		System.out.println("Brisanje");
	}

	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		return this.distance(p) < 3;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x-1, y, x+1, y);
		g.drawLine(x, y-1, x, y+1);
		if (selected) {
			Point upperLeft = new Point(this.x - 3, this.y - 3);
			Rectangle r = new Rectangle(upperLeft, 6, 6);
			Color previousColor = g.getColor(); 
			g.setColor(Color.BLUE);
			r.draw(g);
			g.setColor(previousColor);
		}
	}
	
}
