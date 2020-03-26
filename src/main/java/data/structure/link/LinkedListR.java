package data.structure.link;

import javafx.util.Pair;

/**
 * Created by think on 2019/10/18.
 */
public class LinkedListR<E> {
    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
           this(null,null);
        }

        public Node(E e) {
            this(e,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR(){
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
       head = add(head,index,e);
       size ++;
    }

    private Node add(Node node, int index, E e) {
        if (index == 0)
            return new Node(e,node);
        node.next = add(node.next,index-1,e);
        return node;
    }

    public void set(int index ,E e){
        set(head,index,e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0){
            node.e = e;
            return;
        }
        set(node.next,index - 1,e);
    }

    public E get(int index){
        return get(head,index);
    }

    private E get(Node node, int index) {
        if (index == 0)
            return node.e;
        return get(node.next,index-1);
    }

    public boolean contains(E e){
        return contains(head,e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (node.e.equals(e))
            return true;
        return contains(node.next,e);

    }

    public E remove(int index){
        Pair<Node,E> remove = remove(head, index);
        size --;
        return remove.getValue();
    }

    // 从链表中删除元素e
    public void removeElement(E e){

        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null)
            return null;
        if (node.e.equals(e)){
            size --;
            return node.next;
        }

        node.next = removeElement(node.next,e);
        return node;
    }

    private Pair<Node,E> remove(Node node, int index) {
        if (index == 0)
            return new Pair(node.next,node.e);
        Pair<Node,E> res = remove(node.next,index-1);
        node.next = res.getKey();
        return new Pair<>(node,res.getValue());

    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size - 1);
    }







    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node cur = head;
        while (cur != null){
           str.append(cur).append("->");
           cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size);
    }

    public void addLast(E e){
        add(size,e);
    }

    public static void main(String[] args) {

        LinkedListR<Integer> list = new LinkedListR<>();
        for(int i = 0 ; i < 10 ; i ++)
            list.addFirst(i);
        System.out.println(list);
        for(int i = 9 ; i >=0 ; i --)
            list.set(i,i);
        System.out.println(list);
        while(!list.isEmpty())
            System.out.println("removed " + list.removeLast());
    }
}
