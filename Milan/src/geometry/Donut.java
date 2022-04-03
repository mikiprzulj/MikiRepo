package geometry;

public class Donut extends Circle implements Comparable {

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
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(new Point(x, y)) >= innerRadius;
	}

	@Override
	public double area() {
		return super.area() - Math.PI * innerRadius * innerRadius;
	}
	
	@Override
	public int compareTo(Object o) {
		Donut d = (Donut)o;	
		return (int)(this.area() - d.area());
	}
	
	@Override
	public String toString() {
		return "r = " + radius + ", ir = " + innerRadius;
	}
}
