package data.structure.bst;

import java.util.*;

/**
 * Created by think on 2019/10/30.
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        private E e;
        private Node left,right;
        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }
    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e) {
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (node.e.compareTo(e)<0)
            node.right = add(node.right,e);
        if (node.e.compareTo(e)>0)
            node.left = add(node.left,e);
        return node;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (node.e.compareTo(e) < 0)
            return contains(node.right,e);
        else if (node.e.compareTo(e) > 0)
            return contains(node.left,e);
        return true;
    }

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrederNR(){
        if (root == null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

        }
    }

    public void levelOrder(){
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        generateBstString(root,0,str);
        return str.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder str) {
        if (node == null){
            str.append(generateDepthString(depth)).append("null\n");
            return;
        }
        str.append(generateDepthString(depth)+node.e).append("\n");
        generateBstString(node.right,depth+1,str);
        generateBstString(node.left,depth+1,str);
    }

    private String generateDepthString(int depth){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }

    public E minNode(){
        if (size == 0)
            return null;
        Node node = minNode(root);
        return node.e;
    }

    private Node minNode(Node node) {
        if (node.left == null)
            return node;
        return minNode(node.left);
    }

    public E maxNode(){
        if (size == 0)
            return null;
        Node node = maxNode(root);
        return node.e;
    }

    private Node maxNode(Node node) {
        if (node.right == null)
            return node;
        return minNode(node.right);
    }

    public E removeMin(){
        E e = minNode();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E e = maxNode();
        root = removeMax(root);
        return e;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null){
                Node leftNode= node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            Node successor = minNode(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }


    }

    private Node removeMax(Node node) {
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 5;

        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10));

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");


        // test removeMax
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }
}
