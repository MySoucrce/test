package ListPractice;


import org.omg.CORBA.Any;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList() {
        doClear();
    }

    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    public void doClear(){
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }
    public int size(){
        return this.theSize;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }
    public void add(int index, AnyType x){
        addBefore(getNode(index, 0, size()), x);
    }
    public AnyType get(int index){
        return getNode(index).data;
    }
    public AnyType set(int index, AnyType newVal){
        Node<AnyType> p = getNode(index);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }
    public AnyType remove(int index){
        return  remove(getNode(index));
    }
    private void addBefore(Node<AnyType> p, AnyType x){
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    private AnyType remove(Node<AnyType> p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }
    private Node<AnyType> getNode(int index){
        return getNode(index, 0, size()-1);
    }
    private Node<AnyType> getNode(int index, int lower, int upper){

    }
    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }
}
