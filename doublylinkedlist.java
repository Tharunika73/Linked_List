//Doubly Linked List

package linkedlist;
import java.util.*;
class Node1{
    int data;
    Node1 next;
    Node1 prev;
    public Node1(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyLinkedList {
    Node1 head;
    public void insert(int x) {
        Node1 newnode = new Node1(x);
        newnode.next = head;
        if (head != null) {
            head.prev = newnode;
        }
        head = newnode;
    }
    public void insertpos(int p, int x) {
        Node1 newnode = new Node1(x);
        if (p < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (p == 0) {
            insert(x); 
            return;
        }

        Node1 temp = head;
        int c = 0;
        while (temp != null && c < p - 1) {
            temp = temp.next;
            c++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newnode.next = temp.next;
        newnode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newnode;
        }

        temp.next = newnode;
    }
    public void del(int p) {
        if (p < 0 || head == null) {
            System.out.println("Invalid or empty list");
            return;
        }

        if (p == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node1 temp = head;
        int c = 0;
        while (temp != null && c < p) {
            temp = temp.next;
            c++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }
    public void display() {
        Node1 temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void sort() {
        if (head == null) return;

        Node1 temp = head;
        while (temp != null) {
            Node1 a = temp.next;
            while (a != null) {
                if (temp.data > a.data) {
                    int x = temp.data;
                    temp.data = a.data;
                    a.data = x;
                }
                a = a.next;
            }
            temp = temp.next;
        }
        System.out.println("List sorted.");
    }
    public void reverse() {
    	Node1  temp=head;
    	while(temp.next!=null) {
    		temp = temp.next;
    	}
    	while(temp!=null) {
    		System.out.println(temp.data);
    		temp=temp.prev;
    	}
    }
    public static void main(String[] args) {
        DoublyLinkedList ob = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
			System.out.println("\n1.insert\n2.Display\n3.delete\n4.Sort\n5.InsertPosition\n6.reverse\n7.Exit");
			int a=sc.nextInt();
			switch (a) {
			case 1:
				System.out.println("Enter element: ");
				int x=sc.nextInt();
				ob.insert(x);
				break;
			case 2:
				ob.display();
				break;
			case 3:
				System.out.println("Enter position: ");
				int p = sc.nextInt();
				ob.del(p);
				break;
			case 4:
				ob.sort();
				break;
			case 5:
				System.out.println("Enter element: ");
				x=sc.nextInt();
				System.out.println("Enter position: ");
				 p = sc.nextInt();
				ob.insertpos(p, x);
				break;
			case 6:
				ob.reverse();
				break ;
			case 7:
				System.out.println("Exiting");
				return ;
			}
		}
    }
}

