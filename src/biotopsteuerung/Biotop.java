package biotopsteuerung;

import biotopsteuerung.steuerung.Controller;

public class Biotop {

	// schon relativ weit. trz noch gut was zutun
	// TODO Programmsteuerung gegen Nullpointer und ggf. Endlosschleifen absichern
	// TODO Menü überarbeiten und erweitern: gegen Nullpointer und ggf. Endlosschleifen absichern. Eingabemethode überarbeiten. 
			// Display Bereich in zwei Textareas einteilen, einen für das Menü und den anderen an die Console angelossen mit ChangeListener der bei X einträgen den ältesten löscht.
	// TODO DBConnector gegen Nullpointer und ggf. Entdlosschleifen absichern. 
	// TODO Schnittstellen implementieren
	// TODO Biostopslogik implementieren
	// TODO Datenbank planen und implementieren
		
	
	public static void main(String[] args) {

		new Controller();

	}

}
