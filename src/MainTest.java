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
        LinkedList newList = new LinkedList(0);

        for(int i = 1; i < 6; i++)
        {
            newList.Append(i);
        }


        System.out.println("Length of list: " + LinkedList.GetLength(newList));
        LinkedList.PrintLinkedList(newList);
        //newList = LinkedList.DeleteNode(newList, 5);
        newList = LinkedList.RemoveDuplicates(newList);
        LinkedList.PrintLinkedList(newList);
        for(int i = 1; i <= LinkedList.GetLength(newList); i++)
            System.out.println("The " + i + " th to last element: " + LinkedList.KthToLast(newList, i));
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
