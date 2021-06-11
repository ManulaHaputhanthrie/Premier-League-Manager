package com.footballManagerCw;

public class FootballClub extends SportsClub
{

    private int numOfWins;
    private int numOfDraws;
    private int numOfDefeats;
    private int numOfGoalsScored;
    private int numOfGoalsReceived;
    private int numOfPoints = (numOfWins * 3) + numOfDraws;
    private int numOfMatchesPlayed = numOfWins + numOfDraws + numOfDefeats;
    private int goalDifference = numOfGoalsScored - numOfGoalsReceived;

    public FootballClub()
    {
    }

    public FootballClub(String nameOfTheClub, String clubLocation, int numOfWins,
                        int numOfDraws, int numOfDefeats, int numOfGoalsScored, int numOfGoalsReceived)
    {
        super(nameOfTheClub, clubLocation);
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public int getNumOfWins()
    {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins)
    {
        this.numOfWins = numOfWins;
    }

    public int getNumOfDraws()
    {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws)
    {
        this.numOfDraws = numOfDraws;
    }

    public int getNumOfDefeats()
    {
        return numOfDefeats;
    }

    public void setNumOfDefeats(int numOfDefeats)
    {
        this.numOfDefeats = numOfDefeats;
    }

    public int getNumOfGoalsScored()
    {
        return numOfGoalsScored;
    }

    public void setNumOfGoalsScored(int numOfGoalsScored)
    {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public int getNumOfGoalsReceived()
    {
        return numOfGoalsReceived;
    }

    public void setNumOfGoalsReceived(int numOfGoalsReceived)
    {
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public int getNumOfPoints()
    {
        return (getNumOfWins() * 3) + getNumOfDraws();
    }

    public void setNumOfPoints(int numOfPoints)
    {
        this.numOfPoints = numOfPoints;
    }

    public int getNumOfMatchesPlayed()
    {
        return getNumOfWins() + getNumOfDraws() + getNumOfDefeats();
    }

    public void setNumOfMatchesPlayed(int numOfMatchesPlayed)
    {
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    public int getGoalDifference()
    {
        return getNumOfGoalsScored() - getNumOfGoalsReceived();
    }

    public void setGoalDifference(int goalDifference)
    {
        this.goalDifference = goalDifference;
    }

    public String statistics()
    {
        return "\nNumber of Wins = " + numOfWins + "\nNumber of Draws = " +
                numOfDraws + "\nNumber of Defeats = " + numOfDefeats + "\nNumber of Scored Goals = " +
                numOfGoalsScored + "\nNumber of Received Goals = " + numOfGoalsReceived + "\nNumber of Points = " +
                getNumOfPoints() + "\nNumber of played Matches = " + getNumOfMatchesPlayed() ;
    }

}
