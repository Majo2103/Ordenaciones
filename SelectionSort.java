package Ordenacioneas;

public class SelectionSort {
	

	public static<T extends Comparable<T>> void selectionSort(T[] arre){
		int min;
		for(int i=0;i<arre.length;i++) {
			min=i;
			for (int j=i;j<arre.length;j++) 
				if(arre[j].compareTo(arre[min])<0)
					min=j;
		}
	}
}
