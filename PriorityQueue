import java.io.*;
import java.util.*;

class PriorityQueue<E extends Comparable<E>> {
  
  public static void main(String[] args){
    
    int[] array = {6, 9, 3, 7, 1, 2, 8, 5, 4};
    
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(0);
    
    for(int i = 0; i < array.length; i++){
      pq.add(array[i]); 
    }
    
    for(int i = 0; i < array.length; i++){
      System.out.print(pq.poll() + " ");
    }
    
    
  }
  
  class Node<T>{
    
    T data;
    Node<T> leftNode;
    Node<T> rightNode;
    
    public Node(T data){
      this.data = data;
      leftNode = null;
      rightNode = null;
    }
    
    public void setLeft(Node<T> n){
      leftNode = n;
    }
    
    public void setRight(Node<T> n){
      rightNode = n; 
    }
    
    public void setData(T data){
      this.data = data; 
    }
    
    public Node<T> getLeft(){
      return leftNode; 
    }
    
    public Node<T> getRight(){
      return rightNode; 
    }
    
    public T getData(){
      return data; 
    }
    
  }
  
  Node<E> head;
  int size;
  
  public PriorityQueue(E value){
    head = new Node<E>(value);
    size = 1;
    head.setRight(null);
    head.setLeft(null);
  }
  
  public void add(E value){
    
    if(size == 1){
      //Value should be at head
      if(value.compareTo(head.getData()) < 0){
        head.setLeft(new Node<E>(head.getData()));
        head.setData(value);
      }
      //Value is a child of head
      else{
        head.setLeft(new Node<E>(value)); 
      }
      size++;
      return;
    }
    
    Node<E> temp = head;
    Node<E> tempParent = head;
    boolean isLeft = true;
    while(temp.getLeft() != null || temp.getRight() != null){
      //Value <= node, done searching for spot to insert
      if(value.compareTo(temp.getData()) <= 0){
        //Set new node to left of parent of temp
        if(isLeft){
          tempParent.setLeft(new Node<E>(value));
          tempParent.getLeft().setLeft(temp);
        }
        //Set new node to right of parent of temp
        else{
          tempParent.setRight(new Node<E>(value));
          tempParent.getLeft().setLeft(temp);
        }
        size++;
        return;
      }
      //Value > node, keep searching
      else{
        //Left is null, add here
        if(temp.getRight() == null){
          //Set new node to left of parent of temp
          if(isLeft){
            tempParent.setLeft(new Node<E>(value));
            tempParent.getLeft().setLeft(temp);
          }
          //Set new node to right of parent of temp
          else{
            tempParent.setRight(new Node<E>(value));
            tempParent.getLeft().setLeft(temp);
          }
          size++;
          return;
        }
        //Right is null, add here
        else if(temp.getLeft() == null){
          //Set new node to left of parent of temp
          if(isLeft){
            tempParent.setLeft(new Node<E>(value));
            tempParent.getLeft().setLeft(temp);
          }
          //Set new node to right of parent of temp
          else{
            tempParent.setRight(new Node<E>(value));
            tempParent.getLeft().setLeft(temp);
          }
          size++;
          return;
        }
        //Left child > right child
        else if(temp.getLeft() != null &&  
          temp.getLeft().getData().compareTo(temp.getRight().getData()) > 0){
          tempParent = temp;
          temp = temp.getLeft();
          isLeft = true;
        }
        //Right child >= left child
        else if(temp.getRight() != null){
          tempParent = temp;
          temp = temp.getRight();
          isLeft = false;
        }
      }
    }
  }
  
  public E peek(){
    return head.getData(); 
  }
  
  //Method currently doesn't work
  public E poll(){
    E retVal = head.getData();
    boolean leftLast = true;
    
    if(head.getRight() == null){
       head.setData(head.getLeft().getData());
    }
    else if(head.getLeft() == null){
      head.setData(head.getRight().getData()); 
    }
    //If left child < right
    else if(head.getLeft().getData().compareTo(head.getRight().getData()) < 0){
      head.setData(head.getLeft().getData());
    }
    //If right child <= left
    else{
      head.setData(head.getRight().getData());
    }
    
    Node<E> temp = head;
    Node<E> tempParent = head;
    
    while(temp.getLeft() != null || temp.getRight() != null){
      if(temp.getRight() == null){
        temp.setData(temp.getLeft().getData());
        tempParent = temp;
        temp = temp.getLeft();
        leftLast = true;
      }
      else if(temp.getLeft() == null){
        temp.setData(temp.getRight().getData());
        tempParent = temp;
        temp = temp.getRight();
        leftLast = false;
      }
      //If left child < right
      else if(temp.getLeft().getData().compareTo(temp.getRight().getData()) < 0){
        temp.setData(temp.getLeft().getData());
        tempParent = temp;
        temp = temp.getLeft();
        leftLast = true;
      }
      //If right child <= left
      else{
        temp.setData(temp.getRight().getData());
        tempParent = temp;
        temp = temp.getRight();
        leftLast = false;
      }
    }
    
    //Removes node that value was taken from
    if(leftLast){
      tempParent.setLeft(null);
    }
    else{
      tempParent.setRight(null);
    }
    size--;
    return retVal;
  }
  
}
