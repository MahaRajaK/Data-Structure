import java.util.Scanner;

class Node{
    int value;
    Node next;
    Node(int value){
        this.value=value;
    }
    
}

public class linkedlist {
    private Node head;
    private Node tail;
    private int length;
    public linkedlist(int value){
        Node newNode=new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public linkedlist(){
        head = null;
        tail = null;
        length = 0;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value);
            temp = temp.next;
        }
    }

    public void gethead(){
        System.out.println("Head" + head.value);
    }

     public void gettail(){
        System.out.println("Tail:" + tail.value);
     }

     public void getlength(){
        System.out.println("Length:" + length);
     }

     public void append(int value){
        Node newnode= new Node(value);
        if(head == null){
            head=newnode;
            tail=newnode;
            
        }
        else{
            tail.next = newnode;
            tail = newnode;
        }
        length++;
     }

     public Node removelast(){ 
        if(length == 0) return null;
        Node temp=head;
        Node pre=head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newnode = new Node(value);
        if(head == null){
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
        length++;
    }

    public Node removefirst(){
        if(head == null)return null;
        Node temp = head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail = null;
        }
        return temp;
    }
    
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;

        }
        return temp;
    }

    public boolean set(int index,int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
     
    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newnode = new Node(value);
        Node temp = get(index-1);
        newnode.next = temp.next;
        temp.next = newnode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removefirst();
        if(index == length-1) return removelast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i=0;i<length;i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {
        linkedlist mylinkedlist = new linkedlist();
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            mylinkedlist.append(sc.nextInt());
        }
        // System.out.println(mylinkedlist.removelast().value);
        // mylinkedlist.prepend(5);
        // System.out.print(mylinkedlist.removefirst().value+" ");
        // int index=sc.nextInt();
        // System.out.println(mylinkedlist.get(index).value);
        // mylinkedlist.set(2,666);
        // mylinkedlist.insert(3,888);
        // mylinkedlist.remove(2);
        // mylinkedlist.reverse();
        mylinkedlist.printList( );
        sc.close();
        
    }
}
