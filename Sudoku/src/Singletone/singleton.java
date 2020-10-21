package Singletone;
import GUI.Gui2;
import Logica.Juego;
import Timer.RelojL;

public class singleton {
	
	protected static Gui2 gui;
	protected static Juego juego;
	protected static RelojL tiempo;
	
	public static Gui2 getGui() {				//retorna la Gui
		if (gui==null) {
			gui= new Gui2();
		}
		
		return gui;
	}

	public static Juego getJuego() {			//retorna el juego
		if(juego==null) {
			juego = new Juego();
		}
		return juego;
	}
	
	public static RelojL getReloj(){			//retorna el reloj
		if (tiempo==null) {
			tiempo= new RelojL();
		}
		
		return tiempo;
	}
}
