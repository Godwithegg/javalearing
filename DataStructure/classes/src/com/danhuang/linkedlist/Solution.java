package com.danhuang.linkedlist;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.LastRemaining_Solution(5, 3));
    }
    public int LastRemaining_Solution(int n, int m) {
        Circle circle = new Circle();
        circle.createCir(n);
        int num = circle.get(m);
        return num;
    }
    class Circle{
        Node first = new Node(-1);
        Node cnr = null;
        public void createCir(int num){
            for(int i=0;i<num;i++){
                Node newNode = new Node(i);
                if(i==0){
                    first =  newNode;
                    first.next = first;
                    cnr = first;
                }else{
                    cnr.next = newNode;
                    newNode.next = first;
                    cnr = newNode;
                }
            }
        }
        public int get(int m){
            Node helper = first;
            while(helper.next != first){
                helper = helper.next;
            }
            while(true){
                if(first == helper){
                    break;
                }
                for(int i=0;i<m-1;i++){
                    helper = helper.next;
                    first = first.next;
                }
                first = first.next;
                helper.next = first;
            }
            return first.num;
        }

    }
    class Node{
        public Node(int num){
            this.num = num;
        }
        int num;
        Node next;
    }
}