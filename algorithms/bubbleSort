import java.io.*;
import java.util.*;

class BubbleSort {
  
  public static void main(String[] args){
    
    int[] array = {6, 9, 3, 7, 1, 2, 8, 5, 4};
    
    BubbleSort bs = new BubbleSort();
    
    bs.bubbleSort(array);
    
    bs.printArray(array);
    
  }
  
  public void bubbleSort(int[] arr){
    
    boolean sorted = false;
    //Size is decreased by one each time because new last element is always sorted
    int unsortedSize = arr.length - 1;
    
    while(!sorted){
      for(int i = 0; i < unsortedSize; i++){
        
        sorted = true;
        
        //If next element is greater than this one, swap them
        if(arr[i] > arr[i + 1]){
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          sorted = false;
        }
      }
      unsortedSize--;
    }
  }
  
  public void printArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
  }
  
}
