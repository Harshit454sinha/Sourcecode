class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    // Function to split the linked list into two halves
    Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Function to merge two sorted linked lists
    Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.data < right.data) {
            left.next = merge(left.next, right);
            left.next = left;
            return left;
        } else {
            right.next = merge(left, right.next);
            right.next = right;
            return right;
        }
    }
    
    // Main function to sort a linked list using merge sort
    Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        
        middle.next = null;
        
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        
        Node sortedList = merge(left, right);
        return sortedList;
    }
    
    // Utility function to print the linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(4);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(1);
        
        System.out.println("Original list:");
        list.printList(list.head);
        
        list.head = list.mergeSort(list.head);
        
        System.out.println("Sorted list:");
        list.printList(list.head);
    }
}
