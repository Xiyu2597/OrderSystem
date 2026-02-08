package collection;
import  java.util.ArrayList;



public class LinkedList<E> {
    private Node<E> head = new Node<>(null);
    private int size;
    public void add(E element,int index){
        if(index<0||index>size)
            throw new IndexOutOfBoundsException("插入非法");
        Node<E> prev=head;
        for(int i=0;i<index;i++) {
            prev = prev.next;
        }
            Node<E> node=new Node<>(element);
            node.next=prev.next;
            prev.next=node;
            size++;
    }
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        Node<E> node=head.next;
        while(node!=null){
            builder.append(node.element).append(" ");
            node=node.next;
        }
        return builder.toString();
    }

private static class Node<E>{
    private E element;
    private Node<E> next;
    public Node(E e) {
        this.element = e;
    }
    }
}
