package geometry;

public class Point {
	
	private int x;
	private int y;
	private boolean selected;
		
	public Point() {
		
	}
	
	public Point(int x, int y) {
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
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public double distance(Point p) {
	
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
				
	}
	
	public void finalize() {
		System.out.println("Brisanje");
	}
	
}
