package project2;

class LinkQueue implements Queue{
    class Node {
        int data;
        Node next;
        public Node(int i){
            data = i;
        }
    }
    private int size;
    private Node front;
    private Node rear;
    public void enqueue(int data){
        Node n = new Node(data);
        if(size == 0){
            front = n;
        }else{
            rear.next = n;
        }
        rear = n;
        size++;
        System.out.println(data + " is enqueue in the linkQueue");
    }
    public int dequeue(){
        if (front == null){
            System.out.println("Queue reach the end");
            System.exit(1);
        }
        int data = front.data;
        // remove the front item
        front = front.next;
        size--;
        System.out.println(data + " is dequeue in the linkQueue");
        return data;
    }

    public void printLinkList(Node front) {
        if (front == null) {
            return;
        }
        printLinkList(front.next);
        System.out.print(front.data + " ");
    }

    public int front(){
        return front.data;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        int[] testNumber = new int[]{4,5,6,7,12,23,45};
        // put all number in the queue
        for (int i = 0; i < testNumber.length; i++){
            linkQueue.enqueue(testNumber[i]);
        }

        System.out.print("Traversal in forward Direction: ");
        linkQueue.printLinkList(linkQueue.front);
        System.out.println();
        // call dequeue three times
        for (int i = 0; i < 3; i++){
            linkQueue.dequeue();
        }
        // enqueue 65
        linkQueue.enqueue(65);

        System.out.print("Traversal in forward Direction: ");
        linkQueue.printLinkList(linkQueue.front);
        System.out.println();
        // call dequeue 7 times
        for (int i = 0; i < 7; i++) {
            linkQueue.dequeue();
        }
    }
}