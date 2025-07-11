import java.io.*;
import java.util.*;

class HeapSort {
  
  public static void main(String[] args){
    
    int[] array = {6, 9, 3, 7, 1, 2, 8, 5, 4};
    
    HeapSort hs = new HeapSort();
    
    hs.heapSort(array);
    
    hs.printArray(array);
    
  }
  
  public void heapSort(int[] arr){
    
    //Sorts array into max heap form
    for(int i = arr.length/2 - 1; i >= 0; i--){
      heapify(arr, arr.length, i); 
    }
    
    //Sorts array into ordered form
    for(int j = arr.length - 1; j >= 0; j--){
      int temp = arr[0];
      arr[0] = arr[j];
      arr[j] = temp;
      heapify(arr, j, 0);
    }
  }
  
  public void heapify(int[] arr, int size, int rootIndex){
     
    int largest = rootIndex;
    int leftChild = 2 * rootIndex + 1;
    int rightChild = 2 * rootIndex + 2;
    
    //If left child is larger than root
    if(leftChild < size && arr[leftChild] > arr[largest]){
      largest = leftChild;
    }
    
    //If right child is larger than left child and root
    if(rightChild < size && arr[rightChild] > arr[largest]){
      largest = rightChild; 
    }
    
    //Swap values if the root isn't the largest
    if(largest != rootIndex){
      int temp = arr[rootIndex];
      arr[rootIndex] = arr[largest];
      arr[largest] = temp;
      
      //Keep calling heapify until array is in heap order
      heapify(arr, size, largest);
    }
    
  }
  
  public void printArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " "); 
    }
  }
  
}
