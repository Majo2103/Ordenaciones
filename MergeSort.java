package Ordenacioneas;

public class MergeSort <T extends Comparable <T>>{
	
	public static<T extends Comparable<T>> void mergeSort(T[]arre,int min,int max) {
		//Caso base
		if(min<max) {
			int mitad=(max+min)/2;
			
			//llamadas recursivas
			mergeSort(arre,min,mitad);
			mergeSort(arre,mitad+1,max);
			
			//mezcla
			mezcla(arre,min,mitad,max);
		}
				
	}
	
	private static<T extends Comparable<T>> void mezcla(T[] arre,int min,int mitad,int max) {
		//Preparacion de mezcla 
		
		T[] temp1=(T[]) new Comparable[mitad-min+1];
		T[] temp2 =(T[])new Comparable[max-mitad];
		 
		 //llena los arreglos temporales
		 for(int i=0;i<temp1.length;i++)
			 temp1[i]=arre[min+i];
		 for(int j=0;j<temp2.length;j++)
			 temp2[j]=arre[mitad+1+j];
			
		 //System.out.println("temp1"+imprimeArre(temp1));
		 //System.out.println("temp2"+imprimeArre(temp2));
		 
		//Comienzo de mezcla 
		 
		 int aux1=0;
		 int aux2=0;
		 int k=min;
		 
		 while(aux1<temp1.length && aux2<temp2.length) {
			 if(temp1[aux1].compareTo(temp2[aux2])<=0) {
				 arre[k]=temp1[aux1];
				 aux1++;
			 }else {
				 arre[k]=temp2[aux2];
				 aux2++;
			 }
			 k++;
		 }
		 //si no miden lo mismo copiamos el resto
		 while (aux1 < temp1.length) {
	            arre[k] = temp1[aux1];
	            k++;aux1++;
	        }
	 
		 while (aux2 < temp2.length) {
	            arre[k] = temp2[aux2];
	            k++;aux2++;
	        }
		 //System.out.println("arre"+imprimeArre(arre));
	}
	
	public static<T> String imprimeArre(T[] arre) {
		StringBuilder bob=new StringBuilder();
		for(int i=0;i<arre.length;i++)
			bob.append("["+arre[i]+"]");
		
		return bob.toString();		
	}
	
	public static void main(String[] args) {
		Double[] arre=new Double[10];
		
		arre[0]=2.0;
		arre[1]=3.0;
		arre[2]=8.0;
		arre[3]=1.0;
		arre[4]=5.14;
		arre[5]=9.0;
		arre[6]=4.0;
		arre[7]=6.5;
		arre[8]=10.0;
		arre[9]=7.0;
		
		System.out.println("arre: "+imprimeArre(arre));
		//System.out.println("arre ordenado(insertionSort): "+imprimeArre(insertionSort(arre)));
		mergeSort(arre,0,9);
		System.out.println("arre ordenado(mergeSort): "+imprimeArre(arre));
	}
}
