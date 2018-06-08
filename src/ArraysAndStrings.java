/**
    This is where I will post all my solutions to the interview questions
    about Arrays and Strings from Cracking the Coding Interview

    We will assume all strings are in unicode.

    Author: Maks Kozak (Maksism)
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.util.Pair;

public class ArraysAndStrings
{
    /*
        Problem
            1.1

        Description
            This method will take a string and check if it has all unique characters

        Variables
            isUnique : A Boolean to tell us if it is unique
            charCount : An Int Array set to 128 to count all the possible unicode characters
    */
    public static void IsUnique(String string)
    {
        boolean isUnique = true;
        int[] charCount = new int[128];

        System.out.println(string);
        for (int i = 0; i < string.length(); i++)
        {
            charCount[(int)string.charAt(i)]++;
            if (charCount[string.charAt(i)] > 1)
            {
                isUnique = false;
                break;
            }
        }

        if (isUnique)
            System.out.println("The string is unique.");
        else
            System.out.println("The string is not unique.");
    }

    /*
        Problem
            1.2

        Description
            This method will take two strings and check if they are permutations of each other

        Variables
            charCount1 : An Int Array set to 128 to count all the possible unicode characters
            charCount2 : An Int Array set to 128 to count all the possible unicode characters
    */
    public static void CheckPerm(String string1, String string2)
    {
        int[] charCount1 = new int[128];
        int[] charCount2 = new int[128];

        for (int i = 0; i < string1.length(); i++)
            charCount1[(int)string1.charAt(i)]++;

        for (int i = 0; i < string2.length(); i++)
            charCount2[(int)string2.charAt(i)]++;

        if (Arrays.equals(charCount1, charCount2))
            System.out.println(string2 + " is a permutation of " + string1);
        else
            System.out.println(string2 + " is not a permutation of " + string1);

    }

    /*
        Problem
            1.3

        Description
            This method will take a string and replace all the spaces with '%20'

        Variables
            outputURL : An array that is set to the length of the worst case, all spaces
            numberOfSpaces : Keeps track of all the spaces in the string
     */
    public static void URLify(String string, int length)
    {
        char[] outputURL = new char[3*length];
        int numberOfSpaces = 0;
        /*
        Variables
            i : will traverse the string
            j : will be used to update the character arrays position if there is a space
        */
        for (int i = 0, j = 0; i < length; i++, j++)
        {
            if (string.charAt(i) == ' ')
            {
                numberOfSpaces++;
                outputURL[j++] = '%';
                outputURL[j++] = '2';
                outputURL[j] = '0';
            }
            else
                outputURL[j] = string.charAt(i);
        }

        System.out.print("The URLified string is: ");

        //Since the length already contains the spaces, we will need
        //to multiply numberOfSpaces by 2 and add it to length
        for (int i = 0; i < length + 2 * numberOfSpaces; i++)
        {
            System.out.print(outputURL[i]);
        }
    }

    /*
        Problem
            1.4

        Description
            This method will take a string and check if it is a permutation of a palindrome
            and then print out a random palindrome.

        Variables
            charCount : An Int Array of 128 to count all the possible unicode characters except the space
            palindrome : A boolean used to keep track if we have a palindrome or no.
            palindromeString : A Char Array palindrome that will be returned character by character

     */
    public static void PalindromePerm(String string)
    {
        int[] charCount = new int[128];
        char[] palindromeString = new char[string.length()];

        boolean palindrome = true;

        /*
            Get the total count of unicode characters from the passed string.
         */
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) != ' ')
                charCount[(int)string.charAt(i)]++;


        /*
            In order to be a palindrome, the word must have at most one character that has an odd count.
         */
        for (int total = 0, i = 0; i < charCount.length; i++)
        {
            total = total + charCount[i] % 2;
            if (total > 1)
                palindrome = false;
        }

        if (palindrome)
        {
            /*
                To generate a palindrome, we will start from both ends of Char Array.
                We will iterate until our beginning position is greater than our end position.
                If we have a space, we will increment/decrement the positions.
             */
            for (int i = 0, j = string.length() - 1; i <= j; i++, j--)
            {

                if (string.charAt(i) == ' ' )
                {
                    palindromeString[i] = ' ';
                    i++;
                }
                if (string.charAt(j) == ' ')
                {
                    palindromeString[j] = ' ';
                    j--;
                }

                for (int k = 0; k < 128 ; k++)
                {
                    if (charCount[k] == 1 && i == j)
                    {
                        palindromeString[i] = (char)k;
                        charCount[k] = 0;
                        break;
                    }
                    else if (charCount[k] > 1)
                    {
                        palindromeString[i]=palindromeString[j]=(char)k;
                        charCount[k] = charCount[k] - 2;
                        break;
                    }
                }
            }

            //This part prints out the generated palindrome that is associated with the string.
            System.out.print(string + " is a palindrome of ");
            for (int i = 0; i < palindromeString.length; i++)
            {
                System.out.print(palindromeString[i]);
            }
            System.out.println();
        }
        else
            System.out.println("This is not a permutation of a palindrome.");


    }

    /*
        Problem
            1.5

        Description
            This method will take two strings and determine if they are one of three edits away from being the same.
            The three edits are:
                1. Insert a char
                2. Delete a char
                3. Replace a char

        Variables
            oneAway : Used to keep track of if we are one edit away
            edits : How many edits we used.
    */
    public static void OneAway(String string1, String string2)
    {
        boolean oneAway = false;
        int edits = 0;

        ArrayList<Character> charArray1 = new ArrayList<>();
        ArrayList<Character> charArray2 = new ArrayList<>();

        for ( int i = 0; i < string1.length(); i++)
            charArray1.add(string1.charAt(i));
        for ( int i = 0; i < string2.length(); i++)
            charArray2.add(string2.charAt(i));

        // If the two sized are more than |1| value away, it will be an automatic fail,
        // because you will instantly need at least 2 edits.
        if (charArray1.size() - charArray2.size() <= 1 && charArray1.size() - charArray2.size() >= -1)
        {
            for (int i = 0; i < Math.max(charArray1.size(), charArray2.size()); i++)
            {
                //Case 1: If the strings are the same length, then the replace operation is the only operation we should use.
                if (charArray1.size() == charArray2.size())
                {
                    if (charArray1.get(i) != charArray2.get(i))
                    {
                        charArray1.remove(i);
                        charArray1.add(i, charArray2.get(i));
                        edits++;
                    }
                }
                //Case 2: If string1 is bigger than string2, we will use the delete operation.
                else if (charArray1.size() > charArray2.size())
                {
                    // If we are at the end of the bigger string, we will delete the last entry.
                    if (i + 1 == charArray1.size())
                    {
                        charArray1.remove(i);
                        edits++;
                    }
                    else if (charArray1.get(i) != charArray2.get(i) && charArray1.get(i+1) == charArray2.get(i))
                    {
                        charArray1.remove(i);
                        edits++;
                    }
                    else if (charArray1.get(i) != charArray2.get(i) && charArray1.get(i+1) == charArray2.get(i+1))
                    {
                        charArray1.remove(i);
                        charArray1.add(i, charArray2.get(i));
                        edits++;
                    }
                }
                //Case 3: If string2 is bigger than string1, we will use the add operation.
                else if (charArray2.size() > charArray1.size())
                {
                    //If we get to the end, we will add the last entry to the list
                    if (i + 1 == charArray2.size())
                    {
                        charArray1.add(charArray2.get(i));
                        edits++;
                    }
                    else if (charArray1.get(i) != charArray2.get(i) && charArray2.get(i+1) == charArray1.get(i))
                    {
                        charArray1.add(i, charArray2.get(i));
                        edits++;
                    }
                    else if (charArray1.get(i) != charArray2.get(i) && charArray1.get(i+1) == charArray2.get(i+1))
                    {
                        charArray1.remove(i);
                        charArray1.add(i, charArray2.get(i));
                        edits++;
                    }
                }
            }
        }

        if (charArray1.size() == charArray2.size() && edits <= 1)
        {
            oneAway = true;
        }


        if (oneAway)
            System.out.println(string1 + " and " + string2 + " are within one edit away.");
        else
            System.out.println(string1 + " and " + string2 + " are not within one edit away.");
    }


    /*
        Problem
            1.6

        Description
            This method will take a string of Uppercase and Lowercase letters and give out a string which contains
            the letter and how many times it repeats.

        Variables
            newString : An ArrayList used to make the new string.
            prevChar: A Char used to keep track of the previous character.
    */
    public static void StringCompression(String string)
    {
        ArrayList<Character> newString = new ArrayList<>();

        char prevChar = '-';

        for (int i = 0, timesRepeated = 0; i <= string.length() ;i++)
        {
            if (i == 0)
            {
                prevChar = string.charAt(i);
                timesRepeated = 1;
            }
            else if (i  == string.length())
            {
                newString.add(prevChar);
                newString.add((char)(timesRepeated + 48));
            }
            else if (prevChar != string.charAt(i))
            {
                newString.add(prevChar);
                newString.add((char)(timesRepeated + 48));
                prevChar = string.charAt(i);
                timesRepeated = 1;
            }
            else if (prevChar == string.charAt(i))
            {
                timesRepeated++;
            }
        }

        if (string.length() <= newString.size())
            System.out.println("The original string is shorter: " + string);
        else
            System.out.println("The new string is shorter: " + newString.toString());
    }

    /*
        Problem
            1.7

        Description:
            A method which rotates an NxN matrix 90 degrees.
            Would be impossible on the spot, because you will need to store one value always.

        Variables:
            rotatedMatrix : A 2D int array used to store the new result.
     */
    public static int[][] RotateMatrix(int[][] matrix)
    {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                rotatedMatrix[i][j] = matrix[(matrix.length-1) - j][i];

        return rotatedMatrix;

    }

    /*
        Problem
            1.8

        Description:
            A method which given an M x N matrix, it will find all the zeroes, and convert

        Variables:
            zeroedMatrix : A 2D int array used to store the new result.
            zeroLoc : An ArrayList of Pairs used to keep track of the zero locations.
    */
    public static int[][] ZeroedMatrix(int[][] matrix)
    {
        int[][] zeroedMatrix = new int[matrix.length][matrix[0].length];
        ArrayList<Pair> zeroLoc = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                zeroedMatrix[i][j] = matrix[i][j];
                if (matrix[i][j] == 0)
                    zeroLoc.add(new Pair(i, j));
            }
        }

        for (Pair pair : zeroLoc)
        {
            for (int x = 0; x < matrix.length; x++)
                zeroedMatrix[x][(int)pair.getValue()] = 0;
            for (int y = 0; y < matrix[0].length; y++)
                zeroedMatrix[(int)pair.getKey()][y] = 0;
        }

        return zeroedMatrix;
    }

    /*
        Problem
            1.9

        Description:
            A method which given two strings will determine what position the rotation happens.

        Variables:
            rotationFound : A Boolean used to determine if a rotation is found
            i : An int used to keep track of the position
    */
    public static void StringRotation(String string1, String string2)
    {
        boolean rotationFound = false;
        int i = 0;
        while(!rotationFound && i < string1.length())
        {
            if (string1.charAt(0) == string2.charAt(i))
                rotationFound = true;
            else {
                i++;
            }
        }

        System.out.println(string1 + " is a rotation of " + string2 + " at position " + i);
    }

    /*
        Description:
            A quick little function for displaying a matrix;
     */
    public static void DisplayMatrix(int[][] matrix)
    {
        System.out.println();
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.printf("%-7d", matrix[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    /*
        A quick function to generate a random X x Y matrix with a bound of 100
     */
    public static int[][] GenerateRandomMatrix(int x, int y)
    {
        int[][] matrix = new int[x][y];

        for (int i = 0; i < matrix.length; i++ )
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = new Random().nextInt(100);

        return matrix;
    }
}
