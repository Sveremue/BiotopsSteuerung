package biotopsteuerung.steuerung.menue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import biotopsteuerung.steuerung.Controller;

class MainMenu extends Menue {

	String terraID = "";
	boolean eingabe = false;
	
	protected MainMenu(JPanel panel, MenuTools menueTools, Controller steuerung) {
		super(panel, menueTools, steuerung);
		this.jTFInputField.setText("");
	}

	@Override
	protected void buildMenuBody() {

		this.jTAMenuText.setText("");
		super.paintMenuText(MenueConstants.MAIN_MENUE_ID);
	}

	@Override
	protected ActionListener erzeugeActionListener() {

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				input = jTFInputField.getText();

				if (input.length() == 1) {
					jTFInputField.setText("");
				}

				if (!input.equals("")) {

					switch (input) {

					case "1":
						doOption1();
						break;

					case "2":
						doOption2();
						break;

					case "e":
						doOptionExit();
						break;
					case "j":

						if (eingabe) {
							starteTerrarien();
							eingabe = false;
							break;
						}
					case "n":
						;

						if (eingabe) {
							terraID = "";
							eingabe = false;
							buildMenuBody();
							break;
						}
					default:
						System.out.println("Falscher Input");
					}
				}
			}
		};

		return actionListener;
	}

	private void doOption1() {

		new RegisterMenue(panel, menueTools, this, controller);
	}

	private void doOption2() {

		this.buildMenuBody();
		this.eingabe = true;
		
		System.out.println(this.seperator + "Terrarium starten" + this.seperator);
		this.terraID = this.fordereInput("TerraID eingeben. \"Alle\" für alle.");

		System.out.println("TerraID: " + this.terraID);
		System.out.println("Terrarium starten: n = nein j = ja");

	}

	private void starteTerrarien() {
		
		this.buildMenuBody();
		if(eingabe) {
			
			buildMenuBody();
			if(controller.startTerrarium(this.terraID)) {
			
				System.out.println(	System.getProperty("line.separator"));
				System.out.println("Terrarium gestartet.");
				
			}else {
				
				System.out.println("ID konnte nicht gestartet werden.");
				
			}
		}
	}
	
	private void doOptionExit() {
		System.exit(0);
	}

}
