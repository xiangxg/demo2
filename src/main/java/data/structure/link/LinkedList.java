package data.structure.link;

/**
 * Created by think on 2019/10/18.
 */
public class LinkedList<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead =  new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if (index < 0 || index > size)
            return;
        Node pre = dummyHead;
        for (int i = 0;i < index;i ++){
            pre = pre.next;
        }
        /**
         * Node node = new Node(e);
         node.next = pre.next;
         pre.next = node;
         */
        pre.next = new Node(e,pre.next);
        size ++;
    }

    public void set(int index ,E e){
        if (index < 0 || index > size)
            return;
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public E get(int index){
        if (index < 0 || index > size)
            return null;
        Node cur = dummyHead.next;
        for (int i = 0;i<index;i++)
            cur = cur.next;
        return cur.e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            cur = cur.next;
            if (cur.e.equals(e))
                return true;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index > size)
            return null;
        Node pre = dummyHead;
        for (int i=0 ;i<index;i++){
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
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
        Node cur = dummyHead.next;
        while (cur != null){
           str.append(cur).append("->");
           cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
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
}
