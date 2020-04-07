package com.learn.dsa.LearnDSA.linkedlist;

//A simple Java program to introduce a linked list 
class LinkedList { 
	
 Node head; // head of list 

 /* Linked list Node.  This inner class is made static so that main() can access it */
 static class Node { 
     int data; 
     Node next; 
     Node(int d) 
     { 
         data = d; 
         next = null; 
     } // Constructor 
 } 
 
 /* This function prints contents of linked list starting from head */
 public void printList()  { 
     Node n = head; 
     while (n != null) { 
         System.out.print(n.data + " "); 
         n = n.next; 
     } 
 } 
 
 /* Inserts a new Node at front of the list. */
 public void push(int new_data) { 
     /* 1 & 2: Allocate the Node & Put in the data*/
     Node new_node = new Node(new_data); 
     /* 3. Make next of new Node as head */
     new_node.next = head; 
     /* 4. Move the head to point to new Node */
     head = new_node; 
 } 

 /* Inserts a new node after the given prev_node. */
 public void insertAfter(Node prev_node, int new_data)  { 
     /* 1. Check if the given Node is null */
     if (prev_node == null) 
     { 
         System.out.println("The given previous node cannot be null"); 
         return; 
     } 
     /* 2 & 3: Allocate the Node & Put in the data*/
     Node new_node = new Node(new_data); 
     /* 4. Make next of new Node as next of prev_node */
     new_node.next = prev_node.next;
     /* 5. make next of prev_node as new_node */
     prev_node.next = new_node; 
 } 
  
 /* Appends a new node at the end.  This method is  defined inside LinkedList class shown above */
 public void append(int new_data) { 
     /* 1. Allocate the Node & 
        2. Put in the data 
        3. Set next as null */
     Node new_node = new Node(new_data); 
     /* 4. If the Linked List is empty, then make the new node as head */
     if (head == null) 
     { 
         head = new Node(new_data); 
         return; 
     } 
     /* 4. This new node is going to be the last node, so make next of it as null */
     new_node.next = null; 
     /* 5. Else traverse till the last node */
     Node last = head;  
     while (last.next != null) 
         last = last.next; 
     /* 6. Change the next of last node */
     last.next = new_node; 
     return; 
 } 

 /* Given a key, deletes the first occurrence of key in linked list */
 void deleteNodeKey(int key) { 
     // Store head node 
     Node temp = head, prev = null; 
     // If head node itself holds the key to be deleted 
     if (temp != null && temp.data == key) 
     { 
         head = temp.next; // Changed head 
         return; 
     } 
     // Search for the key to be deleted, keep track of the previous node as we need to change temp.next 
     while (temp != null && temp.data != key) 
     { 
         prev = temp; 
         temp = temp.next; 
     }     
     // If key was not present in linked list 
     if (temp == null) return; 
     // Unlink the node from linked list 
     prev.next = temp.next; 
 }
 
 /* Given a reference (pointer to pointer) to the head of a list 
 and a position, deletes the node at the given position */
void deleteNodePosition(int position) 
{ 
  // If linked list is empty 
  if (head == null) 
      return; 

  // Store head node 
  Node temp = head; 

  // If head needs to be removed 
  if (position == 0) 
  { 
      head = temp.next;   // Change head 
      return; 
  } 

  // Find previous node of the node to be deleted 
  for (int i=0; temp!=null && i<position-1; i++) 
      temp = temp.next; 

  // If position is more than number of ndoes 
  if (temp == null || temp.next == null) 
      return; 

  // Node temp->next is the node to be deleted 
  // Store pointer to the next of node to be deleted 
  Node next = temp.next.next; 

  temp.next = next;  // Unlink the deleted node from list 
}

 /* method to create a simple linked list with 3 nodes*/
 public static void main(String[] args) 
 { 
     /* Start with the empty list. */
     LinkedList llist = new LinkedList(); 

     llist.head = new Node(1); 
     Node second = new Node(2); 
     Node third = new Node(3); 

     /* Three nodes have been allocated dynamically. 
       We have references to these three blocks as head,   
       second and third 

       llist.head        second              third 
          |                |                  | 
          |                |                  | 
      +----+------+     +----+------+     +----+------+ 
      | 1  | null |     | 2  | null |     |  3 | null | 
      +----+------+     +----+------+     +----+------+ */

     llist.head.next = second; // Link first node with the second node 

     /*  Now next of the first Node refers to the second.  So they 
         both are linked. 

      llist.head        second              third 
         |                |                  | 
         |                |                  | 
     +----+------+     +----+------+     +----+------+ 
     | 1  |  o-------->| 2  | null |     |  3 | null | 
     +----+------+     +----+------+     +----+------+ */

     second.next = third; // Link second node with the third node 

     /*  Now next of the second Node refers to third.  So all three 
         nodes are linked. 

      llist.head        second              third 
         |                |                  | 
         |                |                  | 
     +----+------+     +----+------+     +----+------+ 
     | 1  |  o-------->| 2  |  o-------->|  3 | null | 
     +----+------+     +----+------+     +----+------+ */
     
     llist.printList(); 
     
     
     // Insert 6.  So linked list becomes 6->NUllist 
     llist.append(6); 

     // Insert 7 at the beginning. So linked list becomes 7->6->NUllist 
     llist.push(7); 

     // Insert 1 at the beginning. So linked list becomes 1->7->6->NUllist 
     llist.push(1);
     // Insert 4 at the end. So linked list becomes 1->7->6->4->NUllist 
     llist.append(4); 
     // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NUllist 
     llist.insertAfter(llist.head.next, 8); 
     System.out.println("\nCreated Linked list is: "); 
     llist.printList(); 
     
     llist.deleteNodeKey(1); // Deletes first node with data=1      
     System.out.println("\nLinked list after deleting first node with data=1: "); 
     llist.printList(); 
     
     llist.deleteNodePosition(4);  // Delete node at position 4      
     System.out.println("\nLinked List after Deletion at position 4: "); 
     llist.printList();
 } 
}