package biotopsteuerung;

import biotopsteuerung.steuerung.Controller;

public class Biotop {

	// schon relativ weit. trz noch gut was zutun
	// TODO Programmsteuerung gegen Nullpointer und ggf. Endlosschleifen absichern
	// TODO Men� �berarbeiten und erweitern: gegen Nullpointer und ggf. Endlosschleifen absichern. Eingabemethode �berarbeiten. 
			// Display Bereich in zwei Textareas einteilen, einen f�r das Men� und den anderen an die Console angelossen mit ChangeListener der bei X eintr�gen den �ltesten l�scht.
	// TODO DBConnector gegen Nullpointer und ggf. Entdlosschleifen absichern. 
	// TODO Schnittstellen implementieren
	// TODO Biostopslogik implementieren
	// TODO Datenbank planen und implementieren
		
	
	public static void main(String[] args) {

		new Controller();

	}

}
