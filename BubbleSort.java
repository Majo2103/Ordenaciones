package Ordenacioneas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort <T extends Comparable <T>>{
	
	public static<T> String toString(T[] arre) {
		StringBuilder bob=new StringBuilder();
		for (int i=0;i<arre.length;i++) {
			bob.append("\n");
			bob.append(arre[i].toString());
		}	
		return bob.toString();	
	}
	
	public static <T extends Comparable <T>> void bubbleSort(T[] arre) {
		bubbleSort(arre,arre.length);
	}
	
	public static <T extends Comparable <T>> void bubbleSort(T[] arre, int n) {
		if(n==1)
			return;
		
		for (int i = 0; i < n - 1; i++) {
	        if (arre[i].compareTo(arre[i + 1])>0) 
	            swap(arre,i,i+1);
	    }
		
		bubbleSort(arre,n-1);
	}
	
	private static<T extends Comparable<T>> void swap(T[] arre,int a,int b) {
		T aux=arre[a];
		arre[a]=arre[b];
		arre[b]=aux;
	}
	
	public static void main(String[] args) {
		/*
		 * LECTURA DE ARCHIVO
		 */
			List<Pelicula> peliculas = new ArrayList<>();
			
	        try {
	            FileReader fileReader = new FileReader("movie_titles.txt"); 
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String line;
	
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] parts = line.split(",");
	                Integer key = Integer.parseInt(parts[0]);
	                Integer year = Integer.parseInt(parts[1]);
	                String name = parts[2].trim();
	                Pelicula movie = new Pelicula(key, year, name);
	                peliculas.add(movie);
	            }
	            

	
	            bufferedReader.close();
	            fileReader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        /*
	         * Creación de arreglo de peliculas
	         */
	        Pelicula[] cartelera =new Pelicula[peliculas.size()];
            for(int i=0;i<peliculas.size();i++)
            	cartelera[i]=peliculas.get(i);
            
            bubbleSort(cartelera);
           System.out.println( toString(cartelera));
	}
	
	

}
