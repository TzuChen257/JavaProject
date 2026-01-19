package main;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.print.PrinterException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ArtController
{
	private static JLabel labelTimer;
	private static JTextField textInputPath;
	private static JTextField textRewidth;
	private static JTextField textOutputChars;
	private static JTextField textOutputPath;
	private static JTextField textGrayLevel;
	private static JButton buttonClearAll;
	private static JButton buttonOutput;
	private static JButton buttonPrint;
	private static JButton buttonQuit;
	private static JTextArea textAreaConsole;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ArtUI frame = new ArtUI();
					ArtController controller = new ArtController();
					labelTimer = frame.getLabelTimer();
					textInputPath = frame.getTextInputPath();
					textRewidth = frame.getTextRewidth();
					textOutputPath = frame.getTextOutputPath();
					textOutputChars = frame.getTextOutputChars();
					textGrayLevel = frame.getTextGrayLevel();
					textAreaConsole = frame.getTextAreaConsole();
					buttonClearAll = frame.getButtonClearAll();
					buttonOutput = frame.getButtonOutput();
					buttonPrint = frame.getButtonPrint();
					buttonQuit = frame.getButtonQuit();
					
					Utils.startTimer(ArtDefiner.PER_SECOND_FROM_MILLISECONDS, controller::setTimerText);
					controller.mouseEventAssign(buttonClearAll, new MouseEventAdapter(controller::clearAll));
					controller.mouseEventAssign(buttonOutput, new MouseEventAdapter(controller::output));
					controller.mouseEventAssign(buttonPrint, new MouseEventAdapter(controller::print));
					controller.mouseEventAssign(buttonQuit, new MouseEventAdapter(controller::quit));

					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	private void mouseEventAssign(JButton button, MouseAdapter callback)
	{
		button.addMouseListener(callback);
	}
	
	private void clearAll()
	{
		textAreaConsole.setText("");
	}
	
	private void output()
	{
		var model = new ArtModel(
			getModelPath(textInputPath, ArtDefiner.INPUT_INVAILD_TEXT), 
			getModelPath(textOutputPath, ArtDefiner.OUTPUT_FILE_TEXT),
			getModelInteger(textRewidth, ArtDefiner.REWIDTH_INVAILD_TEXT),
			getModelInteger(textGrayLevel, ArtDefiner.GRAY_SCALE_LEVEL_INVAILD_TEXT),
			getModelChar(textOutputChars, ArtDefiner.CHAR_INVAILD_TEXT)
		);

		textAreaConsole.setText(model.Output());
	}
	
	private Path getModelPath(JTextField textField, String errorMessage)
	{
		try
		{
			return Paths.get(textField.getText());
		}
		catch(Exception e)
		{
			textAreaConsole.setText(errorMessage);
			throw e;
		}
	}
	
	private int getModelInteger(JTextField textField, String errorMessage)
	{
		try
		{
			return Integer.parseInt(textField.getText());
		}
		catch(Exception e)
		{
			textAreaConsole.setText(errorMessage);
			throw e;
		}
	}
	
	private char getModelChar(JTextField textField, String errorMessage)
	{
		try
		{
			return textField.getText().charAt(0);
		}
		catch(Exception e)
		{
			textAreaConsole.setText(errorMessage);
			throw e;
		}
	}
	
	private void print()
	{
		try
		{
			textAreaConsole.print();
		} catch (PrinterException e)
		{
			System.out.println(e);
		}
	}
	
	private void quit()
	{
		System.exit(0);
	}
	
	private void setTimerText()
	{
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		labelTimer.setText(time);
	}
}
