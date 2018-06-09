/**
 This is where I will post all my solutions to the interview questions
 about Linked Lists from Cracking the Coding Interview

 Author: Maks Kozak (Maksism)
 **/


/*
    Problem
        3.6
    Description
        A class which stores cats and dogs in the order they arrive in.
        Returns either the latest pet put in or they will put
        We will represent dogs = 0 and cats = 1.
*/

public class AnimalShelter
{
    int numOfDogs = 0;
    int numOfCats = 0;
    LinkedList petsAvailable = null;

    public AnimalShelter()
    {
        petsAvailable = new LinkedList();
    }

    public void Enqueue(int animalType)
    {
        if (animalType == 1)
        {
            numOfCats++;
            petsAvailable.Append(animalType);
        }
        else if (animalType == 0)
        {
            numOfDogs++;
            petsAvailable.Append(animalType);
        }
        else
            System.out.println("Not a valid type of pet");
    }

    public LinkedList DequeueAny()
    {
        LinkedList temp= null;

        if (numOfDogs > 0 || numOfCats > 0)
        {
            if (petsAvailable.GetData() == 1)
            {
                temp = this.DequeueCat();
            }
            else if (petsAvailable.GetData() == 0)
            {
                temp = this.DequeueDog();
            }
        }
        else
        {
            System.out.println("No Animals Left");
        }

        return temp;
    }

    public LinkedList DequeueDog()
    {
        if (numOfDogs > 0)
        {
            numOfDogs--;
            System.out.println("Adopted Doggo");
            return petsAvailable.DeleteNode(0);
        }
        else
        {
            System.out.println("No Dogs Left");
            return petsAvailable;
        }
    }

    public LinkedList DequeueCat()
    {
        if (numOfCats > 0)
        {
            numOfCats--;
            System.out.println("Adopted Kitty");
            return petsAvailable.DeleteNode(1);
        }
        else
        {
            System.out.println("No Cats Left");
            return petsAvailable;
        }
    }

    public int GetLength()
    {
        return petsAvailable.GetLength();
    }
}
