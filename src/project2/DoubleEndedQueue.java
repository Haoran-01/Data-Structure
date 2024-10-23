package project2;

public class DoubleEndedQueue implements Deque{
    public Node first;
    public Node last;
    private int size;

    class Node implements Position {
        // element store the data
        private int element;
        Node next;
        Node previous;
        public Node (int d){
            this.element = d;
        }
        public int element() {
            return element;
        }
    }

    class EmptyDequeException extends RuntimeException{
        // if we try and remove or access an element in an empty queue, it will thorw this exception
        // this exception is uncheck because it extends RuntimeException class
    }

    public DoubleEndedQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(int data){
        Node n = new Node(data);
        if(isEmpty()){
            first = n;
            last = n;
        } else {
            n.next = first;
            first.previous = n;
            first = n;
        }
        System.out.println(data + " is been added in the beginning of the queue");
        size++;
    }

    public void addLast(int data){
        Node n = new Node(data);
        if(isEmpty()){
            first = n;
        } else {
            n.previous = last;
            last.next = n;
        }
        last = n;
        System.out.println(data + " is been added in the end of the queue");
        size++;
    }

    public int removeFirst(){
        if(isEmpty()) {
            throw new EmptyDequeException();
        }
        int data = first.element;
        // remove first element
        first = first.next;
        if(size == 1){
            first = null;
            last = null;
        } else {
            first.previous = null;
        }
        System.out.println(data + " is been removed from the front of queue");
        size--;
        return data;
    }

    public int removeLast(){
        if(isEmpty()){
            throw new EmptyDequeException();
        }
        int data = last.element;
        last = last.previous;
        if (size == 1){
            first = null;
            last = null;
        } else {
            last.next = null;
        }
        size--;
        System.out.println(data + " is been removed from the rear of queue");
        return data;
    }

    @Override
    public int getFirst() throws EmptyDequeException {
        return first.element();
    }

    @Override
    public int getLast() throws EmptyDequeException {
        return last.element();
    }

    @Override
    public int size() {
        return size;
    }

    public void printList(Node node){
        if (node == null){
            return;
        }
        printList(node.next);
        System.out.print(node.element() + " ");
    }
    public static void main(String[] args) {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue();
        int[] testExample = new int[]{4,5,6,7,12,23,45,2};
        for (int i = 0; i < testExample.length/2; i++){
            doubleEndedQueue.addFirst(testExample[i]);
        }
        for (int i = 0; i < testExample.length/2; i++){
            doubleEndedQueue.addLast(testExample[i + 4]);
        }
        System.out.println("Traversal in forward Direction");
        doubleEndedQueue.printList(doubleEndedQueue.first);
        System.out.println();

        doubleEndedQueue.removeFirst();
        doubleEndedQueue.removeLast();

        System.out.println("Traversal in forward Direction");
        doubleEndedQueue.printList(doubleEndedQueue.first);
        System.out.println();
    }
}
