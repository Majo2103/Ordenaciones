package Ordenacioneas;

public class InsertionSort<T>{
	
	//En el peor de los casos O(n**2) donde n es el numero de elementos
		public static<T extends Comparable<T>> T[] insertionSort(T[] arre){
			for(int i=1; i<arre.length;i++) {
				int j=i;
				while(j>=1 && arre[j].compareTo(arre[j-1])<0) {
					swap(arre,j,j-1);
					j--;
				}
			}
			
			return arre;
		}
		
		private static<T extends Comparable<T>> void swap(T[] arre,int a,int b) {
			T aux=arre[a];
			arre[a]=arre[b];
			arre[b]=aux;
		}
		
		public static<T> String imprimeArre(T[] arre) {
			StringBuilder bob=new StringBuilder();
			for(int i=0;i<arre.length;i++)
				bob.append("["+arre[i]+"]");
			
			return bob.toString();		
		}
		
		
		
}
