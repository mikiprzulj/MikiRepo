package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import gui.CircleDialog;
import gui.DonutDialog;
import gui.RectangleDialog;

import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DFrame extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglSelect;
	private JToggleButton tglPoint;
	private JToggleButton tglLine;
	private JToggleButton tglRectangle;
	private JToggleButton tglCircle;
	private JToggleButton tglDonut;
	private DPanel panel;
	private Point startPoint;
	private JButton btnDelete;
	private JButton btnModify;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DFrame frame = new DFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new DPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setFrame(this);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		tglSelect = new JToggleButton("Select");
		toolBar.add(tglSelect);
		
		tglPoint = new JToggleButton("Point");
		toolBar.add(tglPoint);
		
		tglLine = new JToggleButton("Line");
		toolBar.add(tglLine);
		
		tglRectangle = new JToggleButton("Rectangle");
		toolBar.add(tglRectangle);
		
		tglCircle = new JToggleButton("Circle");
		toolBar.add(tglCircle);
		
		tglDonut = new JToggleButton("Donut");
		toolBar.add(tglDonut);
	
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(tglSelect);
		buttonGroup.add(tglPoint);
		buttonGroup.add(tglLine);
		buttonGroup.add(tglRectangle);
		buttonGroup.add(tglCircle);
		buttonGroup.add(tglDonut);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<Shape> it = panel.getShapes().iterator();
				while (it.hasNext()) {
					Shape s = it.next();
					if (s.isSelected()) {
						it.remove();
					}
				}
				panel.repaint();
			}
		});
		toolBar.add(btnDelete);
		
		btnModify = new JButton("Modify");
		toolBar.add(btnModify);
		// String strRadius = String.valueOf(radius);
	}
	
	public void handleClick(MouseEvent e) {
		if (tglSelect.isSelected()) {
			Iterator<Shape> it = panel.getShapes().iterator();
			while (it.hasNext()) {
				Shape s = it.next();
				s.setSelected(s.contains(e.getX(), e.getY()));
			}
		} else if (tglPoint.isSelected()) {
			Point p = new Point(e.getX(), e.getY());
			panel.addShape(p);			
		} else if (tglLine.isSelected()) {
			if (startPoint == null) {
				startPoint = new Point(e.getX(), e.getY());
			} else {
				Line l = new Line(startPoint, new Point(e.getX(), e.getY()));
				panel.addShape(l);
				startPoint = null;
			}

		} else if (tglRectangle.isSelected()) {
			RectangleDialog dlg = new RectangleDialog();
			dlg.setVisible(true);
			int width = dlg.getRectWidth();
			int height = dlg.getRectHeight();
			if (width > 0) {
				Rectangle r = new Rectangle(new Point(e.getX(), e.getY()), width, height);
				panel.addShape(r);
			}
			
		} else if (tglCircle.isSelected()) {
			CircleDialog dlg = new CircleDialog();
			dlg.setVisible(true);
			int radius = dlg.getRadius();
			if (radius > 0) {
				Circle c = new Circle(new Point(e.getX(), e.getY()), radius);
				panel.addShape(c);	
			}
			
		} else if (tglDonut.isSelected()) {
			DonutDialog dlg = new DonutDialog();
			dlg.setVisible(true);
			int innerRadius = dlg.getInnerRadius();
			int outerRadius = dlg.getOuterRadius();
			if (outerRadius > 0 && innerRadius > 0) {
				Donut d = new Donut(new Point(e.getX(), e.getY()), outerRadius, innerRadius);
				panel.addShape(d);
			}
		}
		panel.repaint();
	}

}
