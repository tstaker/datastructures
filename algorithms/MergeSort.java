class MergeSort {
  public static void main(String[] args) {
    
    int array[] = {72, 8, 21, 52, 7, 14, 16};
    
    MergeSort ms = new MergeSort();
    
    ms.mergeSort(array, 0, 6);
    
    for(int i = 0; i < 7; i++){
      System.out.print(array[i] + " "); 
    }
    return;
  }
  
  void mergeSort(int arr[], int startIndex, int endIndex){
    
    //Base case
    if(startIndex >= endIndex){
      return;
    }
    
    int midIndex = (startIndex + endIndex)/2;
    mergeSort(arr, startIndex, midIndex);
    mergeSort(arr, midIndex + 1, endIndex);
    
    merge(arr, startIndex, midIndex, endIndex);

  }
  
  void merge(int arr[], int startIndex, int midIndex, int endIndex){
     
    int startArr[] = new int[midIndex - startIndex + 1];
    int endArr[] = new int[endIndex - midIndex];
    
    for(int i = 0; i < midIndex - startIndex + 1; i++){
      startArr[i] = arr[startIndex + i]; 
    }
    
    for(int i = 0; i < endIndex - midIndex; i++){
      endArr[i] = arr[midIndex + 1 + i]; 
    }
    
    int startArrIndex = 0;
    int endArrIndex = 0;
    int arrIndex = startIndex;
    
    while(startArrIndex < midIndex - startIndex + 1 &&
          endArrIndex < endIndex - midIndex){
      //If start array's element should be put in next
      if(startArr[startArrIndex] <= endArr[endArrIndex]){
        arr[arrIndex] = startArr[startArrIndex];
        startArrIndex++;
      }
      //If end array's element should be put in next
      else{
        arr[arrIndex] = endArr[endArrIndex]; 
        endArrIndex++;
      }
      arrIndex++;
    }
    
    while(startArrIndex < midIndex - startIndex + 1){
      arr[arrIndex] = startArr[startArrIndex];
      startArrIndex++;
      arrIndex++;
    }
    
    while(endArrIndex < endIndex - midIndex){
      arr[arrIndex] = endArr[endArrIndex];
      endArrIndex++;
      arrIndex++;
    }
  }
}
