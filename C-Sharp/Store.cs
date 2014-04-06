using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Store
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.BackgroundColor = ConsoleColor.Red;
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("Store - A Text Based Game Created By Null For Unexpected Crab :>"); // Prompt
            Console.ResetColor();
            int workernum = 0;
            int currencytotal = 500; //default currency total
            string currency = " USD";
            string storename = "Untitled Store";

            while (true) // Loop indefinitely
            {
                string line = Console.ReadLine(); // Get string from user

                if (line == "help")
                {
                    Console.WriteLine("Available Commands:");
                    Console.WriteLine("-> add worker");
                    Console.WriteLine("-> remove worker");
                    Console.WriteLine("-> name store");
                    Console.WriteLine("-> name currency");
                    Console.WriteLine("-> open store");
                    Console.WriteLine("-> close store");
                }

                // WORKER COMMANDS

                if (line == "add worker")
                {
                    ++workernum;
                    currencytotal -= 250;
                    Console.WriteLine( storename + " currently has " + workernum + " workers!");
                    Console.WriteLine(storename + "'s Total currency: " + currencytotal);
                }

                if (line == "remove worker")
                {
                    workernum--;
                    currencytotal += 250;
                    Console.WriteLine(storename + " currently has " + workernum + " workers!");
                    Console.WriteLine(storename + "'s Total currency: " + currencytotal);
                }

                // NAME COMMANDS

                if (line == "name store")
                {
                    Console.WriteLine("Enter your stores name below:");
                    storename = Console.ReadLine();
                    Console.WriteLine("Your stores name is " + storename);
                }

                if (line == "name currency")
                {
                    Console.WriteLine("Enter your currency name of choice:");
                    currency = Console.ReadLine();
                    Console.WriteLine("Your currency name is " + currency);
                }

                // GENERAL STORE COMMANDS

                if (line == "open store")
                {
                    Random timeofday = new Random();
                    Random moneyofday = new Random();
                    int moneyadded = moneyofday.Next(69, 420) * workernum;
                    int currencyafterday = moneyadded + currencytotal;
                    Console.WriteLine(storename + " has been opened! (loading your days results in 10 seconds)");
                    Thread.Sleep(10000);

                    if (moneyadded == 0)
                    {
                        Console.WriteLine("Your store has closed at " + timeofday.Next(1, 12) + "pm, your store has received:");
                        Console.WriteLine(moneyadded + currency + " (you must purchase workers)");
                        Console.WriteLine(storename + "'s total is " + currencyafterday + currency);
                    }
                    else
                    {
                        Console.WriteLine("Your store has closed at " + timeofday.Next(1, 12) + "pm, your store has received:");
                        Console.WriteLine(moneyadded + currency);
                        Console.WriteLine(storename + "'s total is " + currencyafterday + currency);
                    }
                }

                if (line == "close store")
                {
                    Console.WriteLine("Are you sure you want to close your store? If so, your store will be deleted (rip) :(");
                    string userInput = Console.ReadLine();

                    if (userInput == "yes")
                    {
                        Console.WriteLine("rip in pizza");
                        Console.Clear();
                    }
                    else
                    {
                        Console.WriteLine(":D");
                    }
                }

                //else loop
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("----");
                Console.ResetColor();
            }
        }
    }
}
