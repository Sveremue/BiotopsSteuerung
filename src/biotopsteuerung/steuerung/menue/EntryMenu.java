package biotopsteuerung.steuerung.menue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biotopsteuerung.steuerung.Controller;

public class EntryMenu {

	public EntryMenu(Controller controller) {
		
		JFrame frame = new JFrame();
		JPanel panel = this.buildPanel();
		frame.add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new MainMenu(panel, new MenuTools(), controller);
	}

	private JPanel buildPanel() {

		JPanel panel = new JPanel();
		//panel.setName(MenueConstants.PANEL_ID);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		//In mehrere TextAreas aufteilen. Der Obere für das Menu unteren als Consolen Anzeige.
		//Consolenanzeige hat Changelistener der nach x Zeilen die oberste löscht und alles einen Eintrag weiter nach oben schiebt
		// oder Scrollbar machen

		JTextArea jTAMenueText = new JTextArea(24, 80);
		jTAMenueText.setBackground(Color.BLACK);
		jTAMenueText.setForeground(Color.LIGHT_GRAY);
		jTAMenueText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		jTAMenueText.setForeground(Color.green);
		jTAMenueText.setEditable(false);
		jTAMenueText.setName(MenueConstants.JTA_MENUE_TEXT_ID);
		
		JTextArea jTAConsolOutPut = new JTextArea(24,80);
		jTAConsolOutPut.setBackground(Color.BLACK);
		jTAConsolOutPut.setForeground(Color.LIGHT_GRAY);
		jTAConsolOutPut.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		jTAConsolOutPut.setForeground(Color.green);
		jTAConsolOutPut.setEditable(false);
		jTAConsolOutPut.setName(MenueConstants.JTA_CONSOL_OUTPUT_ID);
		
//		System.setOut(new PrintStream(new OutputStream() {
//			@Override
//			public void write(int b) throws IOException {
//				jTAConsolOutPut.append(String.valueOf((char) b));
//			}
//		}));
		
		JTextField tFEingabe = new JTextField();
		tFEingabe.setName(MenueConstants.INPUT_TEXTFIELD_ID);
		tFEingabe.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		
		panel.add(jTAMenueText);
		panel.add(jTAConsolOutPut);
		panel.add(tFEingabe);
		
		return panel;
	}

}
