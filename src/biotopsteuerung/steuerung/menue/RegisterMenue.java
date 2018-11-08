package biotopsteuerung.steuerung.menue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import biotopsteuerung.steuerung.Controller;
import biotopsteuerung.steuerung.Terrarium;

class RegisterMenue extends Menue {

	private Menue aufrufer;
	private boolean eingabe = false;
	
	private String separator = System.getProperty("line.separator");
	
	private String terraID = "";
	
	protected RegisterMenue(JPanel panel, MenuTools menueTools, Menue aufrufer, Controller steuerung) {
		super(panel, menueTools, steuerung);
		this.aufrufer = aufrufer;
		this.jTFInputField.setText("");
	}

	@Override
	protected ActionListener erzeugeActionListener() {
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				input = jTFInputField.getText();

				if (!input.equals("")) {

					switch (input) {
					
					case "1":
						regristriereTerrarium();
						break;
					case "2":
						zeigeTerrarien();
						break;
					case "b":
						zurueck();
						break;
					case "j":

						if(eingabe) {
							schreibeTerrarium();
							break;
						}
					case "n":;

					if(eingabe) {
							terraID = "";
							eingabe = false;
							buildMenuBody();
							break;
						}
					default:
						System.out.println("Falscher Input");
					}
				}

				jTFInputField.setText("");
			}
		};

		return actionListener;
	}

	@Override
	protected void buildMenuBody() {

		this.jTAMenuText.setText("");
		super.paintMenuText(MenueConstants.REGISTER_MENUE_ID);

	}

	private void regristriereTerrarium() {
		buildMenuBody();
		
		this.terraID = "";
		this.eingabe = true;
		
		this.terraID = this.fordereInput("TerrariumID eingeben.");
		
		if(!"".equals(this.terraID)) {
			
			System.out.println(this.separator + "Eingabe:" + this.separator);
			System.out.println("TerraID: " + this.terraID);
			System.out.println("Terrarium anlegen: n = nein j = ja");
			
			
		}
		

	}
	
	private void zeigeTerrarien() {
		
		buildMenuBody();
		List<Terrarium> terrariumList = controller.getTerrariumList();

		System.out.println("");
		
		for (Terrarium t : terrariumList) {
			
			System.out.println("Terrarium: " + t.getTerraID());
			
		}
		
	}
	
	private void schreibeTerrarium() {
		
		if(eingabe) {
			
			buildMenuBody();
			if(controller.addTerrarium(this.terraID)) {
			
				System.out.println(	System.getProperty("line.separator"));
				System.out.println("Terrarium angelegt.");
				
			}else {
				
				System.out.println("ID bereits vergeben.");
				
			}
		}
		
		
	}
	
	private void zurueck() {
		this.aufrufer.buildMenue();
	}
	
}
