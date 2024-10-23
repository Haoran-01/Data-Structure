package project2;

public class ArrayQueue implements Queue {
    private int[] values;
    private int front;
    private int rear;
    private int maxSize;

    public ArrayQueue(int size){
        // remember the max size of the array
        maxSize = size;
        values = new int[maxSize];
    }
    public void enqueue(int i){
        values[rear] = i;
        rear++;
    }
    public int dequeue(){
        int i = values[front];
        front++;
        return i;
    }
    public int front(){
        return values[front];
    }
    public int size(){
        return maxSize;
    }
    public boolean isEmpty(){
        return front == 0;
    }
}