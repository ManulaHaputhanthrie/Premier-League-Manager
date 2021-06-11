package com.footballManagerCw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class PremierLeagueManager implements LeagueManager
{

    static ArrayList<FootballClub> clubList = new ArrayList<>();
    static ArrayList<MatchDetails> matchDetails = new ArrayList<>();

    Scanner myScanner = new Scanner(System.in);

    static void serializing()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("clubFile.ser", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clubList);
            fos.close();
            oos.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }

    }

    {
        try
        {
            FileInputStream fis = new FileInputStream("clubFile.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clubList = (ArrayList<FootballClub>)ois.readObject();
            fis.close();
            ois.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (IOException io)
        {
            System.out.println("");;
        }
    }

    static void serializingMatchDetails()
    {
        try
        {
            FileOutputStream fosmd = new FileOutputStream("matchDetails.ser", false);
            ObjectOutputStream oosmd = new ObjectOutputStream(fosmd);
            oosmd.writeObject(matchDetails);
            fosmd.close();
            oosmd.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }


    {
        try
        {
            FileInputStream fismd = new FileInputStream("matchDetails.ser");
            ObjectInputStream oismd = new ObjectInputStream(fismd);
            matchDetails = (ArrayList<MatchDetails>)oismd.readObject();
            fismd.close();
            oismd.close();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        catch (IOException io)
        {
            System.out.println("");
        }
    }

    @Override

    public void addingClub()
    {
        System.out.println("\n********** Add a Club to the league **********\n");

        System.out.print("Choose the Football Club Type :\n \nEnter 1 if it is a University Football Club" +
                "  \nEnter 2 if it is a School Football Club\n \nEnter the choice : ");

        int choice = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("\nEnter the Name of the Club : ");
        String nameOfTheClub = myScanner.nextLine();

        System.out.print("\nEnter the Location of the Club : ");
        String clubLocation = myScanner.nextLine();

        System.out.print("\nEnter the Number of Wins : ");
        int numOfWins = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("\nEnter the Number of Draws : ");
        int numOfDraws = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("\nEnter the Number of Defeats : ");
        int numOfDefeats = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("\nEnter the number of Scored Goals : ");
        int numOfGoalsScored = myScanner.nextInt();
        myScanner.nextLine();

        System.out.print("\nEnter the number of Received Goals : ");
        int numOfGoalsReceived = myScanner.nextInt();
        myScanner.nextLine();

        switch (choice) {
            case 1:

                System.out.print("\nEnter the ID of the University : ");
                int uniId = myScanner.nextInt();
                myScanner.nextLine();

                System.out.print("\nEnter the Name of the University : ");
                String uniName = myScanner.nextLine();

                UniversityFootballClub uniFc = new UniversityFootballClub(nameOfTheClub, clubLocation,
                        numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored, numOfGoalsReceived, uniId, uniName);
                clubList.add(uniFc);
                System.out.println("\nClub " + nameOfTheClub + " added to the league successfully!\n");

                break;

            case 2:

                System.out.print("\nEnter the ID of the School : ");
                int schoolId = myScanner.nextInt();
                myScanner.nextLine();

                System.out.print("\nEnter the Name of the School : ");
                String schoolName = myScanner.nextLine();

                SchoolFootballClub schoolFc = new SchoolFootballClub(nameOfTheClub, clubLocation, numOfWins,
                        numOfDraws, numOfDefeats, numOfGoalsScored, numOfGoalsReceived, schoolId, schoolName);
                clubList.add(schoolFc);
                System.out.println("\nClub " + nameOfTheClub + " added to the league successfully!\n");

                break;

            default:
                System.out.println("Please enter a valid input!");

                break;

        }

        serializing();

    }

    @Override

    public void deletingClub()
    {
        System.out.println("\n********** Delete an existing Club from the league **********\n");

        System.out.print("Enter the Name of the club : ");
        String delClub = myScanner.nextLine();

        for (SportsClub sc : clubList)
        {

            if (sc.getNameOfTheClub().equals(delClub))
            {
                clubList.remove(sc);

                System.out.println("\nClub " + delClub + " deleted from the league!\n");
                serializing();
                return;
            }

        }

        System.out.println("\nNo such club in the league! Please try again.\n");

    }

    @Override

    public void displayStatistics()
    {
        System.out.println("\n********** Display the statistics for a club **********\n");

        System.out.print("Enter the Name of the Club : ");
        String stats = myScanner.next();

        for (FootballClub fc : clubList)
        {

            if (fc.getNameOfTheClub().equals(stats))
            {
                System.out.println(fc.statistics());
                return;
            }
        }

        System.out.println("\nNo such club in the league! Please try again.\n");

    }

    @Override

    public void displayLeagueTable()
    {
        Comparator<FootballClub> sorting = Comparator.comparing(FootballClub::getNumOfPoints).thenComparing(FootballClub::getGoalDifference);
        clubList.sort(sorting);
        Collections.reverse(clubList);

        System.out.println("********************--------------------------------------------------PREMIER LEAGUE TABLE------------------------------------------------********************");
        System.out.println("...............................................................................................................................................................");
        System.out.printf("%-27s %-22s %-17s %-17s %-17s %-19s %-19s %-17s", "CLUB NAME", "PLAYED MATCHES", "WINS", "DRAWS", "DEFEATS", "SCORED GOALS", "RECEIVED GOALS", "TOTAL POINTS");
        System.out.println("");
        System.out.println("...............................................................................................................................................................");
        System.out.println("");

        for(FootballClub fClub : clubList)
        {
            System.out.format("%-27s %-22s %-18s %-18s %-18s %-21s %-21s %-18s", fClub.getNameOfTheClub(), fClub.getNumOfMatchesPlayed(), fClub.getNumOfWins(), fClub.getNumOfDraws(),
                    fClub.getNumOfDefeats(), fClub.getNumOfGoalsScored(), fClub.getNumOfGoalsReceived(), fClub.getNumOfPoints());
            System.out.println("");
        }

        System.out.println("...............................................................................................................................................................");

    }

    @Override

    public void addingPlayedMatch()
    {

        if (clubList.size() <= 1)
        {
            System.out.println("\nAdd at least two clubs to the league for add a played match!");
        }
        else
        {

            System.out.println("\n********** Display a played match **********\n");

            int teamNum = 1;

            for (SportsClub sClub : clubList)
            {
                System.out.println(teamNum + ") " + sClub.getNameOfTheClub());
                teamNum++;
            }

            System.out.print("\nEnter the First team(Number) : ");
            int firstTeam = myScanner.nextInt() - 1;
            myScanner.nextLine();

            System.out.print("\nEnter the Second team(Number) : ");
            int secondTeam = myScanner.nextInt() - 1;
            myScanner.nextLine();

            System.out.print("\nNumber of goals Scored by First Team : ");
            int firstTeamGoals = myScanner.nextInt();
            myScanner.nextLine();

            System.out.print("\nNumber of goals Scored by Second Team : ");
            int secondTeamGoals = myScanner.nextInt();
            myScanner.nextLine();
            clubList.get(secondTeam).setNumOfGoalsScored(clubList.get(secondTeam).getNumOfGoalsScored() + secondTeamGoals);

            System.out.print("\nEnter the match played year : ");
            int matchYear = myScanner.nextInt();
            myScanner.nextLine();

            System.out.print("\nEnter the match played month : ");
            int matchMonth = myScanner.nextInt();
            myScanner.nextLine();

            System.out.print("\nEnter the match played day : ");
            int matchDay = myScanner.nextInt();
            myScanner.nextLine();

            clubList.get(firstTeam).setNumOfGoalsScored(clubList.get(firstTeam).getNumOfGoalsScored() + firstTeamGoals);
            clubList.get(firstTeam).setNumOfGoalsReceived(clubList.get(firstTeam).getNumOfGoalsReceived() + secondTeamGoals);
            clubList.get(secondTeam).setNumOfGoalsScored(clubList.get(secondTeam).getNumOfGoalsScored() + secondTeamGoals);
            clubList.get(secondTeam).setNumOfGoalsReceived(clubList.get(secondTeam).getNumOfGoalsReceived() + firstTeamGoals);

            if (firstTeamGoals > secondTeamGoals)
            {

                clubList.get(firstTeam).setNumOfWins(clubList.get(firstTeam).getNumOfWins() + 1);
                clubList.get(secondTeam).setNumOfDefeats(clubList.get(secondTeam).getNumOfDefeats() + 1);

            }
            else if (firstTeamGoals == secondTeamGoals)
            {

                clubList.get(firstTeam).setNumOfDraws(clubList.get(firstTeam).getNumOfDraws() + 1);
                clubList.get(secondTeam).setNumOfDraws(clubList.get(secondTeam).getNumOfDraws() + 1);

            }
            else
            {

                clubList.get(firstTeam).setNumOfDefeats(clubList.get(firstTeam).getNumOfDefeats() + 1);
                clubList.get(secondTeam).setNumOfWins(clubList.get(secondTeam).getNumOfWins() + 1);
            }

            Date matchDate = new Date(matchYear, matchMonth, matchDay);

            MatchDetails details = new MatchDetails(clubList.get(firstTeam).getNameOfTheClub(),
                    clubList.get(secondTeam).getNameOfTheClub(), firstTeamGoals, secondTeamGoals, matchDate);
            matchDetails.add(details);

            serializing();
            serializingMatchDetails();

        }
    }

    @Override
    public void generatingRandMatch()
    {
        if (clubList.size() <= 1)
        {
            System.out.println("\nAdd at least two clubs to the league for generate a match!");
        }
        else
        {

            Random rnd = new Random();
            int firstTeam = rnd.nextInt(clubList.size());
            int secondTeam;

            do
            {
                secondTeam = rnd.nextInt(clubList.size());
            }
            while (firstTeam == secondTeam);

            int firstTeamGoals = rnd.nextInt(15);
            int secondTeamGoals = rnd.nextInt(15);

            int matchYear = rnd.nextInt(9) + 2012;
            int matchMonth = rnd.nextInt(11) + 1;
            int matchDay = rnd.nextInt(29) + 1;

            Date matchDate = new Date(matchYear, matchMonth, matchDay);

            clubList.get(firstTeam).setNumOfGoalsScored(clubList.get(firstTeam).getNumOfGoalsScored() + firstTeamGoals);
            clubList.get(firstTeam).setNumOfGoalsReceived(clubList.get(firstTeam).getNumOfGoalsReceived() + secondTeamGoals);
            clubList.get(secondTeam).setNumOfGoalsScored(clubList.get(secondTeam).getNumOfGoalsScored() + secondTeamGoals);
            clubList.get(secondTeam).setNumOfGoalsReceived(clubList.get(secondTeam).getNumOfGoalsReceived() + firstTeamGoals);

            if (firstTeamGoals > secondTeamGoals)
            {

                clubList.get(firstTeam).setNumOfWins(clubList.get(firstTeam).getNumOfWins() + 1);
                clubList.get(secondTeam).setNumOfDefeats(clubList.get(secondTeam).getNumOfDefeats() + 1);

            }
            else if (firstTeamGoals == secondTeamGoals)
            {

                clubList.get(firstTeam).setNumOfDraws(clubList.get(firstTeam).getNumOfDraws() + 1);
                clubList.get(secondTeam).setNumOfDraws(clubList.get(secondTeam).getNumOfDraws() + 1);

            }
            else
            {

                clubList.get(firstTeam).setNumOfDefeats(clubList.get(firstTeam).getNumOfDefeats() + 1);
                clubList.get(secondTeam).setNumOfWins(clubList.get(secondTeam).getNumOfWins() + 1);

            }

            MatchDetails details = new MatchDetails(clubList.get(firstTeam).getNameOfTheClub(),
                    clubList.get(secondTeam).getNameOfTheClub(), firstTeamGoals, secondTeamGoals, matchDate);
            matchDetails.add(details);

            serializing();
            serializingMatchDetails();

        }
    }

}
