package project2;

public interface Deque {
    public void addFirst(int data);
    public void addLast(int data);
    public int removeFirst() throws DoubleEndedQueue.EmptyDequeException;
    public int removeLast() throws DoubleEndedQueue.EmptyDequeException;
    public int getFirst() throws DoubleEndedQueue.EmptyDequeException;
    public int getLast() throws DoubleEndedQueue.EmptyDequeException;
    public int size();
    public boolean isEmpty();
}
