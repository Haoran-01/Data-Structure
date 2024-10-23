package project2;

public class DoubleLinkList {
    public Node first;
    public Node last;
    private int size;
    public DoubleLinkList(){
        first = null;
        last = null;
        size = 0;
    }
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

    public Position insertFirst(int data){
        Node node = new Node(data);
        node.next = first;
        if (first != null){
            first.previous = node;
        } else {
            last = node;
        }
        first = node;
        size++;
        System.out.println("The number " + data + " has been inserted at the beginning");
        return node;
    }

    public Position insertLast(int data){
        Node node = new Node(data);
        node.previous = last;
        if (last != null){
            last.next = node;
        }
        last = node;
        size++;
        System.out.println("The number " + data + " has been inserted at the end");
        return node;
    }

    public Position insertAfter(Node position,int data){
        Node n = new Node(data);
        if (position.next == null){
            insertLast(data);
        }else{
            n.next = position.next;
            n.previous = position;
            position.next.previous = n;
            // or can use after(p) method
            position.next = n;
        }
        System.out.println("The number " + data + " has been inserted after " + position.element);
        size++;
        return n;
    }

    public Position insertBefore(Node position,int data){
        Node n = new Node(data);
        if (position.previous == null){
            insertFirst(data);
        }else{
            n.next = position;
            n.previous = position.previous;
            position.previous.next = n;
            position.previous = n;
        }
        System.out.println("The number " + data + " has been inserted before " + position.element);
        size++;
        return n;
    }

    public void printList(Node node){
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null){
            System.out.print(node.element + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.element + " ");
            last = last.previous;
        }
    }

    public int remove(Node position){
        int data = position.element();
        // assume that the data is int, is also can be an Object
        // if the position is the first and the last
        if (position.previous == null){
            position.next.previous = null;
        } else if (position.next == null){
            position.previous.next = null;
        } else {
            position.next.previous = position.previous;
            position.previous.next = position.next;
        }
        size--;
        System.out.println("The number " + data + " has been removed");
        return data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        int[] testExample = new int[]{4,5,6,7,12,23,45,2};
        for (int i = 0; i < testExample.length/2; i++){
            doubleLinkList.insertFirst(testExample[i]);
        }
        for (int i = 0; i < testExample.length/2; i++){
            doubleLinkList.insertLast(testExample[i+4]);
        }

        doubleLinkList.printList(doubleLinkList.first);
        doubleLinkList.insertLast(45);
        doubleLinkList.insertAfter(doubleLinkList.first.next,9);
        doubleLinkList.insertBefore(doubleLinkList.last.previous, 10);
        doubleLinkList.remove(doubleLinkList.first.next.next.next);
        doubleLinkList.printList(doubleLinkList.first);
    }
}
