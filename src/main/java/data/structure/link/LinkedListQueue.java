package data.structure.link;

import imooc.demo.Queue;

/**
 * Created by think on 2019/10/22.
 */
public class LinkedListQueue<E> implements Queue<E>{
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



    private Node head,tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e){
        Node node = new Node(e);
        if (tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size ++;
    }

    public E dequeue(){
        if (head == null)
            return null;
        Node retNode = head;
        head = retNode.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("front ");
        Node cur = head;
        while (cur != null){
            str.append(cur).append("->");
            cur = cur.next;
        }
        str.append("NULL tail");
        return str.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
