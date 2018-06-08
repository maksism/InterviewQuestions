/**
 This is where I will post all solutions to the interview questions
 about Queues from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/

import java.util.NoSuchElementException;

public class Queue
{
    private int data;
    private Queue next = null;
    private Queue first = null;
    private Queue last = null;

    public Queue() {}

    //A basic constructor with data
    public Queue(int data)
    {
        this.data = data;
    }

    //A basic add method
    public void Add(int data)
    {
        Queue queue = new Queue(data);

        if (first == null)
            first = last = queue;
        if (last != null)
        {
            last.next = queue;
            last = queue;
        }
    }

    //A basic remove method
    public int Remove()
    {
        int data = first.data;

        if (first == null)
            throw new NoSuchElementException();
        else if (first == last)
            first = last = next = null;
        else
            first = first.next;

        return data;
    }

    //A basic peek method
    public int Peek()
    {
        if (first == null)
            throw new NoSuchElementException();
        else
            return first.data;
    }

    public boolean IsEmpty()
    {
        if (first == null)
            return true;
        else
            return false;
    }
}
