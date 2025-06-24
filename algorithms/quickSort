import java.io.*;
import java.util.*;

class QuickSort {
  public static void main(String[] args) {
    
    int[] array = {75, 25, 50, 30, 90, 11, 77, 15, 0};
    
    QuickSort qs = new QuickSort();
    
    qs.quickSort(array, 0, array.length - 1);
    
    qs.printArray(array);
    
  }
  
  public void quickSort(int[] arr, int leftIndex, int rightIndex){
    
    if(leftIndex >= rightIndex){
      return;
    }
    
    //Don't do left + right / 2 here because of possibility of overflow
    int pivot = arr[leftIndex + (rightIndex - leftIndex)/2];
    int partition = partition(arr, leftIndex, rightIndex, pivot);
    quickSort(arr, leftIndex, partition - 1);
    quickSort(arr, partition, rightIndex);
  }
  
  public int partition(int[] arr, int leftIndex, int rightIndex, int   
                        pivot){
     
    while(leftIndex <= rightIndex){
       
        //Move left and right indexes until they point
        //to values to be swapped
        while(arr[leftIndex] < pivot){
          leftIndex++; 
        }
        while(arr[rightIndex] > pivot){
          rightIndex--; 
        }
      
        //Swaps values
        if(leftIndex <= rightIndex){
          int temp = arr[leftIndex];
          arr[leftIndex] = arr[rightIndex];
          arr[rightIndex] = temp;
        
          leftIndex++;
          rightIndex--;
        }
    }
    
    return leftIndex;
    
  }
  
  public void printArray(int[] arr){
    for(int i = 0; i <  arr.length; i++){
      System.out.print(arr[i] + " "); 
    }
  }
}
