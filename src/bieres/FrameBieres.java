package bieres;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FrameBieres implements MouseListener {

	private JFrame frame;
	private JTable jTableBeer;
	static DefaultTableModel model;
	private static Beer beer;
	private JTextField nom;
	private JTextField variete;
	private JTextField degre;
	private JButton btnCreer;
	private int sel;
	private Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBieres window = new FrameBieres();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public FrameBieres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 353);
		
		jTableBeer = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int d, int c) {
				return false;
			}
		};
		model = new DefaultTableModel(0, 0);

		String[] columnNames = new String[] { "Nom", "Variété", "Degré" };
		model.setColumnIdentifiers(columnNames);
		jTableBeer.addMouseListener(this);
		jTableBeer.setModel(model);
		// Object[] row1 = {"1664", "blonde", 3.4};
		// model.addRow(row1);

		setBeer(new Beer("1664", "blonde", 3.4F));
		row = getBeer().toRow();
		model.addRow(row);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane(jTableBeer);
		scrollPane.setBounds(10, 11, 257, 288);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 1, true));
		panel.setBounds(290, 11, 230, 288);
		panel.setLayout(null);

		JLabel lblFormulaire = new JLabel("Formulaire");
		lblFormulaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormulaire.setBounds(10, 29, 210, 26);
		lblFormulaire.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNom.setBounds(30, 84, 58, 26);

		JLabel lblVarit = new JLabel("Vari\u00E9t\u00E9 : ");
		lblVarit.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblVarit.setBounds(10, 129, 76, 26);

		JLabel lblDegr = new JLabel("Degr\u00E9 :");
		lblDegr.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblDegr.setBounds(22, 174, 74, 26);
		
		nom = new JTextField();
		nom.setBounds(81, 83, 139, 26);
		nom.setColumns(10);

		variete = new JTextField();
		variete.setBounds(81, 128, 139, 26);
		variete.setColumns(10);

		degre = new JTextField();
		degre.setBounds(81, 173, 139, 26);
		degre.setColumns(10);

		btnCreer = new JButton("Créer");
		btnCreer.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnCreer.getText().equals("Créer") & !nom.getText().equals("") & !variete.getText().equals("")
						& !degre.getText().equals("") & isNumeric(degre.getText())) {
					setBeer(new Beer(nom.getText(), variete.getText(), Float.parseFloat(degre.getText())));
					row = getBeer().toRow();
					model.addRow(row);
					nom.setText("");
					variete.setText("");
					degre.setText("");
				}
				if (btnCreer.getText().equals("Modifier") & !nom.getText().equals("") & !variete.getText().equals("")
						& !degre.getText().equals("") & isNumeric(degre.getText())) {

					setBeer(new Beer(nom.getText(), variete.getText(), Float.parseFloat(degre.getText())));
					row = getBeer().toRow();
					for (int i = 0; i < row.length; i++) {
						jTableBeer.setValueAt(row[i], sel, i);
					}
					nom.setText("");
					variete.setText("");
					degre.setText("");
					btnCreer.setText("Créer");
				}
			}
		});
		btnCreer.setBounds(43, 229, 154, 23);
				
		
		panel.add(nom);
		panel.add(variete);
		panel.add(degre);
		panel.add(btnCreer);
		panel.add(lblFormulaire);
		panel.add(lblNom);
		panel.add(lblVarit);
		panel.add(lblDegr);
		frame.getContentPane().add(panel);
		
		frame.getContentPane().add(scrollPane);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		sel = jTableBeer.getSelectedRow();
		if (e.getClickCount() == 2) {
			int retour = JOptionPane.showConfirmDialog(frame, "Voulez-vous supprimer cette biére ?", 
				     "Supprimer une biére", JOptionPane.WARNING_MESSAGE);
			if(retour == 0) {
				model.removeRow(sel);
				btnCreer.setText("Créer");
				nom.setText("");
				variete.setText("");
				degre.setText("");
			}else {
				btnCreer.setText("Créer");
				nom.setText("");
				variete.setText("");
				degre.setText("");
			}
		}else {
			nom.setText((String) jTableBeer.getValueAt(sel, 0));
			variete.setText((String) jTableBeer.getValueAt(sel, 1));
			degre.setText(Float.toString((float) jTableBeer.getValueAt(sel, 2)));
			btnCreer.setText("Modifier");
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	
	

	public static boolean isNumeric(String strNum) {
		try {
			Float.parseFloat(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	
	public static Beer getBeer() {
		return beer;
	}

	public static void setBeer(Beer beer) {
		FrameBieres.beer = beer;
	}

	
}
