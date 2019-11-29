package com.nicolas.common.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-11-29 10:06
 */
public class BinaryTree <E extends Comparable> {
    private   class Node{
        Node left;
        Node right;
        E e;
        public  Node(E e){
            this.e = e;
            this.left = right;
        }
    }

    private Node root;
    private int size = 0;
    public BinaryTree(){
        root = null;
    }

    public   Node add(Node node,E e){
        if(node == null) {
            size ++ ;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
           node.left = add(node.left,e);
        }
        if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return  node;
    }

    public Node minNode(Node node){
        if(node.left == null){
            return node;
        }
        node = minNode(node.left);
        return node;
    }

    public Node maxNode(Node node){
        if(node.right == null){
            return node;
        }
        return maxNode(node.right);

    }


    public Node removeNode(Node node,E e){

        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = removeNode(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = removeNode(node.right,e);
            return node;
        }else {
            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            }

            if(node.right == null){
                Node left = node.left;
                node.right = null;
                size --;
                return left;
            }

            Node successor = minNode(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;

        }

    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node right = node.right;
            node.right = null;
            size --;

            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println("node = [" + node.e + "]");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void levelOrder(){

        Queue<Node> queue = new LinkedList<>();
        queue.add( root);
        while (!queue.isEmpty()){
            Node cur  = queue.remove();
            System.out.println("node = [" + cur.e + "]");
            if(cur.left != null){
                queue.add(cur.left);

            }

            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

}
