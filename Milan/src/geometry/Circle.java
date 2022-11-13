package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	// test push
	protected Point center;
	protected int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		super(selected);
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean contains(int x, int y) {
		return center.distance(new Point(x, y)) <= radius;		
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		if (selected) {
			Point north = new Point(center.getX(), center.getY() - radius, true);
			north.draw(g);
			
			Point south = new Point(center.getX(), center.getY() + radius, true);
			south.draw(g);
			
			Point west = new Point(center.getX() - radius, center.getY(), true);
			west.draw(g);
			
			Point east = new Point(center.getX() + radius, center.getY(), true);
			east.draw(g);
		}
	}
	

}
