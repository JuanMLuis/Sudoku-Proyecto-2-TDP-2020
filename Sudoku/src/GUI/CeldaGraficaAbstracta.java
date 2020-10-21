package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.FactoryIMG;

public class CeldaGraficaAbstracta {
	
	protected JLabel grafico;
	
	public JLabel getGrafico() {
		return grafico;
	}
	
	public void setImage(int a) {												//setea la imagen del grafico con el numero pasado por parametro mediante la factory
		FactoryIMG aux= new FactoryIMG();
		ImageIcon aux2=aux.getNumber(a);
		grafico.setIcon(ArregloImagen.Acomodar(aux2,grafico));
		
	}
	
	
}
