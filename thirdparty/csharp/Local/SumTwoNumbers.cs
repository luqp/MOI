using System;

public class MainClass 
{
    public static void Main(string[] args) 
    {
        Console.WriteLine("Insert number1");
        Console.Write("> ");
        string number1 = Console.ReadLine();

        Console.WriteLine("Insert number2");
        Console.Write("> ");
        string number2 = Console.ReadLine();

        int sum = int.Parse(number1) + int.Parse(number2);

        Console.WriteLine("Sum = " + sum);
    }
}
