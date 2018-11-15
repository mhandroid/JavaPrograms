package com.mub.sorting;

public class MergeSort {

	public void mergeSort(int leftArray[], int rightArray[], int mainArray[]) {
		int nL = leftArray.length;
		int nR = rightArray.length;

		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if (leftArray[i] <= rightArray[j]) {
				mainArray[k] = leftArray[i];
				i = i + 1;
				k = k + 1;
			} else {
				mainArray[k] = rightArray[j];
				j = j + 1;
				k = k + 1;
			}

		}
		while (i < nL) {
			mainArray[k] = leftArray[i];
			i = i + 1;
			k = k + 1;
		}
		while (j < nR) {
			mainArray[k] = rightArray[j];
			k = k + 1;
			j = j + 1;
		}
	}
	
	public void merge(int array[]) {
		int n = array.length;
		if(n<2) {
			return;
		}
		int mid = n/2;
		int leftArray[] = new int[mid];
		int rightArray[] = new int[n-mid];
		for(int i=0;i<mid;i++) {
			leftArray[i] = array[i];
		}
		for(int k=0,j=mid;j< n;j++,k++) {
			rightArray[k] = array[j];
		}
		
		merge(leftArray);
		merge(rightArray);
		mergeSort(leftArray, rightArray, array);
	}
	public static void main(String[] args) {
		int array[] = {-10,4,9,1,6,2,11,5,0};
		MergeSort mergeSortObj=new MergeSort();
		mergeSortObj.merge(array);
		for(int a:array) {
			System.out.println(a);
		}
	}
}
