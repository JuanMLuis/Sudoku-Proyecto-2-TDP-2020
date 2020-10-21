package Logica;

import GUI.CeldaGrafica;

public class Celda {
	protected int numero;
	protected CeldaGrafica grafico;
	protected boolean lock;
	protected int fila;
	protected int columna;
	
	public Celda(int a, int b) {						//inicializa celda sin lock, en posicion de la matriz a,b
		lock=false;
		numero=10;
		grafico=new CeldaGrafica(a,b);
		fila=a;
		columna=b;
	}
	
	public void setNumber(int a) {						//cambia el valor logico y grafico por el pasado por parametro
		if (!lock) {
		numero=a;
		grafico.setImage(a);
		}
		
	}
	
	public int getNumber() {							//consulta del valor logico
		return numero;
	}
	
	public void setLock(boolean a) {					//blockea la celada, para que no puda ser cambiada
		lock=a;
	}
	

}
