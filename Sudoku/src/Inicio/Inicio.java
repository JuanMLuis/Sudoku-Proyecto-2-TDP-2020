package Inicio;
import GUI.Gui2;
import Singletone.singleton;
public class Inicio {
		
		private static Gui2 gui;
		private static Timer.RelojL RelojL;

	public static void main(String[] args) {
		start();

	}
	
	public static void start() {			//comienza el juego
		gui=singleton.getGui();

		singleton.getJuego();
		
		RelojL=singleton.getReloj();
		
		gui.setVisible(true);
		
		RelojL.run();
		
		
	}

}
