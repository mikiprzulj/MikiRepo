package geometry;

public class Circle {

	private Point center;
	private int radius;
	private boolean selected;
	
	public Circle(Point center, int radius, boolean selected) {
		this.center = center;
		this.radius = radius;
		this.selected = selected;
		
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean contains(Point p) {
		return center.distance(p) <= radius;
			
	}
}
