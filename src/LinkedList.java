/**
 This is where I will post all my solutions to the interview questions
 about Linked Lists from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/


import sun.awt.image.ImageWatched;

import java.util.ArrayList;

public class LinkedList
{
    private LinkedList next = null;
    private int data;

    //Basic constructor which initializes a new array with the data d.
    public LinkedList(int d)
    {
        this.data = d;
    }

    //Basic Append function for adding a node to the end of the list.
    public void Append(int d)
    {
        LinkedList tail = new LinkedList(d);
        LinkedList tracker = this;
        while(tracker.next != null)
        {
            tracker = tracker.next;
        }
        tracker.next = tail;
    }

    //Basic delete function for deleting a node with the value d.
    public static LinkedList DeleteNode(LinkedList head, int d)
    {
        LinkedList tracker = head;

        if(head.data == d)
            return head.next;
        else
        {
            while(tracker.next != null)
            {
                if (tracker.next.data == d)
                {
                    tracker.next = tracker.next.next;
                    return head;
                }
                tracker = tracker.next;
            }
            return head;
        }
    }

    //Basic function to return the length of the head
    public static int GetLength(LinkedList head)
    {
        int index = 1;
        LinkedList tracker = head;

        while(tracker.next != null )
        {
            index++;
            tracker = tracker.next;
        }

        return index;
    }

    //Basic function to print out the Linked List
    public static void PrintLinkedList(LinkedList head)
    {
        LinkedList tracker = head;

        System.out.println();

        for (int i = 0; i < GetLength(head) ;i++, tracker = tracker.next)
        {
            System.out.print(tracker.data);
            if (tracker.next != null)
            {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }

    /*
        Problem
            2.1

        Description
            Remove duplicates from an unsorted linked list. Will remove the first occurrence of the value/

        Variables
            length : An int with the initial length of the linked list.
            tracker : To keep track of which node we are in the linked list.
            dupTracker : An ArrayList of ints which keeps track of what numbers we've seen so far.

     */
     public static LinkedList RemoveDuplicates(LinkedList head)
     {
         int length = GetLength(head);
         LinkedList tracker = head;
         ArrayList<Integer> dupTracker = new ArrayList<>();

         for (int i = 0; i < length ;i++, tracker = tracker.next)
         {
               if(dupTracker.contains(tracker.data))
                   head = DeleteNode(head, tracker.data);
               else
                   dupTracker.add(tracker.data);
         }

         return head;
     }

     /*
        Problem
            2.2

        Description
            A method to return the Kth to last element of the Linked List.
            Checks to see if K is in bounds, else it returns a -1

        Variables
            tracker : A Linked List to keep iterate the Linked List

      */
     public static int KthToLast(LinkedList head, int k)
     {
         LinkedList tracker = head;
         if (k > GetLength(head) || k < 1)
             return -1;
         else
             for (int i = 0; i < (GetLength(head) - k) ;i++, tracker = tracker.next)
             {
                 if (i == (GetLength(head)  - k))
                     return tracker.data;
             }
         return -1;
     }
}

