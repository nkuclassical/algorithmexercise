import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;


public class guidemo {

	private JFrame frame;
	private JTextField text;
	private JTextField input;
	private JLabel result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guidemo window = new guidemo();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guidemo() {
		initialize();
	}
	public class event implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double randomNum=(double)(Math.random()*100+1);
			try
			{
				double guess=Double.parseDouble(input.getText());
				result.setText((100-Math.abs((guess-randomNum)*100/randomNum))+"%   "+guess+" - "+randomNum);
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{166, 117, 0};
		gridBagLayout.rowHeights = new int[]{36, 29, 0, 111, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel question = new JLabel("Questions");
		GridBagConstraints gbc_question = new GridBagConstraints();
		gbc_question.insets = new Insets(0, 0, 5, 5);
		gbc_question.gridx = 0;
		gbc_question.gridy = 2;
		frame.getContentPane().add(question, gbc_question);
		
		result = new JLabel("Judge");
		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.insets=new Insets(1, 1, 5, 0);
		gbc_result.gridx = 1;
		gbc_result.gridy = 2;
		frame.getContentPane().add(result, gbc_result);
		
		input = new JTextField();
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.insets = new Insets(2, 2, 0, 5);
		gbc_input.fill = GridBagConstraints.HORIZONTAL;
		gbc_input.gridx = 0;
		gbc_input.gridy = 3;
		frame.getContentPane().add(input, gbc_input);
		input.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		event bl1=new event();
		btnNewButton.addActionListener(bl1);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
	}
}
