package stacks;

import java.util.LinkedList;

public class StackImplementationUsingLL {

     static class Node{
        int data;
        Node next;

        Node(int x){
            this.data=x;
            next=null;
        }

    }

     static class LinkedList{

        Node head;
        Node curr;

        LinkedList(){
            head=null;
            curr=null;
        }

        public void push(int x){

            if(head==null){
                head = new Node(x);
                curr=head;
            }
            else {
                curr.next = new Node(x);
                curr=curr.next;
            }
        }

        public void pop() {
            Node temp = head;
            if (head == null) {
                System.out.println("Stack empty");
                return;
            }
            while (temp.next != curr) {
                temp = temp.next;
            }
            temp.next = null;
            curr=temp;

        }

        public void display(){
            Node temp= head;
            System.out.println();
            while(temp!=null) {
                System.out.print(temp.data + "-> ");
                temp = temp.next;
            }
        }

        public int peek(){
            System.out.println("Peek element is "+curr.data);
            return curr.data;
        }

    }


//    LinkedList<Node> ll = new LinkedList<Node>();

     static LinkedList ll = new LinkedList();
    public static void main(String [] args){

        ll.push(5);
        ll.push(10);
        ll.push(15);
        ll.pop();
        ll.push(20);
        ll.display();
        ll.peek();

    }
}
