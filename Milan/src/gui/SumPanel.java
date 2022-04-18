package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumPanel extends JPanel {
	private JTextField txtPrviBroj;
	private JTextField txtDrugiBroj;
	private JTextField txtRezultat;
	private JButton btnSaberi;
	private JButton btnClear;

	/**
	 * Create the panel.
	 */
	public SumPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Prvi broj");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(20, 20, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtPrviBroj = new JTextField();
		txtPrviBroj.setText("");
		GridBagConstraints gbc_txtPrviBroj = new GridBagConstraints();
		gbc_txtPrviBroj.insets = new Insets(20, 0, 5, 20);
		gbc_txtPrviBroj.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrviBroj.gridx = 1;
		gbc_txtPrviBroj.gridy = 0;
		add(txtPrviBroj, gbc_txtPrviBroj);
		txtPrviBroj.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Drugi broj");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtDrugiBroj = new JTextField();
		GridBagConstraints gbc_txtDrugiBroj = new GridBagConstraints();
		gbc_txtDrugiBroj.insets = new Insets(0, 0, 5, 20);
		gbc_txtDrugiBroj.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrugiBroj.gridx = 1;
		gbc_txtDrugiBroj.gridy = 1;
		add(txtDrugiBroj, gbc_txtDrugiBroj);
		txtDrugiBroj.setColumns(10);
		
		btnSaberi = new JButton("Saberi");
		
		btnSaberi.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {				
				executeSum();
			}
		});
		
		GridBagConstraints gbc_btnSaberi = new GridBagConstraints();
		gbc_btnSaberi.gridwidth = 2;
		gbc_btnSaberi.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaberi.gridx = 0;
		gbc_btnSaberi.gridy = 2;
		add(btnSaberi, gbc_btnSaberi);
		
		JLabel lblNewLabel_2 = new JLabel("Rezultat");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtRezultat = new JTextField();
		GridBagConstraints gbc_txtRezultat = new GridBagConstraints();
		gbc_txtRezultat.insets = new Insets(0, 0, 5, 20);
		gbc_txtRezultat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRezultat.gridx = 1;
		gbc_txtRezultat.gridy = 3;
		add(txtRezultat, gbc_txtRezultat);
		txtRezultat.setColumns(10);
		
		btnClear = new JButton("Ponisti polja");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFields();
			}			
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 4;
		add(btnClear, gbc_btnClear);

	}
	
	protected void clearFields() {
		int chosenOption = JOptionPane.showConfirmDialog(this, "Da li ste sigurni");
		
		if (chosenOption == JOptionPane.YES_OPTION) {
			
			txtPrviBroj.setText("");
			txtDrugiBroj.setText("");
			txtRezultat.setText("");
			
			JOptionPane.showMessageDialog(this, "Polja obrisana", "Obavestenje", JOptionPane.WARNING_MESSAGE);
		} else if (chosenOption == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this, "Odustali ste", "Upozorenje", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	public JButton getBtnSaberi() {
		return btnSaberi;
	}
	
	public void executeSum() {
		int prviBroj = Integer.parseInt(txtPrviBroj.getText());
		int drugiBroj = Integer.parseInt(txtDrugiBroj.getText());
		
		int rezultat = prviBroj + drugiBroj;
		txtRezultat.setText(String.valueOf(rezultat));
	}
}
