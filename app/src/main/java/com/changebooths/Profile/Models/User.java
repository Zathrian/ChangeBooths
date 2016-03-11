package com.changebooths.Profile.Models;

import java.util.ArrayList;

/*
* Basic User class to create an instance of the logged in user. Feel free to add more attributes!
*/
public class User {

    String Name;
    String Education;
    String Email;
    String Phone;
    public static ArrayList<String> skills;
    public static ArrayList<String> work;

    public User(String Name, String Phone, String Email, String Education, ArrayList skills)
    {
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.Education = Education;
        this.skills = skills;
        this.work = new ArrayList<String>();
    }

}
