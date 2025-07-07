package linkedlist;
import java.util.*;

class Node3 {
    int data;
    Node3 next;
    Node3 prev;

    public Node3(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

public class CircularLinkdLIst {
    Node3 head;

    public void insert(int x) {
        Node3 newnode = new Node3(x);
        if (head == null) {w
            head = newnode;
            head.next = head;
            head.prev = head;
        } else {
            Node3 tail = head.prev;

            newnode.next = head;
            newnode.prev = tail;
            head.prev = newnode;
            tail.next = newnode;

            head = newnode;
        }
    }

    public void insertpos(int p, int x) {
        if (p < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (p == 0) {
            insert(x);
            return;
        }

        Node3 newnode = new Node3(x);
        Node3 temp = head;
        int c = 0;

        while (temp.next != head && c < p - 1) {
            temp = temp.next;
            c++;
        }

        if (c != p - 1) {
            System.out.println("Position out of range");
            return;
        }

        newnode.next = temp.next;
        newnode.prev = temp;
        temp.next.prev = newnode;
        temp.next = newnode;
    }

    public void del(int p) {
        if (head == null || p < 0) {
            System.out.println("Invalid or empty list");
            return;
        }

        if (p == 0) {
            if (head.next == head) {
                head = null;
            } else {
                Node3 tail = head.prev;
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            return;
        }

        Node3 temp = head;
        int c = 0;

        while (temp.next != head && c < p) {
            temp = temp.next;
            c++;
        }

        if (c != p) {
            System.out.println("Position out of range");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node3 temp = head;
        System.out.print("List: ");
        boolean first = true;
        while (temp != head || first) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
            first = false;
        }
        System.out.println("(back to head)");
    }

    public void sort() {
        if (head == null) return;

        Node3 temp = head;
        boolean firstOuter = true;
        while (temp != head || firstOuter) {
            Node3 a = temp.next;
            boolean firstInner = true;
            while (a != head || firstInner) {
                if (temp.data > a.data) {
                    int x = temp.data;
                    temp.data = a.data;
                    a.data = x;
                }
                a = a.next;
                firstInner = false;
            }
            temp = temp.next;
            firstOuter = false;
        }
        System.out.println("List sorted.");
    }

    public void reverse() {
        if (head == null) return;

        Node3 temp = head.prev;
        System.out.print("Reversed List: ");
        boolean first = true;
        while (temp != head.prev || first) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
            first = false;
        }
        System.out.println("(back to tail)");
    }

    public static void main(String[] args) {
        CircularLinkdLIst ob = new CircularLinkdLIst();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Insert\n2.Display\n3.Delete\n4.Sort\n5.Insert at Position\n6.Reverse\n7.Exit");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter element: ");
                    int x = sc.nextInt();
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
                    x = sc.nextInt();
                    System.out.println("Enter position: ");
                    p = sc.nextInt();
                    ob.insertpos(p, x);
                    break;
                case 6:
                    ob.reverse();
                    break;
                case 7:
                    System.out.println("Exiting");
                    return;
            }
        }
    }
}
