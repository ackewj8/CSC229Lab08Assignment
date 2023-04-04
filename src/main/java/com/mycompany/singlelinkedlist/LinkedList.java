
package com.mycompany.singlelinkedlist;

class Node {
   public int data;
   public Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
   }
   

   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   

   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }
   
   public int counter() {
       int count = 0;
       Node n = head;
       while(n != null) {
           count++;
           n = n.next;
       }
       return count;
   }
   public static void appendThree(LinkedList aList, LinkedList bList) {
       Node y = aList.head;
       Node h = aList.tail;
       if(y.data == 3||
               (y.data % 10 == 3) ||
               (y.data % 100 > 29 && y.data % 100 < 40) ||
               (y.data % 1000 > 299 && y.data % 1000 < 400)||
               (y.data % 10000 > 2999 && y.data % 10000 < 4000)||
               (y.data % 100000 > 29999 && y.data % 100000 < 40000)||
               (y.data % 1000000 > 299999 && y.data % 1000000 < 400000)) {
          while(y != null) {
           if(y.data == 3 || // base case
                   (y.data % 10 == 3) ||
                   (y.data % 100 > 29 && y.data % 100 < 40) ||
                   (y.data % 1000 > 299 && y.data % 1000 < 400)||
                   (y.data % 10000 > 2999 && y.data % 10000 < 4000)||
                   (y.data % 100000 > 29999 && y.data % 100000 < 40000)||
                   (y.data % 1000000 > 299999 && y.data % 1000000 < 400000)) {
               bList.append(y);
           }
           y = y.next;
         }
       }
       else {
           while((h.data != 3)&&
               (h.data % 10 != 3) &&
               (h.data % 100 < 29 && h.data % 100 > 40) &&
               (h.data % 1000 < 299 && h.data % 1000 > 400)&&
               (h.data % 10000 < 2999 && h.data % 10000 > 4000)&&
               (h.data % 100000 < 29999 && h.data % 100000 > 40000)&&
               (h.data % 1000000 < 299999 && h.data % 1000000 > 400000)) {
                h = null;
           }
           while(y != null) {
           if(y.data == 3 || // base case
                   (y.data % 10 == 3) ||
                   (y.data % 100 > 29 && y.data % 100 < 40) ||
                   (y.data % 1000 > 299 && y.data % 1000 < 400)||
                   (y.data % 10000 > 2999 && y.data % 10000 < 4000)||
                   (y.data % 100000 > 29999 && y.data % 100000 < 40000)||
                   (y.data % 1000000 > 299999 && y.data % 1000000 < 400000)) {
               bList.append(y);
           }
           y = y.next;
         }
           
       }
       y = bList.head;
       Node t = bList.tail;
       if(t.next != null) {
           System.out.println("Contents of bList before trimming: ");
           while(y != null) {
               System.out.println(y.data);
               y = y.next;
           }
           t = bList.tail;
           int cut = trim(bList);
           for(int i = 0; i < cut; i++) {
               bList.removeAfter(t);
           }
           y = bList.head;
           System.out.println("Contents of bList after trimming: ");
           while(y != null) {
               System.out.println(y.data);
               y = y.next;
           }
       }
   }
   public static void Scroll(LinkedList c) {
       Node e = c.head;
       while(e != null) {
            System.out.println("Scroll: " + e.data);
            e = e.next;
       }
   }
   public static int threeList(LinkedList tList) { // provides the sum of a list's nodes
        int collective = 0;
        Node b = tList.tail;
        System.out.println("Tail: " + b.data);
        Node x = tList.head;
        while(x != null) {
            collective = collective + x.data;
            x = x.next;
        }
        //x.next = null;
        return collective;
    }
   public static int counter(LinkedList cList) {
       int counter = 0;
       Node m = cList.head;
       while(m!=null) {
           counter++;
           m = m.next;
       }
       return counter;
   }
   public static int trim(LinkedList tList) {
       int oldSize = 0;
       int newSize = 0;
       int trim;
       Node x = tList.head;
       Node y = tList.tail;
       while(x != null) {
           oldSize++;
           x = x.next;
       }
       x = tList.head;
       while(x.data <= y.data) {
           newSize++;
           x = x.next;
       }
       trim = oldSize - newSize;
       return trim;
       
   }
}
