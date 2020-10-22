package Factory;

import javax.swing.ImageIcon;

public abstract class FactoryAbstracta {
	
	public abstract ImageIcon getNumber(int i);
	
	public ImageIcon getPuntos() {														//retorna un imageIcon (:) 
		return new ImageIcon(this.getClass().getResource("/Factory/puntosV2.png"));
	}
	public ImageIcon getVictoria() {
		return new ImageIcon(this.getClass().getResource("/Factory/Victory.png"));				//retorna el cartel de victoria
	}

}
