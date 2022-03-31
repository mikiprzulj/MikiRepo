package geometry;

public class Donut extends Circle {

	private int innerRadius;

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public boolean contains(Point p) {
		return super.contains(p) && center.distance(p) >= innerRadius;
	}
	
}
