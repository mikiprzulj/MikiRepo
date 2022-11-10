package geometry;

import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		super(selected);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}

	public String toString() {
		return startPoint + " -> " + endPoint;
	}

	@Override
	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		double d1 = startPoint.distance(p);
		double d2 = endPoint.distance(p);
		return d1 + d2 - length() < 5;
	}
	
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (selected) {
			Point upperLeft1 = new Point(startPoint.getX() - 2, startPoint.getY() - 2);
			Rectangle r1 = new Rectangle(upperLeft1, 4, 4);
			r1.draw(g);
			Point upperLeft2 = new Point(endPoint.getX() - 2, endPoint.getY() - 2);
			Rectangle r2 = new Rectangle(upperLeft2, 4, 4);
			r2.draw(g);
		}
	}

}
