package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.FactoryAbstracta;
import Factory.FactoryIMG;

public class CeldaGraficaAbstracta {
	
	protected JLabel grafico;
	
	public JLabel getGrafico() {
		return grafico;
	}
	
	public void setImage(int a, FactoryAbstracta f) {						//setea la imagen del grafico con el numero pasado por parametro mediante la factory
		ImageIcon aux=f.getNumber(a);
		grafico.setIcon(ArregloImagen.Acomodar(aux,grafico));
		
	}
	
	
}
