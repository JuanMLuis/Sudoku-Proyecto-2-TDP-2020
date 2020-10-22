package Factory;

import javax.swing.ImageIcon;

public class FactoryNumerosS extends FactoryAbstracta {

	@Override
	public ImageIcon getNumber(int i) {
		ImageIcon aux=null;
		switch(i){
		case(1):
			aux=new ImageIcon(this.getClass().getResource("/Factory/1S.png"));
			break;
		case(2):
			aux=new ImageIcon(this.getClass().getResource("/Factory/2S.png"));
			break;
		case(3):
			aux=new ImageIcon(this.getClass().getResource("/Factory/3S.png"));
			break;
		case(4):
			aux=new ImageIcon(this.getClass().getResource("/Factory/4S.png"));
			break;
		case(5):
			aux=new ImageIcon(this.getClass().getResource("/Factory/5S.png"));
			break;
		case(6):
			aux=new ImageIcon(this.getClass().getResource("/Factory/6S.png"));
			break;
		case(7):
			aux=new ImageIcon(this.getClass().getResource("/Factory/7S.png"));
			break;
		case(8):
			aux=new ImageIcon(this.getClass().getResource("/Factory/8S.png"));
			break;
		case(9):
			aux=new ImageIcon(this.getClass().getResource("/Factory/9S.png"));
			break;
		case(0):
			aux=new ImageIcon(this.getClass().getResource("/Factory/0S.png"));
			break;
		case(10):
			aux=new ImageIcon(this.getClass().getResource("/Factory/10.png"));
			break;	
		
		}
		return aux;
	}
	}


