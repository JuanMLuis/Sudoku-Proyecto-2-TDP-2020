package GUI;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ArregloImagen {
	
	public static Icon Acomodar(ImageIcon img,JLabel jLabel1) {				//acomoda la imagen al tamaño maximo del label
		Icon toReturn;
		toReturn=new ImageIcon(img.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
		return toReturn;
		
	}

}
