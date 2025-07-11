import java.io.*;
import java.util.*;

class HashTable {
  public static void main(String[] args) {
     
    HashTable ht = new HashTable(5);
    
    ht.insert("A");
    ht.insert("alphabet");
    ht.insert("qqq");
    ht.insert("plants");
    ht.insert("GME");
    ht.insert("soup");
    ht.insert("dump");
    ht.insert("banana");
    
    ht.printTable();
    
  }
  
  final double LOAD_FACTOR = 0.75;

  ArrayList<String> table;
  int numValues;
  int size;
  
  public HashTable(int size){
     
    table = new ArrayList<String>(size);
    for(int i = 0; i < size; i++){
      table.add(null);
    }
    this.size = size;
    numValues = 0;
  }
  
  public void insert(String value){
    
    if(value == null){
      return; 
    }
    
    int key = value.hashCode() % size;
    if(key < 0){
      key *= -1; 
    }
    if(table.get(key) == null){
      table.set(key, value); 
    }
    //Spot is taken, find a spot
    else{
      //Loop through spots until one is found
      while(table.get(key) != null){
        key++;
        if(key >= size){
          key = 0; 
        }
      }
      table.set(key, value);
    }
    numValues++;
    
    //Checks on load factor and rehashes if necessary
    double loadFactor = (numValues * 1.0)/size;
    if(loadFactor > LOAD_FACTOR){
      rehash(); 
    }
    
  }
  
  public void remove(String value){
    if(search(value) != -1){
        table.set(search(value), null);
        numValues--;
        System.out.println("Value removed");
        return;
    }
    System.out.println("Value not found");
  }
  
  //Returns key of value, or -1 if value not found
  public int search(String value){
    int key = value.hashCode() % size;
    if(key < 0){
      key *= -1; 
    }
    
    int originalKey = key;
    
    // Linear probing to find the value
    do {
      if(table.get(key) != null && table.get(key).equals(value)){
        return key;
      }
      key = (key + 1) % size;
    } while(key != originalKey && table.get(key) != null);
    
    return -1;
  }
  
  public void rehash(){
    ArrayList<String> temp = table;
    size *= 2;
    System.out.println("Rehashing");
    
    //Resize table
    table = new ArrayList<String>(size);
    for(int i = 0; i < size; i++){
      table.add(null); 
    }
    
    //Add values back into table
    numValues = 0;
    for(int j = 0; j < temp.size(); j++){
      if(temp.get(j) != null) {
        insert(temp.get(j));
      }
    }
  }
  
  public void printTable(){
    for(int i = 0; i < size; i++){
      System.out.println(i + ": " + table.get(i)); 
    }
  }
}
