package Ordenacioneas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Cine <T>{
	
	static  Integer cont = 0;
	/*
	 * METODOS DE ORDENAMIENTO
	 */
	
	//SELECTION SORT
	public static<T extends Comparable<T>> int selectionSort(T[] cartelera){
		int min;
		int res=0;
		for(int i=0;i<cartelera.length;i++) {
			min=i;
			for (int j=i;j<cartelera.length;j++) { 
				res++;
				if(cartelera[j].compareTo(cartelera[min])<0)
					min=j;
			}
		}
		return res;
	}
	
	//INSERTION SORT
	public static<T extends Comparable<T>> int insertionSort(T[] arre){
		int res=0;
		for(int i=1; i<arre.length;i++) {
			int j=i;
			res++;
			while(j>=1 && arre[j].compareTo(arre[j-1])<0) {
				res++;
				swap(arre,j,j-1);
				j--;
			}
		}
		
		return res;
	}
	
	private static<T extends Comparable<T>> void swap(T[] arre,int a,int b) {
		T aux=arre[a];
		arre[a]=arre[b];
		arre[b]=aux;
	}
	
	//BUBBLE SORT
	
	public static <T extends Comparable <T>> int bubbleSort(T[] arre) {
		return bubbleSort(arre,arre.length,0);
	}
	
	private static <T extends Comparable <T>> int bubbleSort(T[] arre, int n,int res) {
		if(n==1)
			return res;
		
		for (int i = 0; i < n - 1; i++) {
			res++;
	        if (arre[i].compareTo(arre[i + 1])>0) 
	            swap(arre,i,i+1);
	    }
		
		return bubbleSort(arre,n-1,res);
	}
	
	//QUICK SORT
	
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
	
	
	
	//MERGE SORT
	
	public static <T extends Comparable<T>> void mergeSort(T[] datos){
        mergeSort(datos,0,datos.length-1);
   }
   
   private static <T extends Comparable<T>>void mergeSort(T[] datos, int inf, int sup){
       
       
       
       if(inf < sup){
           
         int mitad = (inf + sup)/2;
         cont++;
         
         mergeSort(datos, inf, mitad);
         mergeSort(datos, mitad+1, sup);
         
         
         
        merge(datos,inf,mitad,sup);
       }
       
       
       
       
   }
   
   private static <T extends Comparable<T>>void merge(T[] datos, int inf, int mitad, int sup){
       
       
       int i, j, k;
       int tam1 = mitad-inf+1;
       int tam2 = sup-mitad;
       
       T[] temp1 = (T[]) new Comparable[tam1];
       T[] temp2 = (T[]) new Comparable[tam2];
       
       
       
       for (i = 0; i < tam1; ++i) {
           cont++;
           temp1[i] = datos[inf + i]; 
       }
       
       for (j = 0; j < tam2; ++j){ 
           cont++;
           temp2[j] = datos[mitad + 1 + j]; 
       }
       
       i = 0;
       j = 0; 
       k = inf; 
       
       while(i < tam1 && j < tam2){
           
           cont++;
           if(temp1[i].compareTo(temp2[j]) <= 0){
               datos[k] = temp1[i];
               i++;
               cont++;
             
           }
           else{
               datos[k] = temp2[j];
               j++;
               cont++;
           }
           k++;    
       }
       
       while(i < tam1){
           cont++;
           datos[k] = temp1[i];
           i++;
           k++;
                  
       }
       
       while(j < tam2){
           cont++;
           datos[k] = temp2[j];
           j++;
           k++;
                  
       }
       
      
       
   }
	

	
	public static<T> String toString(T[] arre) {
		StringBuilder bob=new StringBuilder();
		for (int i=0;i<arre.length;i++) {
			bob.append("\n");
			bob.append(arre[i].toString());
		}	
		return bob.toString();	
	}
	
	public static<T> void shuffle(T[] array, int n)
	{
	    Random rand = new Random();
	    for (int i = 0; i < n - 1; i++)
	    {
	        int j = rand.nextInt(i, n);
	        T temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	}
	
	
	public static Pelicula[] subArreglo(Pelicula[]arre,int n) {
		Pelicula[] res= new Pelicula[n];
		for(int j=0; j<n;j++) {
			res[j]=arre[j];
		}
		return res;
	}
	
	public static <T> void reverseArray(T[] arr) {
	    int left = 0;
	    int right = arr.length - 1;
	    
	    while (left < right) {
	        T temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	        left++;
	        right--;
	    }
	}

	
	
	

	public static<T> void main(String[] args) {
		
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
            
       /*
        * EXPERIMENTO ORDENADO
        */
            
            int[] ns= {100,1000,2500,5000,10000,15000};
            
          
            		
            quickSort(cartelera);
            reverseArray(cartelera);
           

         

	       
            Pelicula []arre;
            Integer comp=0;
            Integer sum;
           long divisor=30;
         
        
	      for(int i=0;i<6;i++) {
	    	  
	
	    	  
	    	  
	    	  arre=subArreglo(cartelera,ns[i]);
	    	  shuffle(arre,ns[i]);
	    	  long startTime = System.nanoTime();
	    	  
	    	 mergeSort(arre);
	    	  
	    	  long endTime = System.nanoTime();
	    	  long time = endTime - startTime;
	          
	    	 System.out.println(cont);
	    	 cont=0;
	    	  
	      }
	      
	      
	    }
	
     
	
	
	
		

}
