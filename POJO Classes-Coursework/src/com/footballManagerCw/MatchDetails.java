package com.footballManagerCw;

import java.io.Serializable;

public class MatchDetails implements Serializable
{

    String firstTeam;
    String secondTeam;
    int goalsByFirstTeam;
    int goalsBySecondTeam;
    Date matchDate;

    public MatchDetails(String firstTeam, String secondTeam, int goalsByFirstTeam, int goalsBySecondTeam, Date matchDate)
    {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.goalsByFirstTeam = goalsByFirstTeam;
        this.goalsBySecondTeam = goalsBySecondTeam;
        this.matchDate = matchDate;
    }

    public String getFirstTeam()
    {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam)
    {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam()
    {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam)
    {
        this.secondTeam = secondTeam;
    }

    public int getGoalsByFirstTeam()
    {
        return goalsByFirstTeam;
    }

    public void setGoalsByFirstTeam(int goalsByFirstTeam)
    {
        this.goalsByFirstTeam = goalsByFirstTeam;
    }

    public int getGoalsBySecondTeam()
    {
        return goalsBySecondTeam;
    }

    public void setGoalsBySecondTeam(int goalsBySecondTeam)
    {
        this.goalsBySecondTeam = goalsBySecondTeam;
    }

    public Date getMatchDate()
    {
        return matchDate;
    }

    public void setMatchDate(Date matchDate)
    {
        this.matchDate = matchDate;
    }

}
