package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Factory.FactoryIMG;
import Factory.FactoryNumerosS;
import Singletone.singleton;

public class Sudoku {
	
	protected Celda Matriz[][];
	
	public Sudoku() {					
		Matriz = new Celda[9][9];											//crea matriz
		String[] arreglo;													//valores auxiliares
		String linea;														//--
		int fila=0;															//--
		int aux1=0;															//--
		boolean fallo=false;												//--	
		for(int i=0;i<9;i++)												//inicializa la matriz
			for(int o=0;o<9;o++)											//--
				Matriz[i][o]=new Celda(i,o);								//--
			String aux=("sudoku2T.txt");									//nombre del archivo del Suduku			
		try {
			FileReader fr=new FileReader(aux);								//inicializa FileReader y BufferdReader para leer el archivo
			BufferedReader bf= new BufferedReader(fr);						//--
			while(!fallo && (linea=bf.readLine())!=null) {					//mientras no se encuentre un fallo o no estemos al final del archivo (tambien setea la linea)
				arreglo=linea.split(" ");									//pone todo el renglon del archivo en un arreglo (separado por los espacion originales)
				for(int i=0;i<arreglo.length && !fallo;i++) {				//para todos los puntos del arreglo
						try {
						aux1=Integer.parseInt(arreglo[i]);					//convierto al valor del archivo a numero
						if(aux1>=0 && aux1<=9) {
							if(aux1!=0) {
							Matriz[i][fila].setNumber(aux1,new FactoryNumerosS());				//seteo el valor que corresponde
							Matriz[i][fila].setLock(true);
							}
							}else fallo=true;										//si el valor es negativo o mayor que nueve manda error
					}catch(NumberFormatException r) {						//este error es cuando se lee algo que no sea un numero
						fallo=true;
					}
				}fila++;													//cambiamos de fila
			}bf.close();													//cerramos archivo
		}
		catch(IOException e) {												//salta al faltar algun Sudoku
				fallo=true;
			}
		if(ComprovarVictoria() && !fallo) {
			ReduccionDeSudoku();

			}else 
				fallo=true;
		if(fallo) {
			singleton.getGui().error();								//si hay error se notifica al usuario mediante la GUI
		}
		
		
	}
	
	private void ReduccionDeSudoku() {
		int cuantaQuitar = (int) Math.floor(Math.random()*15+30);//[30-45]
		int contador=0;
		int a;
		int b;
		while(contador<cuantaQuitar) {
			a= (int) Math.floor(Math.random()*9);
			b=(int) Math.floor(Math.random()*9);//[0-8]
			if(Matriz[a][b].getNumber()<10) {
			Matriz[a][b].setLock(false);
			Matriz[a][b].setNumber(10,new FactoryIMG());//valor vacio por decicion propia
			
				contador++;
			
		}
			}
		
	}


	public void cambiarValor(int i,int o,int c) {				//cambia el valor de la matriz en el punto(i,o) por c, 		no tomo encuenta valores erroneos 
		
		Matriz[i][o].setNumber(c,new FactoryIMG());
		
	}
	
	public boolean ComprovarVictoria() {
		int[] arregloAux1 = {1,2,3,4,5,6,7,8,9};																				//arreglos aux para comprobar
		int[] arregloAux2 = {1,2,3,4,5,6,7,8,9};
		boolean toReturn=true;																									//valor a retornar
		int controladorA=2;																										//controladores para revisar los cuadros 3X3
		int controladorB=2;		
																																//comienza a comprobar
			for(int i=0;i<9 && toReturn ;i++) {																				//Comprobacion de filas y columnas
				for(int o=0;o<9;o++) {
					if((Matriz[i][o].getNumber()==0) || (Matriz[o][i].getNumber()==0) || (Matriz[i][o].getNumber()==10) || (Matriz[o][i].getNumber()==10) ) toReturn=false;							//si hay un espacio vacio aun no termino
					else {
					arregloAux1[Matriz[i][o].getNumber()-1]=arregloAux1[Matriz[i][o].getNumber()-1] - Matriz[i][o].getNumber();	//si la matriz es correcta cada arreglo debe convertirse en 0's					
					arregloAux2[Matriz[o][i].getNumber()-1]=arregloAux2[Matriz[o][i].getNumber()-1] -Matriz[o][i].getNumber();
				
					}
					}
				
				for(int a=0;a<9 && toReturn;a++) {																				//comprobando si cada arreglo es 0
					toReturn=arregloAux1[a]==0;
					arregloAux1[a]=a+1;																							//devuelvo el arreglo a su valor original por si hay siguiente iteracion
					if(toReturn) {
						toReturn=arregloAux2[a]==0;
						arregloAux2[a]=a+1;
						}
					
				}
				
			}//fin de comprobacion de filas y columnas
	
				
			while(toReturn && (controladorA<9 || controladorB<9)) {//comprobacion 3x3
				for(int p=controladorA-2;p<=controladorA;p++) {
					for(int r=controladorB-2;r<=controladorB;r++) {
						arregloAux1[Matriz[p][r].getNumber()-1]=arregloAux1[Matriz[p][r].getNumber()-1]-Matriz[p][r].getNumber();	//si el cuadro tiene los valores correctos el arreglo se vuelve 0's			
					}
				}
				for(int a=0;a<9 && toReturn;a++) {																					//comprobando si el arreglo en 0
					toReturn=arregloAux1[a]==0;
					arregloAux1[a]=a+1;																								//devuelvo al valor original para el siguiente cuadro
				}
				controladorA=controladorA+3;
				controladorB=controladorB+3;
				
				}										
		return toReturn;
		
	}
	
	public void eliminar() {//borra las referencias de las celdas y vuelve este objeto inutilizable
		
			Matriz = new Celda[9][9];
			for(int i=0;i<9;i++)
				for(int o=0;o<9;o++)
					Matriz[i][o]=null;
		
	}
	public void fin() {//loquea todas las celdas para que no se puedan usar
		for(int i=0;i<9;i++) {
			for(int o=0;o<9;o++) {
				Matriz[i][o].setLock(true);
		
			}
		}
	}

}
