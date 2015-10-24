package model;

import java.io.Serializable;

public class User implements Serializable
{
    private int id;
    private String account;
    private String password;
    private String phonenumber;
    private int integral;
    private int thelength;
    private int welfareid;

   public int getId()
    {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public String getAccount()
    {
        return account;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public int getIntegral()
    {
        return integral;
    }
    public int getThelength()
    {
        return thelength;
    }
    public int getWelfareid()
    {
        return welfareid;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password =password;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
    public void setIntegral(int integral)
    {
        this.integral = integral;
    }
    public void setThelength(int thelength)
    {
        this.thelength = thelength;
    }
    public void setWelfareid(int welfareid)
    {
        this.welfareid = welfareid;
    }
}
