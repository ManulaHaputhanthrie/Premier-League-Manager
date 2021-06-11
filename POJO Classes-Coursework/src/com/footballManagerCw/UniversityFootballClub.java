package com.footballManagerCw;

public class UniversityFootballClub extends FootballClub
{

    private int uniId;
    private String uniName;

    public UniversityFootballClub()
    {
    }

    public UniversityFootballClub(String nameOfTheClub, String clubLocation, int numOfWins, int numOfDraws,
                                  int numOfDefeats, int numOfGoalsScored, int numOfGoalsReceived, int uniId, String uniName)
    {
        super(nameOfTheClub, clubLocation, numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored, numOfGoalsReceived);
        this.uniId = uniId;
        this.uniName = uniName;
    }

    public int getUniId()
    {
        return uniId;
    }

    public void setUniId(int uniId)
    {
        this.uniId = uniId;
    }

    public String getUniName()
    {
        return uniName;
    }

    public void setUniName(String uniName)
    {
        this.uniName = uniName;
    }

    @Override
    public String toString()
    {
        return "University Id = " + uniId + ", University Name = " + uniName ;
    }

}
