import sun.awt.image.ImageWatched;

import java.util.Random;

/**
 This is where I will post all my solutions to the interview questions
 about Arrays and Strings from Cracking the Coding Interview

 We will assume all strings are in unicode.

 Author: Maks Kozak (Maksism)
 **/

public class MainTest
{
    public static void main(String[] args)
    {
        //TestArraysAndStrings();
        TestLinkedList();
    }

    public static void TestLinkedList()
    {
        Random randInt = new Random();
        int pos = 0;
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        //RemoveDuplicates Test
        //list1.GenerateRandomList(10,5);
        //list1.PrintLinkedList();
        //list1 = LinkedList.RemoveDuplicates(list1);
        //list1.PrintLinkedList();

        //KthFromLast Test
        //for(int i = 1; i <= list1.GetLength(); i++)
        //    System.out.println("The " + i + " th to last element: " + LinkedList.KthToLast(list1, i));

        //DeleteMiddleNode Check
        //list1.GenerateRandomList(10,50);
        //list.PrintLinkedList();
        //while (pos <= 0 || pos > LinkedList.GetLength(list1))
        //    pos = randInt.nextInt(LinkedList.GetLength(list1));
        //System.out.println("Returning node from position: " + pos);
        //list2 = LinkedList.ReturnNodeN(list1, pos);
        //list.PrintLinkedList();
        //list2.DeleteMiddleNode(list2);
        //list.PrintLinkedList();
        //list.PrintLinkedList();

        //Partition Check
        //LinkedList partitionedList = LinkedList.Partition(list1, randInt.nextInt(10));
        //list.PrintLinkedList(partitionedList);

        //SumListBackwards Check
        //list.PrintLinkedList();
        //list.PrintLinkedList();
        //LinkedList sumList = LinkedList.SumListBackwards(list1, list2);
        //list.PrintLinkedList(sumList);

        //SumListForwards Check
        //list.PrintLinkedList();
        //list.PrintLinkedList();
        //LinkedList sumList2 = LinkedList.SumListForwards(list1, list2);
        //list.PrintLinkedList(sumList2);

        //IsPalindrome Check
        //list.PrintLinkedList();
        //System.out.println("Is this list a palindrome: " + LinkedList.IsPalindrome(list1));
        
        //IsIntersection Check
        //list1.GenerateRandomList(5,50);
        //list2.GenerateRandomList(5,50);
        //list.PrintLinkedList();
        //list.PrintLinkedList();
        //System.out.println("Do the two lists intersect: " + LinkedList.IsIntersection(list1, list2));
        //list1.Append(list2);
        //list.PrintLinkedList();
        //list.PrintLinkedList();
        //System.out.println("Do the two lists intersect: " + LinkedList.IsIntersection(list1, list2));

        //LoopDetection Check
        //LinkedList circularList = new LinkedList();
        //circularList.GenerateRandomList(randInt.nextInt(10), 50);
        //list.PrintLinkedList(circularList);
        //LinkedList.LoopDetection(circularList);
        //LinkedList.CreateCircularList(circularList);
        //LinkedList.LoopDetection(circularList);
    }

    public static void TestArraysAndStrings()
    {
        String inputString = "waterbottle";
        String inputString1 = "terbottlerwa";

        int arrayMaxSize = 4;
        int[][] matrix = ArraysAndStrings.GenerateRandomMatrix(arrayMaxSize, arrayMaxSize);

        ArraysAndStrings.IsUnique(inputString);
        ArraysAndStrings.CheckPerm(inputString, inputString1);
        ArraysAndStrings.URLify(inputString, inputString.length());
        ArraysAndStrings.PalindromePerm(inputString);
        ArraysAndStrings.OneAway(inputString, inputString1);
        ArraysAndStrings.StringCompression(inputString);
        ArraysAndStrings.StringCompression(inputString1);
        ArraysAndStrings.StringRotation(inputString1, inputString);

        ArraysAndStrings.DisplayMatrix(matrix);

        matrix = ArraysAndStrings.RotateMatrix(matrix);

        ArraysAndStrings.DisplayMatrix(matrix);

        matrix = ArraysAndStrings.ZeroedMatrix(matrix);

        ArraysAndStrings.DisplayMatrix(matrix);


    }

}
