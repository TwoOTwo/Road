package DB;

public class User
{
    private int id;
    private String username;
    private String account;


    public int getId()
    {
        return id;
    }
    public String getUsername()
    {
        return username;
    }
    public String getAccount()
    {
        return account;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
