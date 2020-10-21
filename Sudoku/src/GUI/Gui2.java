package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.GridLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import Factory.FactoryIMG;
import Singletone.singleton;

import javax.swing.border.LineBorder;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Gui2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel matriz[][];				//referencias a los labels de la matriz
	private JPanel panel;
	private int Seleccionado[];				//-1 si no ha ynada seleecionado
	private JLabel Tiempo[];				//guardo referencia a los labels del tiempo -":"
	private JLabel lblVictoria;
	private JPanel[][] subMatriz;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui2() {
		Seleccionado= new int[2];
		Seleccionado[0]=-1;
		Seleccionado[1]=-1;
		subMatriz=new JPanel[3][3];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(609, 11, 170, 520);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(10, 11, 46, 14);
		panel_1.add(lblTiempo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 36, 150, 82);
		panel_1.add(panel_3);
		
		Tiempo = new JLabel[4];
		
		FactoryIMG aux= new FactoryIMG();
		panel_3.setLayout(null);
		JLabel lblT1 = new JLabel();
		lblT1.setLocation(00, 25);
		lblT1.setSize(30,35);
		panel_3.add(lblT1);
		Tiempo[0]=lblT1;
		
		JLabel lblT2 = new JLabel();
		lblT2.setLocation(30, 25);
		lblT2.setSize(30,35);
		panel_3.add(lblT2);
		Tiempo[1]=lblT2;
		
		JLabel lblT3 = new JLabel();
		lblT3.setLocation(60, 25);
		lblT3.setSize(30,35);
		lblT3.setIcon(ArregloImagen.Acomodar(aux.getPuntos(),lblT1));
		panel_3.add(lblT3);
		
		JLabel lblT4 = new JLabel();
		lblT4.setLocation(90, 25);
		lblT4.setSize(30,35);
		panel_3.add(lblT4);
		Tiempo[2]=lblT4;
		
		JLabel labelT5 = new JLabel();
		labelT5.setLocation(120, 25);
		labelT5.setSize(30,35);
		panel_3.add(labelT5);
		Tiempo[3]=labelT5;
		
		lblVictoria = new JLabel();
		lblVictoria.setBounds(10, 169, 150, 160);
		ImageIcon Img= aux.getVictoria();
		lblVictoria.setSize(150, 160);
		lblVictoria.setIcon(ArregloImagen.Acomodar(Img, lblVictoria));
		panel_1.add(lblVictoria);
		lblVictoria.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(609, 542, 170, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				singleton.getReloj().restart();
				singleton.getJuego().reset();
				lblVictoria.setVisible(false);
			}
		});
		btnReset.setFocusable(false); //sino se focusea el boton y el listener de la matriz deja de funcionar
		panel_2.add(btnReset);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 589, 589);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 11, 180, 180);
		panel.add(panel_4);
		subMatriz[0][0]=panel_4;
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(200, 11, 180, 180);
		panel.add(panel_5);
		subMatriz[0][1]=panel_5;
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(390, 11, 180, 180);
		panel.add(panel_6);
		subMatriz[0][2]=panel_6;
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(10, 202, 180, 180);
		panel.add(panel_7);
		subMatriz[1][0]=panel_7;
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(200, 202, 180, 180);
		panel.add(panel_8);
		subMatriz[1][1]=panel_8;
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(390, 202, 180, 180);
		panel.add(panel_9);
		subMatriz[1][2]=panel_9;
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.LIGHT_GRAY);
		panel_10.setBounds(10, 393, 180, 180);
		panel.add(panel_10);
		subMatriz[2][0]=panel_10;
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.LIGHT_GRAY);
		panel_11.setBounds(200, 393, 180, 180);
		panel.add(panel_11);
		subMatriz[2][1]=panel_11;
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_12.setBounds(390, 393, 180, 180);
		panel.add(panel_12);
		subMatriz[2][2]=panel_12;
		
		matriz= new JLabel[9][9];
		InicializarJLabels();
		contentPane.setFocusable(true);
		contentPane.addKeyListener(new Key());
	}
	
	
	protected void InicializarJLabels() {
		for(int o=0;o<=8;o++) {
			for(int i=0;i<=8;i++) {
				JLabel aux=new JLabel();
				aux.setSize(50, 50);
				this.matriz[i][o]=aux;
				int pos1= o/3;
				int pos2=i/3;
				subMatriz[pos1][pos2].add(matriz[i][o]);
				matriz[i][o].addMouseListener(new click(i,o));
				
			}
		}
	}
	
	public JLabel ubicacion(int a, int b) {		//retorna la referencial al label en el punto del a matriz
		JLabel toReturn=null;
		if(a<9 && b<9) {
			toReturn= matriz[a][b];
		}
		return toReturn;
		
	}
	public JLabel GetTime(int a) {				//retorna un label del cronometro
		JLabel toReturn=null;
		if(a<4)
			toReturn=Tiempo[a];
		return toReturn;
	}
	
	private class click implements MouseListener{
		private int i;
		private int o;
		
		click(int a,int b){
			i=a;
			o=b;
		}
		
		public void mouseClicked(MouseEvent arg0) {
			Seleccionado[0]=i;
			Seleccionado[1]=o;
					}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	private class Key implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {

			if(Seleccionado[0]!=-1 && Seleccionado[1]!=-1) {										//si hay algo seleccionado 
			char aux = arg0.getKeyChar();
			int aux2=-1;																			//si lo ingresado no es un valor aceptado nada cambia
			if(aux == KeyEvent.VK_BACK_SPACE) {														//si es BackSpace borro
				aux2=10; 																			//10 es el valor vacio en la factory
			}else 
				if((aux>=49)&&(aux<=57)) {															//si es un numero entre 1 y 9
					aux2=Character.getNumericValue(aux);											//me guardo el valor numerico
			}
			if (aux2!=-1)																			//si el valor es aceptado cambiamos
			singleton.getJuego().getPartida().cambiarValor(Seleccionado[0],Seleccionado[1],aux2);	//aviso al juego que cambia un valor
			
			Seleccionado[0]=-1;
			Seleccionado[1]=-1;
			if(singleton.getJuego().getPartida().ComprovarVictoria()) {
				singleton.getReloj().setFin();
				singleton.getJuego().fin();
				lblVictoria.setVisible(true);
			}
				
		}
		}
		
	}
	public void error() {
		error.main();										//si ocurre un error, se le acisa al usuario
		singleton.getReloj().setFin();						//se frena el cronometro
	}
}
