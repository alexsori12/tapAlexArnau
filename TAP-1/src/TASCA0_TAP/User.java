package TASCA0_TAP;

public class User {
    private String username;
    private String name;
    private int year;

    /**
     *  Metode CONSTRUCTOR
     * @param username  -- nom identificador
     * @param name  -- nom real
     * @param year -- Data de naixement
     */
    public User(String username, String name, int year){
        this.username = username;
        this.name = name;
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}


