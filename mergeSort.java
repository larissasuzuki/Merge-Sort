package Sorting;

import java.util.Arrays;

public class mergeSort {
	
	public static void main (String args[]){
		Integer[] array = {3, 17, 13, 4, 12, 7, 2, 6};
		mergeSort myMerge = new mergeSort();
		myMerge.merge(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	@SuppressWarnings("rawtypes")
	public Comparable[] merge(Comparable[] array){
		
		if(array.length <=1)
			return array;
		
		Comparable[] first = new Comparable[array.length/2];
		Comparable[] second = new Comparable[array.length-first.length]; //address odd sized arrays
		
		for(int i=0; i<first.length;i++){
			first[i] = array[i];
		}
		
		int auxPointer = first.length; 
		
		for (int i=0;i<second.length;i++){
			second[i] = array[auxPointer];
			auxPointer++;
		}
		
		merge(first);
		merge(second);
		doMergeSort(first,second,array);
		
		return array;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doMergeSort(Comparable[] first, Comparable[] second, Comparable[] array){
		
		int iFirst = 0;
		int iSecond = 0;
		int iMerged = 0;
		
		while((iFirst<first.length) && (iSecond < second.length)){
			if(first[iFirst].compareTo(second[iSecond])<0){
				array[iMerged] = first[iFirst];
				iFirst++;
			}
			else{
				array[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		
		System.arraycopy(first, iFirst, array, iMerged, first.length-iFirst);
		System.arraycopy(second, iSecond, array, iMerged, second.length-iSecond);
		
		
	}

}
