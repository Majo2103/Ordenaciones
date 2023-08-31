package Ordenacioneas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickSort  <T extends Comparable <T>>{
	
	public static <T extends Comparable<T>>int quickSort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return quickSort(arr, 0, arr.length - 1);
    }

	private static <T extends Comparable<T>>int quickSort(T[] arr, int left, int right) {
        int comparisons = 0;
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            comparisons += (right - left);
            comparisons += quickSort(arr, left, pivotIndex - 1);
            comparisons += quickSort(arr, pivotIndex + 1, right);
        }
        return comparisons;
    }
    
    private static <T extends Comparable<T>>int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    public static <T> void swap(T[] arr, int x, int y){
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

	
	public static<T> String toString(T[] arre) {
		StringBuilder bob=new StringBuilder();
		for (int i=0;i<arre.length;i++) {
			bob.append("\n");
			bob.append(arre[i].toString());
		}	
		return bob.toString();	
	}
	
	public static Pelicula[] subArreglo(Pelicula[]arre,int n) {
		Pelicula[] res= new Pelicula[n];
		for(int j=0; j<n;j++) {
			res[j]=arre[j];
		}
		return res;
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
            
            quickSort(cartelera);
           
           
           
           Pelicula []arre;
           int[] ns= {100,1000,2500,5000,10000,15000};
           for(int i=0;i<6;i++) {
 	    	  
 	    	  arre=subArreglo(cartelera,ns[i]);
 	    	  int comp;
 	    	  long startTime = System.nanoTime();
 	    	  comp=quickSort(arre);
 	    	  long endTime = System.nanoTime();
 	    	 
 	    	  long time = endTime - startTime;
 	          System.out.println(comp);
 	      }
           
	}
	
	

}
