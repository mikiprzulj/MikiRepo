package ooit;

import java.util.Arrays;

import geometry.Donut;
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
		
		Point p2 = new Point(10, 3);
		// p2.setY(3);
		
		// System.out.println(p2);
		
		// System.out.println(p1.distance(p2));
		p2 = null;
		
		Line l = new Line(new Point(3, 5), p1);			
		// System.out.println(l);
		
		Point center = new Point(0, 0);
		
		Donut krofna1 = new Donut(center, 10, 5);		
		Donut krofna2 = new Donut(center, 100, 5);		
		Donut krofna3 = new Donut(center, 5, 2);
		
		Donut[] krofne = new Donut[] {krofna1, krofna2, krofna3};
		
		for (int i = 0; i < krofne.length; i++) {
			System.out.println(krofne[i]);
		}
		
		Arrays.sort(krofne);

		System.out.println("nakon sortiranja");
		for (int i = 0; i < krofne.length; i++) {
			System.out.println(krofne[i]);
		}
		
		// System.out.println(krofna.contains(new Point(7, 0)));
		// System.out.println(krofna.contains(new Point(4, 0)));
		
		Object[] shapes = new Object[3];
		shapes[0] = p1;
		shapes[1] = l;
		shapes[2] = krofna1;
		
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);			
		}
	}

}
