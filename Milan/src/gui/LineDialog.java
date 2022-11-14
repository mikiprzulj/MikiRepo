package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStartPointX;
	private JTextField txtStartPointY;
	private JTextField txtEndPointX;
	private JTextField txtEndPointY;
	private Line line;
	
	public LineDialog(Line line) {
		this();
		this.line = line;
		this.txtStartPointX.setText(String.valueOf(line.getStartPoint().getX()));
		this.txtStartPointY.setText(String.valueOf(line.getStartPoint().getY()));
		this.txtEndPointX.setText(String.valueOf(line.getEndPoint().getX()));
		this.txtEndPointY.setText(String.valueOf(line.getEndPoint().getY()));
	}

	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Startpoint x");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtStartPointX = new JTextField();
			GridBagConstraints gbc_txtStartPointX = new GridBagConstraints();
			gbc_txtStartPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointX.gridx = 1;
			gbc_txtStartPointX.gridy = 0;
			contentPanel.add(txtStartPointX, gbc_txtStartPointX);
			txtStartPointX.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Startpoint y");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txtStartPointY = new JTextField();
			GridBagConstraints gbc_txtStartPointY = new GridBagConstraints();
			gbc_txtStartPointY.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointY.gridx = 1;
			gbc_txtStartPointY.gridy = 1;
			contentPanel.add(txtStartPointY, gbc_txtStartPointY);
			txtStartPointY.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Endpoint x");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			txtEndPointX = new JTextField();
			GridBagConstraints gbc_txtEndPointX = new GridBagConstraints();
			gbc_txtEndPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointX.gridx = 1;
			gbc_txtEndPointX.gridy = 2;
			contentPanel.add(txtEndPointX, gbc_txtEndPointX);
			txtEndPointX.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Endpoint y");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			txtEndPointY = new JTextField();
			GridBagConstraints gbc_txtEndPointY = new GridBagConstraints();
			gbc_txtEndPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointY.gridx = 1;
			gbc_txtEndPointY.gridy = 3;
			contentPanel.add(txtEndPointY, gbc_txtEndPointY);
			txtEndPointY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void onOk() {
		this.line.setStartPoint(new Point(Integer.parseInt(txtStartPointX.getText()), Integer.parseInt(txtStartPointY.getText())));
		this.line.setEndPoint(new Point(Integer.parseInt(txtEndPointX.getText()), Integer.parseInt(txtEndPointY.getText())));
		setVisible(false);
	}
	
	public void onCancel() {
		setVisible(false);
	}
}
