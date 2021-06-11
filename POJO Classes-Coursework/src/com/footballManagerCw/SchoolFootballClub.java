package com.footballManagerCw;

public class SchoolFootballClub extends FootballClub
{

    private int schoolId;
    private String schoolName;

    public SchoolFootballClub()
    {
    }

    public SchoolFootballClub(String nameOfTheClub, String clubLocation, int numOfWins, int numOfDraws,
                              int numOfDefeats, int numOfGoalsScored, int numOfGoalsReceived, int schoolId, String schoolName)
    {
        super(nameOfTheClub, clubLocation, numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored, numOfGoalsReceived);
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public int getSchoolId()
    {
        return schoolId;
    }

    public void setSchoolId(int schoolId)
    {
        this.schoolId = schoolId;
    }

    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    @Override
    public String toString()
    {
        return  "School Id = " + schoolId + ", School Name = " + schoolName ;
    }

}
