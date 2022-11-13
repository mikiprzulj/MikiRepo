package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtWidth;
	private JTextField txtHeight;
	private Rectangle rectangle;
	private JTextField txtUpperLeftX;
	private JTextField txtUpperLeftY;

	public RectangleDialog(Rectangle rectangle) {
		this();
		this.rectangle = rectangle;
		this.txtUpperLeftX.setText(String.valueOf(rectangle.getUpperLeftPoint().getX()));
		this.txtUpperLeftY.setText(String.valueOf(rectangle.getUpperLeftPoint().getY()));
		this.txtWidth.setText(String.valueOf(rectangle.getWidth()));
		this.txtHeight.setText(String.valueOf(rectangle.getHeight()));
	}
	/**
	 * Create the dialog.
	 */
	public RectangleDialog() {
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
			JLabel lblNewLabel = new JLabel("Width");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 0;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Height");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 1;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Upper Left X");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			txtUpperLeftX = new JTextField();
			GridBagConstraints gbc_txtUpperLeftX = new GridBagConstraints();
			gbc_txtUpperLeftX.insets = new Insets(0, 0, 5, 0);
			gbc_txtUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUpperLeftX.gridx = 1;
			gbc_txtUpperLeftX.gridy = 2;
			contentPanel.add(txtUpperLeftX, gbc_txtUpperLeftX);
			txtUpperLeftX.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Upper Left Y");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			txtUpperLeftY = new JTextField();
			GridBagConstraints gbc_txtUpperLeftY = new GridBagConstraints();
			gbc_txtUpperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUpperLeftY.gridx = 1;
			gbc_txtUpperLeftY.gridy = 3;
			contentPanel.add(txtUpperLeftY, gbc_txtUpperLeftY);
			txtUpperLeftY.setColumns(10);
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

	protected void onCancel() {
		setVisible(false);
	}

	public void onOk() {
		try {
			this.rectangle.setWidth(Integer.parseInt(txtWidth.getText()));
			this.rectangle.setHeight(Integer.parseInt(txtHeight.getText()));
			this.rectangle.getUpperLeftPoint().setX(Integer.parseInt(txtUpperLeftX.getText()));
			this.rectangle.getUpperLeftPoint().setY(Integer.parseInt(txtUpperLeftY.getText()));
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Not numeric value " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		setVisible(false);
	}	
}
