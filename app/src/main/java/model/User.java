package model;

public class User
{
    private int id;
    private String account;
    private String password;

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
}
