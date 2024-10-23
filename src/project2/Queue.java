package project2;

public interface Queue {
    public void enqueue (int element);
    public int dequeue();
    public int front();
    public int size();
    public boolean isEmpty();
}
