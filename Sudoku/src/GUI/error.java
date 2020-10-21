package GUI;

import javax.swing.JOptionPane;

public class error{
	public static void main() {				//le indica al usuario que ah ocurrido un error al cargar el sudoku
		JOptionPane.showMessageDialog(null, "Error, el sudoku ingresado no es valido", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
