package Factory;

import javax.swing.ImageIcon;

public class FactoryIMG extends FactoryAbstracta {
	
	public FactoryIMG() {}
	
	public ImageIcon getNumber(int i) {											//retorna un ImageIcon del numero ingresado (entre 0 y 9), 10 para un espacio vacio
		ImageIcon aux=null;
		switch(i){
		case(1):
			aux=new ImageIcon(this.getClass().getResource("/Factory/1.png"));
			break;
		case(2):
			aux=new ImageIcon(this.getClass().getResource("/Factory/2.png"));
			break;
		case(3):
			aux=new ImageIcon(this.getClass().getResource("/Factory/3.png"));
			break;
		case(4):
			aux=new ImageIcon(this.getClass().getResource("/Factory/4.png"));
			break;
		case(5):
			aux=new ImageIcon(this.getClass().getResource("/Factory/5.png"));
			break;
		case(6):
			aux=new ImageIcon(this.getClass().getResource("/Factory/6.png"));
			break;
		case(7):
			aux=new ImageIcon(this.getClass().getResource("/Factory/7.png"));
			break;
		case(8):
			aux=new ImageIcon(this.getClass().getResource("/Factory/8.png"));
			break;
		case(9):
			aux=new ImageIcon(this.getClass().getResource("/Factory/9.png"));
			break;
		case(0):
			aux=new ImageIcon(this.getClass().getResource("/Factory/0.png"));
			break;
		case(10):
			aux=new ImageIcon(this.getClass().getResource("/Factory/10.png"));
			break;	
		
		}
		return aux;
	}
	
	public ImageIcon getPuntos() {														//retorna un imageIcon (:) 
		return new ImageIcon(this.getClass().getResource("/Factory/puntosV2.png"));
	}
	public ImageIcon getVictoria() {
		return new ImageIcon(this.getClass().getResource("/Factory/Victory.png"));				//retorna el cartel de victoria
	}
}
