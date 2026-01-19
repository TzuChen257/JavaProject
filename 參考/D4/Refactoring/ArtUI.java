package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ArtUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textInputPath;
	private JTextField textRewidth;
	private JTextField textOutputChars;
	private JTextField textOutputPath;
	private JTextField textGrayLevel;
	private JButton buttonClearAll;
	private JButton buttonOutput;
	private JButton buttonPrint;
	private JButton buttonQuit;
	private JTextArea textAreaConsole;
	private JLabel labelTimer;

	
	public JLabel getLabelTimer()
	{
		return labelTimer;
	}

	public void setLabelTimer(JLabel labelTimer)
	{
		this.labelTimer = labelTimer;
	}

	public JTextField getTextInputPath()
	{
		return textInputPath;
	}

	public void setTextInputPath(JTextField textInputPath)
	{
		this.textInputPath = textInputPath;
	}

	public JTextField getTextRewidth()
	{
		return textRewidth;
	}

	public void setTextRewidth(JTextField textRewidth)
	{
		this.textRewidth = textRewidth;
	}

	public JTextField getTextOutputChars()
	{
		return textOutputChars;
	}

	public void setTextOutputChars(JTextField textOutputChars)
	{
		this.textOutputChars = textOutputChars;
	}

	public JTextField getTextOutputPath()
	{
		return textOutputPath;
	}

	public void setTextOutputPath(JTextField textOutputPath)
	{
		this.textOutputPath = textOutputPath;
	}

	public JTextField getTextGrayLevel()
	{
		return textGrayLevel;
	}

	public void setTextGrayLevel(JTextField textGrayLevel)
	{
		this.textGrayLevel = textGrayLevel;
	}

	public JButton getButtonClearAll()
	{
		return buttonClearAll;
	}

	public void setButtonClearAll(JButton buttonClearAll)
	{
		this.buttonClearAll = buttonClearAll;
	}

	public JButton getButtonOutput()
	{
		return buttonOutput;
	}

	public void setButtonOutput(JButton buttonOutput)
	{
		this.buttonOutput = buttonOutput;
	}

	public JButton getButtonPrint()
	{
		return buttonPrint;
	}

	public void setButtonPrint(JButton buttonPrint)
	{
		this.buttonPrint = buttonPrint;
	}

	public JButton getButtonQuit()
	{
		return buttonQuit;
	}

	public void setButtonQuit(JButton buttonQuit)
	{
		this.buttonQuit = buttonQuit;
	}

	public JTextArea getTextAreaConsole()
	{
		return textAreaConsole;
	}

	public void setTextAreaConsole(JTextArea textAreaConsole)
	{
		this.textAreaConsole = textAreaConsole;
	}

	/**
	 * Create the frame.
	 */
	public ArtUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTitle = new JLabel("ASCII Art");
		labelTitle.setForeground(new Color(0, 0, 255));
		labelTitle.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(273, 10, 200, 36);
		labelTitle.setBackground(new Color(255, 255, 255));
		contentPane.add(labelTitle);

		labelTimer = new JLabel("");
		labelTimer.setHorizontalAlignment(SwingConstants.CENTER);
		labelTimer.setForeground(Color.BLUE);
		labelTimer.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		labelTimer.setBackground(Color.WHITE);
		labelTimer.setBounds(177, 56, 400, 36);
		contentPane.add(labelTimer);

		JLabel labelInput = new JLabel("檔案路徑");
		labelInput.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelInput.setHorizontalAlignment(SwingConstants.CENTER);
		labelInput.setForeground(new Color(255, 128, 0));
		labelInput.setBounds(10, 103, 102, 44);
		contentPane.add(labelInput);

		JLabel labelRewidth = new JLabel("重設寬度");
		labelRewidth.setHorizontalAlignment(SwingConstants.CENTER);
		labelRewidth.setForeground(new Color(255, 128, 0));
		labelRewidth.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelRewidth.setBounds(10, 187, 102, 44);
		contentPane.add(labelRewidth);

		JLabel labelChar = new JLabel("輸出字元");
		labelChar.setHorizontalAlignment(SwingConstants.CENTER);
		labelChar.setForeground(new Color(255, 128, 0));
		labelChar.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelChar.setBounds(10, 282, 102, 44);
		contentPane.add(labelChar);

		JLabel labelOutput = new JLabel("輸出路徑");
		labelOutput.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutput.setForeground(new Color(255, 128, 0));
		labelOutput.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelOutput.setBounds(10, 149, 102, 44);
		contentPane.add(labelOutput);

		JLabel labelGrayLevel = new JLabel("顏色分界");
		labelGrayLevel.setHorizontalAlignment(SwingConstants.CENTER);
		labelGrayLevel.setForeground(new Color(255, 128, 0));
		labelGrayLevel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelGrayLevel.setBounds(10, 241, 102, 44);
		contentPane.add(labelGrayLevel);

		textInputPath = new JTextField();
		textInputPath.setForeground(new Color(0, 0, 0));
		textInputPath.setBounds(122, 103, 200, 36);
		contentPane.add(textInputPath);
		textInputPath.setColumns(10);

		textRewidth = new JTextField();
		textRewidth.setForeground(Color.BLACK);
		textRewidth.setColumns(10);
		textRewidth.setBounds(122, 195, 200, 36);
		contentPane.add(textRewidth);

		textOutputChars = new JTextField();
		textOutputChars.setForeground(Color.BLACK);
		textOutputChars.setColumns(10);
		textOutputChars.setBounds(122, 282, 200, 36);
		contentPane.add(textOutputChars);

		textOutputPath = new JTextField();
		textOutputPath.setForeground(Color.BLACK);
		textOutputPath.setColumns(10);
		textOutputPath.setBounds(122, 149, 200, 36);
		contentPane.add(textOutputPath);

		textGrayLevel = new JTextField();
		textGrayLevel.setForeground(Color.BLACK);
		textGrayLevel.setColumns(10);
		textGrayLevel.setBounds(122, 238, 200, 36);
		contentPane.add(textGrayLevel);

		textAreaConsole = new JTextArea();
		textAreaConsole.setBounds(393, 102, 305, 332);
		contentPane.add(textAreaConsole);

		buttonClearAll = new JButton("清除");
		buttonClearAll.setBounds(150, 328, 141, 23);
		contentPane.add(buttonClearAll);

		buttonOutput = new JButton("輸出");
		buttonOutput.setBounds(150, 361, 141, 23);
		contentPane.add(buttonOutput);

		buttonPrint = new JButton("列印");
		buttonPrint.setBounds(150, 394, 141, 23);
		contentPane.add(buttonPrint);

		buttonQuit = new JButton("關閉");
		buttonQuit.setBounds(150, 427, 141, 23);
		contentPane.add(buttonQuit);
	}
}
