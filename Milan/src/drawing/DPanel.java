package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DPanel extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	private DFrame frame;
	
	public DPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(e);
			}
		});
	}

	protected void onClick(MouseEvent e) {
		frame.handleClick(e);
	}

	public void setFrame(DFrame frame) {
		this.frame = frame;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}
		
	}
	
	public void addShape(Shape s) {
		shapes.add(s);
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
}
