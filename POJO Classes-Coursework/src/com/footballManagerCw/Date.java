package com.footballManagerCw;

import java.io.Serializable;

public class Date implements Serializable
{

    private int matchYear;
    private int matchMonth;
    private int matchDay;

    private String matchDate;

    public Date(int matchYear, int matchMonth, int matchDay)
    {
        this.matchYear = matchYear;
        this.matchMonth = matchMonth;
        this.matchDay = matchDay;
    }

    public int getMatchYear()
    {
        return matchYear;
    }

    public void setMatchYear(int matchYear)
    {
        this.matchYear = matchYear;
    }

    public int getMatchMonth()
    {
        return matchMonth;
    }

    public void setMatchMonth(int matchMonth)
    {
        this.matchMonth = matchMonth;
    }

    public int getMatchDay()
    {
        return matchDay;
    }

    public void setMatchDay(int matchDay)
    {
        this.matchDay = matchDay;
    }

    public String getMatchDate()
    {
        return matchDate;
    }

    public void setMatchDate(String matchDate)
    {
        this.matchDate = matchDate;
    }


    @Override
    public String toString()
    {
        return matchYear + " / " + matchMonth + " / " + matchDay;
    }

}
