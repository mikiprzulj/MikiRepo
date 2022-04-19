package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;

public class DFrame extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglSelect;
	private JToggleButton tglPoint;
	private JToggleButton tglLine;
	private JToggleButton tglRectangle;
	private JToggleButton tglCircle;
	private JToggleButton tglDonut;
	private DPanel panel;

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
	}
	
	public void handleClick(MouseEvent e) {
		if (tglSelect.isSelected()) {
			System.out.println("Izabrana je selekcija.");
		} else if (tglPoint.isSelected()) {
			Point p = new Point(e.getX(), e.getY());
			panel.addShape(p);			
		} else if (tglLine.isSelected()) {
			System.out.println("Izabrana je linija.");
		} else if (tglRectangle.isSelected()) {
			System.out.println("Izabran je pravougaonik.");
		} else if (tglCircle.isSelected()) {
			System.out.println("Izabran je krug.");
		} else if (tglDonut.isSelected()) {
			System.out.println("Izabrana je krofna.");
		}
		panel.repaint();
	}

}
