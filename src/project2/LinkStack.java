package project2;

public class LinkStack implements Stack {
    private int size;
    private Node top;
    // initial variable size

    class Node {
        int data;
        Node next;
        public Node(int i){
            data = i;
        }
    }

    public LinkStack(){
        size = 0;
        top = null;
    }

    @Override
    public void push(int data){
        // create a new Node object to store the data
        Node n = new Node(data);
        // associate the newly joined Node with the last joined Node
        n.next = top;
        top = n;
        size++;
        System.out.println(data + " is pushed onto the stack");
    }

    @Override
    public int pop(){
        // check if the stack is empty, if is empty can't use pop method and print an error to tell that the stack is empty
        if (isEmpty()){
            System.err.println("Error to pop because this stack is empty");
            System.exit(1);
        }
        // use data to store the data that store in the Node object
        int data = top.data;
        top = top.next;
        size--;
        System.out.println(data + " is popped off of the stack");
        return data;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int top() {
        return top.data;
    }

    public void printLinkList(Node node) {
        if (node == null) {
            return;
        }
        printLinkList(node.next);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        int[] testExample = new int[]{4,5,6,7,12,23,45};
        for (int i = 0; i < testExample.length; i++){
            linkStack.push(testExample[i]);
        }
        for (int i = 0; i < 3; i++){
            linkStack.pop();
        }
        linkStack.push(65);
        linkStack.printLinkList(linkStack.top);
        for (int i = 0; i < 7; i++) {
            linkStack.pop();
        }
    }
}
