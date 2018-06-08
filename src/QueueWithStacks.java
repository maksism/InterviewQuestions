/**
 This is where I will post my solutions to the interview questions
 about Queues from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/
/*
 Problem
      3.4
 Description
      Implement a Queue using two stacks.
      We will always add to the addStack,
      however when we remove a variable,
      if the removeStack is empty,
      we will pop the addStack onto the removeStack
 Variables
      addStack : A stack that stores all new values added.
      removeStack : A stack which we pop addStack off onto in order to remove what we need.
*/
public class QueueWithStacks extends Stack
{
    private Stack addStack = null;
    private Stack removeStack = null;

    public QueueWithStacks()
    {
        addStack = new Stack();
        removeStack = new Stack();
    }

    public void Add(int d)
    {
        addStack.Push(d);
    }

    public int Remove()
    {
        if (removeStack.IsEmpty())
            while (!addStack.IsEmpty())
                removeStack.Push(addStack.Pop());

        return removeStack.Pop();
    }

    public int Peek()
    {
        if (removeStack.IsEmpty())
            while (!addStack.IsEmpty())
                removeStack.Push(addStack.Pop());

        return removeStack.Peek();
    }

    public boolean IsEmpty()
    {
        if (addStack.IsEmpty() && removeStack.IsEmpty())
            return true;
        else
            return false;
    }
}

