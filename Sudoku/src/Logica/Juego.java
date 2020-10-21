package Logica;

public class Juego {
	protected Sudoku partida;
	
	public Juego() {
		partida=new Sudoku();
	}
	
	public Sudoku getPartida() {					//devuelve la partida actual
		return partida;
	}
	
	public void reset() {							//reinicia el sudoku
		partida.eliminar();
		partida= new Sudoku();
	}
	
	public void fin() {								//finaliza la partida
		partida.fin();
	}
}
