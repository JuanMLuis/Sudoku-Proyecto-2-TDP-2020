package GUI;
import Singletone.singleton;

public class CeldaGrafica extends CeldaGraficaAbstracta {
	
		public CeldaGrafica(int a,int b) {						//constructor para matriz
			grafico=singleton.getGui().ubicacion(a, b);			//inicia matriz
			setImage(10);										//le pone imagen 10 (espacio vacio)
			
		}
		
		public CeldaGrafica(int a) {							//constructor para los espacios del cronometro
			grafico=singleton.getGui().GetTime(a);				//le asigna una posicion grafica del cronometro
		}

}
