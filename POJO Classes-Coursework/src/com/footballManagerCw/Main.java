package com.footballManagerCw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        PremierLeagueManager plm = new PremierLeagueManager();
        Scanner input = new Scanner(System.in);

        loop:

        while (true)
        {
            try
            {
                System.out.println("\n****************** Premier League Menu ******************\n");
                System.out.println("Enter 1 to Add a Club to the league ");
                System.out.println("Enter 2 to Delete an existing Club from the league ");
                System.out.println("Enter 3 to Display the Statistics for a Club ");
                System.out.println("Enter 4 to Display the league Table ");
                System.out.println("Enter 5 to Add a Played Match ");
                System.out.println("Enter 6 to Display the GUI ");
                System.out.println("\nEnter 0 to Exit the program");
                System.out.println("\n*********************************************************\n");

                System.out.print("Enter your Choice : ");

                int choice = input.nextInt();

                switch (choice)
                {
                    case 1:
                        plm.addingClub();
                        break;

                    case 2:
                        plm.deletingClub();
                        break;

                    case 3:
                        plm.displayStatistics();
                        break;

                    case 4:
                        plm.displayLeagueTable();
                        break;

                    case 5:
                        plm.addingPlayedMatch();
                        break;

                    case 6:
                        GUI.main(args);
                        break loop;

                    case 0 :
                        System.out.println("\nSuccessfully Program Exited!");
                        System.exit(0);

                    default:
                        System.out.println("\nInvalid selection! Try again.");
                        break;
                }

            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nInvalid input! Please enter a valid input.");
                input.nextLine();
            }

        }

    }

}
