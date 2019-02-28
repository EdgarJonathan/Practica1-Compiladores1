package Generador;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Analisis.*;
import Logica.*;
import Ventana.*;

public class generadorGrafica {

		
	
	public void GraficaBarras() 
	{
		for (int i = 0; i < Contenedor.GBarras.size(); i++) {
			GraficaB graf = Contenedor.GBarras.get(i);	
			graficaBarra(graf);
		}
		
	}
	
	
	void graficaBarra(GraficaB grafica)
	{
		
		try {


		      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		      
		      for (int i = 0; i < grafica.puntos.size(); i++) {
		    	   Punto punto = grafica.puntos.get(i);
		    	   String x = grafica.ejex.get(punto.x);
		    	   Integer y = grafica.ejey.get(punto.y);
		    	   dataset.addValue( y , x , x ); 
				
		      }
		     
		      JFreeChart barChart = ChartFactory.createBarChart(
		         grafica.titulo, 
		         grafica.titulox, grafica.tituloy, 
		         dataset,PlotOrientation.VERTICAL, 
		         true, true, false);
		         
		      int width = 640;    // Width of the image
		      int height = 480;   // Height of the image 
		      File BarChart = new File( "Galeria/Originales"+grafica.id+".jpeg" ); 
		      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
		      
		      
		      
		      
		      System.out.println("todo excelente");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("algo paso");
			
		}
		
	}
	
	public void GraficaLinea() 
	{
		for (int i = 0; i < Contenedor.GLineas.size(); i++) {
			GraficaL graf = Contenedor.GLineas.get(i);	
			lineas(graf);
		}
		
	}
	
	 void lineas(GraficaL grafica) 
	{
		 String nombre="";
		 String color="";
		 float grosor=0;
		 Integer x=0;
		 Integer y=0;
		final XYSeriesCollection dataset = new XYSeriesCollection( );
		try {
			
			for (int i = 0; i < grafica.lineas.size(); i++) {
				
				
				nombre = grafica.lineas.get(i).nombre;
				LinkedList<Punto> puntos = grafica.lineas.get(i).puntos;

				final XYSeries temp  = new XYSeries(nombre);

				for (int j = 0; j < puntos.size(); j++) {
					x= puntos.get(j).x;
					y= puntos.get(j).y;
					temp.add(x,y);
					
				}	
				
				dataset.addSeries(temp);
				
			}

		      JFreeChart xylineChart = ChartFactory.createXYLineChart(
		         grafica.titulo,grafica.titulox,grafica.tituloy, 
		         dataset,PlotOrientation.VERTICAL, 
		         true, true, false);
		      
		      
		      XYPlot plot = xylineChart.getXYPlot();
		      
		      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		      
		      
		      for (int i = 0; i < grafica.lineas.size(); i++) {
					
		    	  grosor = grafica.lineas.get(i).grosor;
		    	  color = grafica.lineas.get(i).color;
		    	 
		    	  	if(color.equalsIgnoreCase("azul")) {
		    	  		renderer.setSeriesPaint(i, Color.BLUE);
		    	  	}else if(color.equalsIgnoreCase("rojo")) {
		    	  		renderer.setSeriesPaint(i, Color.RED);
		    	  	}else if(color.equalsIgnoreCase("amarillo")) {
		    	  		renderer.setSeriesPaint(i, Color.YELLOW);
		    	  	}else if(color.equalsIgnoreCase("naranja")) {
		    	  		renderer.setSeriesPaint(i, Color.ORANGE);
		    	  	}else if(color.equalsIgnoreCase("negro")) {
		    	  		renderer.setSeriesPaint(i, Color.BLACK);
		    	  	}else if(color.equalsIgnoreCase("verde")) {
		    	  		renderer.setSeriesPaint(i, Color.GREEN);
		    	  	}else 
		    	  	{
		    	  		renderer.setSeriesPaint(i, Color.BLACK);
		    	  	}
		    	  

			      renderer.setSeriesStroke(i, new BasicStroke(grosor));
		
				}
		     
		      
		      
		      plot.setRenderer(renderer); 
		      
		      
		      
		      int width = 640;   /* Width of the image */
		      int height = 480;  /* Height of the image */ 
		      File XYChart = new File("Galeria/Originales"+grafica.id+".jpeg" ); 
		      ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
		      System.out.println("todo excelente");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("algo paso");
		}
		
	}
	 
	 
	public  void galeria()  
	 {
		 for(Galeria a: Contenedor.GGaleria){
	            File folder = new File("Galeria//"+a.titulo);
	            folder.mkdirs();
	            
	            //for(String b: a.Nombres){
	            for(int i=1;i<a.Nombres.size();i++) {
	            	
	            	String b= a.Nombres.get(i);
	            	
	                File original = new File("Galeria//",b+".jpg");
	                File copia = new File("Galeria//"+a.titulo,b+".jpg");
	                
	                if(original.exists()){
	                	try {
	                	    Files.copy(Paths.get(original.getAbsolutePath()), Paths.get(copia.getAbsolutePath()),StandardCopyOption.REPLACE_EXISTING);
	        	            
						} catch (Exception e) {
							
						}
	                    }else{
	                    System.out.println("El archivo "+b+".jpg"+" No se encuentra en la  "+"Galeria");
	                }
	            }
	            
	        }
		 
	 }
	 
	 
	
}
