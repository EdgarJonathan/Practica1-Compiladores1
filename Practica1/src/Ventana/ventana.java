package Ventana;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Font;

import Analisis.*;
import Logica.*;
import Generador.*;

public class ventana extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAnalizar;
	private JButton btnAbrir;
	private JButton btnGuardar;
	private JButton btnGuardarcomo;
	private JButton btnReporte;
	private JTextArea textoEntrada;
	private JScrollPane scrollPane;

	//----------------------------------------variables globales
	 FileOutputStream salida;
	JFileChooser seleccionar = new JFileChooser();
	File archivo ;
	Analizador_Lexico lexico;
    analisis_sintactico sintactico;
    generadorGrafica generador = new generadorGrafica();
    
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
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
	public ventana() {
		initComponents();
		
		
	}
	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			panel.setBackground(SystemColor.controlDkShadow);
			contentPane.add(panel, BorderLayout.CENTER);
			{
				btnAnalizar = new JButton("Analizar");
				btnAnalizar.setBounds(232, 435, 117, 25);
				btnAnalizar.setBackground(SystemColor.inactiveCaption);
				btnAnalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventbtnAnalizar();
					}
				});		
				panel.setLayout(null);
				panel.add(btnAnalizar);
			}
			{
				btnAbrir = new JButton("Abrir");
				btnAbrir.setBounds(12, 12, 117, 25);
				btnAbrir.setBackground(SystemColor.inactiveCaption);
				btnAbrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventbtnAbrir();
					}
				});
				panel.add(btnAbrir);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(179, 12, 117, 25);
				btnGuardar.setBackground(SystemColor.inactiveCaption);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventbtnGuardar();
					}
				});
				panel.add(btnGuardar);
			}
			{
				btnGuardarcomo = new JButton("Guardar Como");
				btnGuardarcomo.setBounds(377, 12, 135, 25);
				btnGuardarcomo.setBackground(SystemColor.inactiveCaption);
				btnGuardarcomo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventbtnGuardarComo();
					}
				});
				panel.add(btnGuardarcomo);
			}
			{
				btnReporte = new JButton("Reporte");
				btnReporte.setBounds(581, 12, 117, 25);
				btnReporte.setBackground(SystemColor.inactiveCaption);
				btnReporte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventbtnReporte();
					}
				});
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(22, 49, 694, 362);
					panel.add(scrollPane);
					{
						textoEntrada = new JTextArea();
						textoEntrada.setFont(new Font("Nimbus Sans L", Font.BOLD, 18));
						scrollPane.setViewportView(textoEntrada);
						textoEntrada.setBackground(SystemColor.textHighlightText);
					}
				}
				panel.add(btnReporte);
			}
		}
	}
	
	
	
	
//----------------------------------------------------Eventos Botones-------------------------------------		
	void EventbtnAbrir() 
	{    
		JFileChooser buscador = new  JFileChooser();
		buscador.showOpenDialog(buscador);
	
		try {
			String path = buscador.getSelectedFile().getAbsolutePath();
			muestraContenido(path);		
		} catch (Exception e) {
			
			
		}
		
	        
	}
	void EventbtnGuardar() 
	{
		
	}
	void EventbtnGuardarComo() 
	{
		if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION) 
		{
			archivo= seleccionar.getSelectedFile();
			
			if(archivo.getName().endsWith("gu")) 
			{
				String Documento  = textoEntrada.getText();
				String mensaje = guardarArchivo(archivo,Documento);
				
				System.out.println(mensaje);
			}
		}
			
	}
 	void EventbtnReporte() 
	{
		
	}
	void EventbtnAnalizar() 
	{
		 String datos = textoEntrada.getText();
	         lexico = new Analizador_Lexico(new BufferedReader(new StringReader(datos)));
	         sintactico = new analisis_sintactico(lexico);
	        
	        try
	        {
	        	System.out.println("------------Inicio Analisis----------");
	            sintactico.parse();
	            System.out.println("------------Fin Analisis--------");
	            analisis();	            
	        }catch(Exception e)
	        {
	        }
	}

	//----------------------------metodos de los botones----------------------------
	void  muestraContenido(String archivo) throws FileNotFoundException, IOException {
	      String cadena = "";
	      FileReader f = new FileReader(archivo);
	      BufferedReader b = new BufferedReader(f);
	      while((cadena = b.readLine())!=null) {
	       //   System.out.println(cadena);
	          textoEntrada.setText(textoEntrada.getText()+cadena+"\n");
	      }
	      b.close();
	}
	public String guardarArchivo(File archivo, String documento)
	{
		String result="documento no guardado";
		
		
		try {
			
			salida = new FileOutputStream(archivo);
			byte[] bytxt= documento.getBytes();
			salida.write(bytxt);
			
			result="documento guardado";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
//---------------------------------------Metodos para el analisis-----------
	void analisis() 
	{
		LinkedList<Variable> vars = sintactico.Variables;
	
		System.out.println("------------------------------INicia variables");
			for (int i = 0; i < vars.size(); i++) {
				Variable var = vars.get(i);
				System.out.println("variable: "+var.nombreVariable+" valorint:"+var.ValorEntero+" valorString:"+var.valorString);
			}
			System.out.println("------------------finaliza variables-------");	
			
			
			System.out.println("-----------------Barras -----------------");
			for (int i = 0; i < Contenedor.GBarras.size(); i++) {
				GraficaB graf = Contenedor.GBarras.get(i);
				
				System.out.println("Titulo"+graf.titulo);
				System.out.println("Titulox"+graf.titulox);
				System.out.println("Tituloy"+graf.tituloy);
			}
			
			System.out.println("-----------------Lineas -----------------");
			for (int i = 0; i < Contenedor.GLineas.size(); i++) {
				GraficaL graf = Contenedor.GLineas.get(i);
				
				System.out.println("Titulo"+graf.titulo);
				System.out.println("Titulox"+graf.titulox);
				System.out.println("Tituloy"+graf.tituloy);
			}
			
			
			generador.GraficaBarras();
			generador.GraficaLinea();
			generador.galeria();
			
			
			
	}
	
	
}







