package todolist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FrameTodoList implements MouseListener{

	private JFrame frame;
	private JTextField textNouveau;
	private JButton btnPlus;

	JList<Todo> jListTask;
	DefaultListModel<Todo> model;
	
	Todo valList;
	int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTodoList window = new FrameTodoList();
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
	public FrameTodoList() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 30));
		frame.setBounds(100, 100, 332, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Todo List");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 292, 39);
		frame.getContentPane().add(lblNewLabel);

		textNouveau = new JTextField();
		textNouveau.setBounds(10, 61, 218, 47);
		textNouveau.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(textNouveau);
		textNouveau.setColumns(10);

		jListTask = new JList<Todo>();
		model = new DefaultListModel<Todo>();
		jListTask.setModel(model);
		jListTask.setFont(new Font("Arial", Font.PLAIN, 20));
		jListTask.setBackground(Color.WHITE);
		jListTask.setBorder(null);
		jListTask.setBounds(10, 133, 290, 234);
		jListTask.addMouseListener(this);
		frame.getContentPane().add(jListTask);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNouveau.getText() != "") {
					Todo tache = new Todo(textNouveau.getText());
					model.addElement(tache);
					textNouveau.setText("");
				}
			}
		});
		btnPlus.setMargin(new Insets(0, 0, 0, 0));
		btnPlus.setIconTextGap(0);
		btnPlus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlus.setBackground(Color.MAGENTA);
		btnPlus.setFont(new Font("Arial", Font.BOLD, 60));
		btnPlus.setBounds(261, 62, 41, 46);
		frame.getContentPane().add(btnPlus);

		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jListTask.getSelectedIndex() != -1) {
					model.remove(jListTask.getSelectedIndex());
				}

			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 30));
		btnNewButton.setBounds(10, 388, 292, 37);
		frame.getContentPane().add(btnNewButton);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getClickCount() == 2) {
        	if(jListTask.getSelectedValue() != null) {
        		Todo tache = model.get(jListTask.getSelectedIndex());
        		tache.toggleFaite();
        		model.set(jListTask.getSelectedIndex(), tache);
     
        	}
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
		if (jListTask.getSelectedIndex() != -1) {
			valList = jListTask.getSelectedValue();
			index = jListTask.getSelectedIndex();
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (jListTask.getSelectedIndex() != -1) {
			model.setElementAt(jListTask.getSelectedValue(), index);
			model.setElementAt(valList, jListTask.getSelectedIndex());
		}
	}
}
