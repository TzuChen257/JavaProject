package hw1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class SelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectUI frame = new SelectUI();
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
	public SelectUI() {
		setTitle("欣欣火鍋店");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 232, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/********botton event*******/
		
		JButton EatIn = new JButton("內用");
		EatIn.setBackground(new Color(218, 201, 116));
		EatIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EatInUI in=new EatInUI();
				in.setVisible(true);
				dispose();
			}
		});
		EatIn.setFont(new Font("新細明體", Font.BOLD, 26));
		EatIn.setBounds(54, 87, 104, 120);
		contentPane.add(EatIn);
		
		JButton TakeOut = new JButton("外帶");
		TakeOut.setBackground(new Color(181, 202, 160));
		TakeOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TakeOutUI out=new TakeOutUI();
				out.setVisible(true);
				dispose();
			}
		});
		TakeOut.setFont(new Font("新細明體", Font.BOLD, 26));
		TakeOut.setBounds(227, 89, 104, 118);
		contentPane.add(TakeOut);

	}
}
