package Timer;

import Factory.FactoryAbstracta;
import Factory.FactoryIMG;
import GUI.CeldaGrafica;
import GUI.CeldaGraficaAbstracta;


public class RelojL extends Thread {
	
	protected CeldaGraficaAbstracta Tiempo[];
	protected int Time[];
	protected boolean fin;
	
	public RelojL() {
		fin=false;
		Tiempo=new CeldaGrafica[4];
		Time = new int[4];
		for(int i=0;i<4;i++) {
			Tiempo[i]= new CeldaGrafica(i);	
			Tiempo[i].setImage(0,new FactoryIMG());
			Time[i]=0;											//inicializo el temporizador en 00:00
			}
	}
	
	public void run() {
		while(true) {									//se corta al cerrar el programa
			try {
				Thread.sleep(1000);						//cada 1 seg
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!fin) 								//si pongo el !fin como condicion de corte del while, al resetear crashea
					Aumentar();							//si no se termino freno el timer, aumentar el cronometro
			
		}
	}
	
	
	private void Aumentar(){								//actualiza el reloj, hasta un maximo de 99:60
		FactoryAbstracta aux= new FactoryIMG();
		Time[3]++;
		if(Time[3]>=10) {									//aumenta en la ultima posicion, si esta supera al 10, igualar a 0 y aumentar la siguiente
			Time[3]=0;
			Time[2]++;
			if(Time[2]>=6) {								//hay 60 sec por min
				Time[2]=0;
				Time[1]++;
				if(Time[1]>=10) {
					Time[1]=0;
					Time[0]++;
					if(Time[0]==10)
						timeReset();
				}Tiempo[0].setImage(Time[0],aux);				//seteo de las imagenes que cambiaron
			}Tiempo[1].setImage(Time[1],aux);
		}Tiempo[2].setImage(Time[2],aux);
		Tiempo[3].setImage(Time[3],aux);
	}
	
	
	public void setFin() {									//pausa el cronometro
		fin=true;
	}
	
	private void timeReset() {									//resetea el tiempo a 00:00	
		for(int i=0;i<4;i++) {
			Time[i]=0;											//inicializo el temporizador en 00:00
			}
	}
	public void restart() {									//reseatea por completo en cronometro
		for(int i=0;i<4;i++) {								
			Time[i]=0;	
			Tiempo[i].setImage(0,new FactoryIMG());
			}
			fin=false;
		}
	
	
}
