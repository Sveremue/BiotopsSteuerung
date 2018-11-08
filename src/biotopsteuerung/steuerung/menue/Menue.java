package biotopsteuerung.steuerung.menue;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biotopsteuerung.steuerung.Controller;

abstract class Menue {

	JTextField jTFInputField;
	JTextArea jTAMenuText;
	JPanel panel;
	MenuTools menueTools;
	String input = "";
	File menueFile;
	Controller controller;
	String seperator = System.getProperty("line.separator");

	protected Menue(JPanel panel, MenuTools menueTools, Controller controller) {
		Component[] components = panel.getComponents();
		this.panel = panel;
		this.menueTools = menueTools;
		this.controller = controller;

		for (Component c : components) {

			if (null != c.getName()) {

				if (c.getName().equals(MenueConstants.INPUT_TEXTFIELD_ID)) {
					jTFInputField = (JTextField) c;
					jTFInputField.requestFocusInWindow();
					break;
				}

				if (c.getName().equals(MenueConstants.JTA_MENUE_TEXT_ID)) {
					this.jTAMenuText = (JTextArea) c;
				}
			}
		}

		this.buildMenue();
	}

	protected void buildMenue() {
		jTFInputField.addActionListener(this.erzeugeActionListener());
		this.buildMenuBody();
	};

	protected List<String> leseInputData(String input) {
		List<String> parameterList = new ArrayList<String>();

		input.replaceFirst("[]", "");

		return parameterList;
	}

	protected String fordereInput(String anzeigeText) {
		
		return JOptionPane.showInputDialog(this.panel, anzeigeText);
		
	}
	
	protected void paintMenuText(String menueID) {
		
		File file = this.menueTools.getMenuFile(menueID);
		
		if (null != file) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				String line = br.readLine();

				while (null != line) {

					this.jTAMenuText.append(line);
					this.jTAMenuText.append(this.seperator);
					line = br.readLine();

				}
			} catch (IOException e) {

				this.jTAMenuText.setText(MenueConstants.MENUE_FILE_NOT_FOUND_TEXT);
			}

		} else {
			this.jTAMenuText.setText(MenueConstants.MENUE_FILE_NOT_FOUND_TEXT);
		}
		
	}
	
	protected abstract void buildMenuBody();
	protected abstract ActionListener erzeugeActionListener();
//Copy in erzeugeActionListener

//	ActionListener actionListener = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			input = inputField.getText();
//
//			if (!input.equals("")) {
//
//				switch (input) {
//
//				default:
//					System.out.println("Falscher Input");
//				}
//			}
//
//			inputField.setText("");
//		}
//	};
//
//	return actionListener;
}
