/**
 This is where I will post my solutions to the interview questions
 about Stacks from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/

import java.util.EmptyStackException;

public class Stack
{
    private int data;
    private Stack next = null;
    private Stack top = null;

    public Stack() {}

    //Default constructor with data
    public Stack(int data)
    {
        this.data = data;
    }

    //A basic pop method
    public int Pop()
    {
        int data;
        if (top == null)
            throw new EmptyStackException();
        data = top.data;
        top = top.next;
        return data;
    }

    //A basic push method
    public void Push(int data)
    {
        Stack stack = new Stack(data);
        stack.next = top;
        top = stack;
    }

    /*
        Problem
            3.2
        Description
            A Min function which returns the smallest element in the Stack.

            Incomplete! Must be done in O(1)
        Variables
            temp : A Stack to traverse the stack.
            min : An Int set to -1 in case the Stack is empty.
    */
    public int Min()
    {
        Stack temp = top;
        int min = -1;

        if (temp != null)
            min = temp.data;
        while (temp != null)
        {
            if (temp.data < min)
                min = temp.data;
            temp = temp.next;
        }

        return min;
    }

    //A Basic peek method
    public int Peek()
    {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    //A Basic IsEmpty method
    public boolean IsEmpty()
    {
        if (top == null)
            return true;
        else
            return false;
    }

    public void PrintStack()
    {
        Stack temp = top;

        System.out.println();

        while (temp != null)
        {
            if (temp.next != null)
                System.out.print(temp.data + " <- ");
            else
                System.out.print(temp.data);
            temp = temp.next;
        }

        System.out.println();
    }

    /*
        Problem
            3.5
        Description
            Write a program to sort a stack so the smallest number is on top.
        Variables
            temp : An int used to store the value currently sorting.
            index : An int to keep track of how many times we popped from the sorted stack.
            sortedStack : A Stack which we sort as we add to it.

    */
    public static Stack SortStack(Stack unsortedStack)
    {
        int temp, index = 0;
        Stack sortedStack = new Stack();

        while(!unsortedStack.IsEmpty())
        {
            temp = unsortedStack.Pop();

            if (sortedStack.IsEmpty() || temp <= sortedStack.Peek())
                sortedStack.Push(temp);
            else
            {
                while (!sortedStack.IsEmpty())
                {
                    unsortedStack.Push(sortedStack.Pop());
                    index++;
                    if (!sortedStack.IsEmpty() && temp <= sortedStack.Peek())
                        break;
                }

                sortedStack.Push(temp);

                while (index-- > 0)
                {
                    sortedStack.Push(unsortedStack.Pop());
                }
            }
        }

        return sortedStack;
    }
}