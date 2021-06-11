package com.footballManagerCw;

import java.io.Serializable;

public abstract class SportsClub implements Serializable
{

    private String nameOfTheClub;
    private String clubLocation;

    public SportsClub()
    {
    }

    public SportsClub(String nameOfTheClub, String clubLocation)
    {
        this.nameOfTheClub = nameOfTheClub;
        this.clubLocation = clubLocation;
    }

    public String getNameOfTheClub()
    {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub)
    {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getClubLocation()
    {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation)
    {
        this.clubLocation = clubLocation;
    }

    @Override
    public String toString()
    {
        return "Name of the Club = " + nameOfTheClub + ", Location of the Club = " + clubLocation ;
    }

}
