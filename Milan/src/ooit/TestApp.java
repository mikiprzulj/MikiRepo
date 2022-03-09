package ooit;

import geometry.Line;
import geometry.Point;

public class TestApp {

	public static void main(String[] args) {
		Car redFerrari = new Car();
		Car yellowLambo = new Car();
				
		redFerrari.addFuel(5.5);
		yellowLambo.setLocked(true);
		
		if (!redFerrari.isLocked()) {
			redFerrari.addFuel(3.5);
		}
		
		Point p1 = new Point();
		p1.setX(4);
		
		Point p2 = new Point(0, 3);
		// p2.setY(3);
		
		System.out.println(p1.distance(p2));
		p2 = null;
		
		Line l = new Line(new Point(3, 5), p1);			
		System.out.println(l.length());
	}

}
