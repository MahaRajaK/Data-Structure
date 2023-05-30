import java.util.Scanner;

class Node{
    int value;
    Node next;
    Node prev;
    Node(int value){
        this.value = value;
    }
}

public class doublelist {
    private Node head;
    private Node tail;
    private int length;
    public doublelist(int value){
        Node newnode = new Node(value);
        head = newnode;
        tail = newnode;
        length = 1;
    }
    public doublelist(){
        head = null;
        tail = null;
        length = 0;
    }

    public void printlist(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newnode = new Node(value);
        if(head == null){
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.prev = tail;
            tail.next = newnode;
            tail = newnode;
        }
        length++;
    }

    public Node removelast(){
        if(length == 0) return null;
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
             
        }
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newnode = new Node(value);
        if(length == 0){
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = head.prev;
        }
        length++;
    }

    public Node removefirst(){
        if(length == 0) return null;
        Node temp  = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            temp.next = null;
            head.prev= null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
            for(int i=0; i < index; i++){
                temp = temp.next;
            }
        }
        else if(index >= length/2){
            temp = tail;
            for(int i=length - 1;i>index;i--){
                temp=temp.prev;
            }
        }
        return temp;   

    }

    public boolean set(int index,int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insert(int index , int value){
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
        Node before = get(index-1);
        Node after = before.next;
        before.next = newnode;
        newnode.prev = before;
        newnode.next = after;
        after.prev = newnode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) removefirst();
        if(index == length-1) return removelast();

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void getlength(){
        System.out.print("length: "+ length);
    }
    public static void main(String[] args) {
        doublelist mydoublelist = new doublelist();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            mydoublelist.append(sc.nextInt());
        }
        sc.close();
        // System.out.println(mydoublelist.removelast().value);
        // mydoublelist.prepend(5);
        System.out.println(mydoublelist.removefirst().value);
        // System.out.println(mydoublelist.get(1).value);
        // System.out.println(mydoublelist.get(3).value);   
        // mydoublelist.set(1,666);    
        // mydoublelist.insert(5,666); 
        // System.out.println(mydoublelist.remove(3).value);
        mydoublelist.printlist();
        // mydoublelist.getlength();
    }
}
