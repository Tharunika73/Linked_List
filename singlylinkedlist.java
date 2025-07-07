//singly Linked List:
package linkedlist;
//import java.util.*;
//class Node{
//	int data;
//	Node next; //reference datatype
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}
//public class LinkedListStart1 {
//	Node head;
//	public void insert(int x) {
//		Node newnode = new Node(x);
//		newnode.next=head;
//		head=newnode;
//	}
//	public void insertpos(int p,int x) {
//		Node newnode = new Node(x);
//		if(p<0) {
//			System.out.println("Invalid position");
//		}
//		if(p==0) {
//			newnode.next=head;
//			head=newnode;
//		}
//		Node temp=head;
//		int c=0;
//		while(temp!=null && c<p-1) {
//			temp=temp.next;
//			c++;
//		}
//		newnode.next=temp.next;
//		temp.next=newnode;
//		
//	}
//	public void del(int p) {
//		if(p<0) {
//			System.out.println("Invalid");
//		}
//		if(p==0) {
//			head=head.next;
//		}
//		int c=0;
//		Node temp=head;
//		while(temp!=null && c<p-1) {
//			temp=temp.next;
//			c++;
//		}
//		temp.next=temp.next.next;
//	}
//	public void search(int x){
//        Node temp=head;
//        while(temp!=null)
//        {
//            if(temp.data==x)
//            {
//                System.out.print("data found");
//                return;
//            }
//            temp=temp.next;}
//            System.out.print("data not found");
//    }
//	public void display() {
//		Node temp=head;
//		while(temp!=null) {
//			System.out.println(temp.data);
//			temp=temp.next;
//		}
//	}
//	public void duplicate() {
//		Node a=head;
//		int c=0;
//		while(a!=null) {
//			c++;
//			a=a.next;
//		}
//		a=head;
//		for(int i=0;i<c;i++) {
//			if(a!=null) {
//			Node h=a.next;
//			for(int j=0;j<c;j++) {
//				if(i!=j) {
//				if(h!=null) {
//				if(a.data==h.data) {
//					if(j<c-1) {
//					del(j);
//					}
////					if(j==c-1) {
////						del(j);
////					}
//				}
//				h=h.next;
//				}
//			}
//			}
//			a=a.next;
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		LinkedListStart1 ob = new LinkedListStart1();
//		while(true) {
//			System.out.println("\n1.insert\n2.insertposition\n3.delete\n4.display\n5.Search\n6.remove Duplicate\n7.Exit");
//			int a=sc.nextInt();
//			switch (a) {
//			case 1:
//				System.out.println("Enter element: ");
//				int x=sc.nextInt();
//				ob.insert(x);
//				break;
//			case 2:
//				System.out.println("Enter element: ");
//				x=sc.nextInt();
//				System.out.println("Enter position: ");
//				int p = sc.nextInt();
//				ob.insertpos(p, x);
//				break;
//			case 3:
//				System.out.println("Enter position: ");
//				p = sc.nextInt();
//				ob.del(p);
//				break;
//			case 4:
//				ob.display();
//				break;
//			case 5:
//				System.out.println("Enter element: ");
//				x=sc.nextInt();
//				ob.search(x);
//				break;
//			case 6:
//				ob.duplicate();
//				break;
//			case 7:
//				System.out.println("Exiting");
//				return ;
//			}
//		}
//		
//	}
//
//}






//ANOTHER




// Remove package line unless you're using packages

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class LinkedListStart1 {
    Node head;

    public void insertbeg(int x) {
        Node newnode = new Node(x);
        newnode.next = head;
        head = newnode;
    }

    public void insertpos(int x, int p) {
        if (p < 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newnode = new Node(x);
        if (p == 0) {
            newnode.next = head;
            head = newnode;
            return;
        }

        Node temp = head;
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
        temp.next = newnode;
    }

    public void insertend(int x) {
        Node newnode = new Node(x);
        if (head == null) {
            head = newnode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void del(int p) {
        if (p < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (p == 0) {
            if (head != null) head = head.next;
            return;
        }

        Node temp = head;
        int c = 0;
        while (temp != null && c < p - 1) {
            temp = temp.next;
            c++;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of range");
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void search(int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                System.out.println("Data found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data not found");
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element is: " + slow.data);
    }

    public void removeDuplicates() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        System.out.println("Duplicates removed (for sorted list)");
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("List reversed");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListStart1 ob = new LinkedListStart1();
        int x, p;

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at position");
            System.out.println("6. Delete at end");
            System.out.println("7. Search element");
            System.out.println("8. Display list");
            System.out.println("9. Find middle element");
            System.out.println("10. Remove duplicates (sorted list)");
            System.out.println("11. Reverse list");
            System.out.println("12. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    ob.insertbeg(x);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    System.out.print("Enter position: ");
                    p = sc.nextInt();
                    ob.insertpos(x, p);
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    x = sc.nextInt();
                    ob.insertend(x);
                    break;
                case 4:
                    ob.deleteBeg();
                    break;
                case 5:
                    System.out.print("Enter position to delete: ");
                    p = sc.nextInt();
                    ob.del(p);
                    break;
                case 6:
                    ob.deleteEnd();
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    x = sc.nextInt();
                    ob.search(x);
                    break;
                case 8:
                    ob.display();
                    break;
                case 9:
                    ob.findMiddle();
                    break;
                case 10:
                    ob.removeDuplicates();
                    break;
                case 11:
                    ob.reverse();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

