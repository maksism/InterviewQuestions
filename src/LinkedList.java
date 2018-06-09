/**
 This is where I will post all my solutions to the interview questions
 about Linked Lists from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/


import java.util.Random;

public class LinkedList
{
    private LinkedList next = null;
    private int data;
    private boolean declared;
    private boolean seen;

    public LinkedList(){}

    //Basic constructor which initializes a new array with the data d.
    public LinkedList(int d)
    {
        this.declared = true;
        this.data = d;
    }

    //Basic Append function for adding a node to the end of the list.
    public void Append(int d)
    {
        if (!this.declared)
        {
            this.declared = true;
            this.data = d;
        }
        else
        {
            LinkedList tail = new LinkedList(d);
            LinkedList tracker = this;
            while (tracker.next != null)
            {
                tracker = tracker.next;
            }
            tracker.next = tail;
        }
    }

    //Basic Append function for adding two lists together.
    public void Append(LinkedList list) {
        LinkedList tracker1 = this;

        while (tracker1.next != null)
            tracker1 = tracker1.next;

        tracker1.next = list;
    }

    //
    public static LinkedList AddToFront(LinkedList head, int d)
    {
        LinkedList newHead = new LinkedList(d);
        if (!head.declared)
        {
            head.data = d;
            head.declared = true;
            return head;
        }
        else
            newHead.next = head;

        return newHead;
    }

    //Basic delete function for deleting a node with the value d.
    public LinkedList DeleteNode(int d)
    {
        LinkedList tracker = this;

        if(this.data == d)
            return this.next;
        else
        {
            while(tracker.next != null)
            {
                if (tracker.next.data == d)
                {
                    tracker.next = tracker.next.next;
                    return this;
                }
                tracker = tracker.next;
            }
            return this;
        }
    }

    //Basic method that checks if the Linked List contains the value d;
    public boolean Contains(int d) {
        boolean contains = false;
        LinkedList tracker = this;

        if (this.declared)
        {
            for (int i = 0; i < GetLength(this); i++, tracker = tracker.next) {
                if (tracker.data == d)
                    contains = true;
            }
        }
        return contains;
    }

    //A basic method for returning data
    public int GetData()
    {
        if (this == null)
            return -1;
        else
            return data;
    }

    //Basic method to to generate a Random Linked List with of size x with an upper bound of y
    public void GenerateRandomList(int size, int bound)
    {
        for (int i = 0; i < size; i++)
            this.Append(new Random().nextInt(bound));
    }

    //Basic method to return the length of the head
    public int GetLength()
    {
        int index = 1;
        LinkedList tracker = this;

        if (this == null)
            return 0;
        while(tracker.next != null )
        {
            index++;
            tracker = tracker.next;
        }

        return index;
    }

    //Basic method to return the length of the head
    public int GetLength(LinkedList head)
    {
        int index = 1;
        LinkedList tracker = head;

        if (head == null)
            return 0;
        while(tracker.next != null )
        {
            index++;
            tracker = tracker.next;
        }

        return index;
    }

    //Basic function to print out the Linked List
    public void PrintLinkedList()
    {
        LinkedList tracker = this;

        System.out.println();

        for (int i = 0; i < GetLength(this) ;i++, tracker = tracker.next)
        {
            System.out.print(tracker.data);
            if (tracker.next != null)
            {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }

    //Basic method for returning a Linked List from the Nth node
    public LinkedList ReturnNodeN(int n)
    {
        LinkedList tracker = this;
        for (int i = 0; i < n-1; i++, tracker = tracker.next);
        return tracker;
    }

    /*
        Problem
            2.1
        Description
            Remove duplicates from an unsorted linked list. Will remove the first occurrence of the value/
        Variables
            length : An int with the initial length of the linked list.
            tracker : To keep track of which node we are in the linked list.
            dataTracker : A Linked List which keeps track of what numbers we've seen so far.
     */
     public static LinkedList RemoveDuplicates(LinkedList list)
     {
         int length = list.GetLength();
         LinkedList tracker = list;
         LinkedList dataTracker = new LinkedList();

         for (int i = 0; i < length ;i++, tracker = tracker.next)
         {
               if(dataTracker.Contains(tracker.data))
                   list = list.DeleteNode(tracker.data);
               else
                   dataTracker.Append(tracker.data);
         }
         dataTracker.PrintLinkedList();

         return list;
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
         if (k > head.GetLength() || k < 1)
             return -1;
         else
             for (int i = 0; i < (head.GetLength() - k) ;i++, tracker = tracker.next) {}
         return tracker.data;
     }

     /*
        Problem
            2.3
        Description
            A method for deleting a middle node only having access to it.
            Assume that the node is not a head or a tail.
            Had to make a new method to return a Linked List from a certain position.
     */
     public static void DeleteMiddleNode(LinkedList node)
     {
         node.data = node.next.data;
         node.next = node.next.next;
     }

    /*
        Problem
            2.4
        Description
            A method to partition a Linked List around a value x.
            Splits the Linked List into two lists where one is lower than x and the other is equal to or greater.
            Then Appends the two lists together.
        Variables
            tracker : A LinkedList used to keep track of the list we are partitioning
            partition : A LinkedList used to store values lower than x and then gets appended with the highs.
            partitionHigh : A LinkedList used to store values higher or equal to x.
     */
    public static LinkedList Partition(LinkedList head, int x)
    {
        LinkedList tracker = head;
        LinkedList partition = new LinkedList();
        LinkedList partitionHigh = new LinkedList();

        for (int i = 0; i < head.GetLength(); i++, tracker = tracker.next)
        {
            if (tracker.data < x)
            {
                partition.Append(tracker.data);
            }
            else
            {
                partitionHigh.Append(tracker.data);
            }
        }
        partition.Append(partitionHigh);

        return partition;
    }

    /*
        Problem
            2.5a
        Description
            A method which takes the data from two Linked Lists and converts them into a number
            and then adds them together and returns the sum as a linked list.
            Numbers stored backwards.
        Variable
            num1 : An int where we store the value from list1.
            num2 : An int where we store the value from list2.
            sum : An int where we store the result of num1 + num2.
            tracker1 : A Linked List used to keep track of where we are in list1.
            tracker2 : A Linked List used to keep track of where we are in list2.
    */
    public static LinkedList SumListBackwards(LinkedList list1, LinkedList list2)
    {
        int num1 = 0, num2 = 0, sum;

        LinkedList sumList = new LinkedList();
        LinkedList tracker1 = list1;
        LinkedList tracker2 = list2;

        for (int i = 0, pos = 1; i < list1.GetLength(); i++,pos=pos*10, tracker1 = tracker1.next)
        {
            num1 = num1 + (tracker1.data * pos);
        }
        for (int i = 0, pos = 1; i < list2.GetLength(); i++,pos=pos*10, tracker2 = tracker2.next)
        {
            num1 = num1 + (tracker2.data * pos);
        }

        sum = num1 + num2;

        while (sum != 0)
        {
            sumList.Append(sum % 10);
            sum = sum / 10;
        }

        return sumList;
    }

    /*
    Problem
        2.5b
    Description
        A method which takes the data from two Linked Lists and converts them into a number
        and then adds them together and returns the sum as a linked list.
        Numbers stored forwards.
    Variable
        num1 : An int where we store the value from list1.
        num2 : An int where we store the value from list2.
        sum : An int where we store the result of num1 + num2.
        tracker1 : A Linked List used to keep track of where we are in list1.
        tracker2 : A Linked List used to keep track of where we are in list2.

*/
    public static LinkedList SumListForwards(LinkedList list1, LinkedList list2)
    {
        int num1 = 0, num2 = 0, sum;

        LinkedList sumList = new LinkedList();
        LinkedList tracker1 = list1;
        LinkedList tracker2 = list2;

        for (int i = 0; i < list1.GetLength(); i++, tracker1 = tracker1.next)
        {
            num1 = num1 * 10 + tracker1.data ;
        }
        for (int i = 0; i < list2.GetLength(); i++, tracker2 = tracker2.next)
        {
            num2 = num2 * 10 + tracker2.data;
        }

        sum = num1 + num2;

        while (sum != 0)
        {
            sumList = AddToFront(sumList,sum % 10);
            sum = sum / 10;
        }

        return sumList;
    }

    /*
        Problem
            2.6
        Description
            A Method which will determine if a linked List makes a palindrome
            Works by first reversing the list using the AddToFront method.
        Variables
            isPalindrome : A boolean which tells us if the list is a palindrome.
            tracker : A Linked List used to keep track of where we are in the list.
            reversedList: A Linked List that we use to reverse the initial list.
    */
    public static boolean IsPalindrome(LinkedList head)
    {
        boolean isPalindrome = true;

        LinkedList tracker = head;
        LinkedList reversedList = new LinkedList();

        for (int i = 0; i < head.GetLength(); i++, tracker = tracker.next)
        {
             reversedList = AddToFront(reversedList, tracker.data);
        }

        tracker = head;

        for (int i = 0; i < head.GetLength(); i++, tracker = tracker.next, reversedList = reversedList.next)
        {
            if (tracker.data != reversedList.data)
                isPalindrome = false;
        }

        return isPalindrome;
    }

    /*
        Problem
            2.7
        Description
            A method which will take two Linked Lists and determines if there is any intersection(the same exact node)
            within the two lists.
            Using the seen boolean makes it very easy.
        Variables
            intersect : A boolean used to keep track if we have an intersection
            tracker1 : A Linked List used to keep track of list1.
            tracker2 : A Linked List used to keep track of list2.
    */
    public static boolean IsIntersection(LinkedList list1, LinkedList list2)
    {
        boolean intersect = false;
        LinkedList tracker1 = list1;
        LinkedList tracker2 = list2;

        for (int i = 0; i < list1.GetLength(); i++, tracker1 = tracker1.next)
            tracker1.seen = true;
        for (int i = 0; i < list2.GetLength(); i++, tracker2 = tracker2.next)
        {
            if (tracker2.seen)
                intersect = true;
            else
                tracker2.seen = true;
        }
        tracker1 = list1;
        tracker2 = list2;

        for (int i = 0; i < list1.GetLength(); i++, tracker1 = tracker1.next)
            tracker1.seen = false;
        for (int i = 0; i < list2.GetLength(); i++, tracker2 = tracker2.next)
            tracker2.seen = false;

        return intersect;
    }

    /*
        Problem
            2.8
        Description
            A method which will detect loops within a LinkedList
            Implemented by adding a new boolean to the LinkedList class.
            Will update the value if that node was seen before and stop there.
            If we do not see the same node twice, then we will reset this value.
            Had to make a method that will create a circular LinkedList around a random node.
        Variables
            tracker : A Linked List used to keep track of where we are.
            loopDetection : A Boolean which tells us if we seen a same node twice.
    */
    public static void LoopDetection(LinkedList head)
    {
        LinkedList tracker = head;
        boolean loopDetected = false;

        while (!loopDetected && tracker.next != null)
        {
            if (!tracker.seen)
            {
                tracker.seen = true;
                tracker = tracker.next;
            }
            else
            {
                loopDetected = true;
            }
        }

        if (!loopDetected)
        {
            tracker = head;
            for (int i = 0; i < head.GetLength(); i++, tracker = tracker.next)
                tracker.seen = false;
            System.out.println("No loop is detected.");
        }
        else
        {
            System.out.println("A Loops is detected that starts with: " + tracker.data);
        }
    }

    //Method used to create a circular Linked List around a random node in order to test LoopDetection.
    public static void CreateCircularList(LinkedList head)
    {
        LinkedList tracker = head;
        LinkedList startCircle = new LinkedList();

        Random randomPos = new Random();
        int pos = randomPos.nextInt(head.GetLength());

        for (int i = 0; i < head.GetLength(); i++)
        {
            if (i == pos)
                startCircle = tracker;
            if (i != head.GetLength() - 1)
                tracker = tracker.next;
        }

        tracker.next = startCircle;

        System.out.println("Created a Circular Linked List around position: " + (pos+1) + " and value: " + startCircle.data);
    }
}

