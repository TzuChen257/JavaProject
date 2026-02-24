package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RuleUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RuleUI frame = new RuleUI();
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
	public RuleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 325, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("遊戲說明");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(108, 10, 116, 30);
		panel.add(lblNewLabel);
		
		/*****setting*****/
		
		String rule="1.當您按下滑鼠，遊戲即開始！遊戲正上方的碼錶開跑。\n\n"
				+ "2.遊戲左上方顯示的是該遊戲的未知炸彈數量。您可以選擇點擊滑鼠左鍵打開您認為沒有炸彈的格子，點擊滑鼠右鍵為您認為有炸彈的格子插上紅旗。\n\n"
				+ "3.打開的格子中，若有顯示數字，即表示其九宮格內有該數量的炸彈，務必小心。\n\n"
				+ "4.若您不幸打開炸彈，則遊戲結束。\n\n"
				+ "5.找到所有炸彈，您將以碼錶最終顯示的時間獲勝。";
		
		JTextArea textArea = new JTextArea(rule);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setTabSize(20);
		textArea.setBounds(10, 50, 303, 257);
		panel.add(textArea);
		
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBackground(getForeground());
		
		/*****event*****/
		
		JButton btnNewButton = new JButton("關閉");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(130, 323, 84, 22);
		contentPane.add(btnNewButton);
	}
}
