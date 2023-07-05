package pojos;

public class Authpojo {
    private String username;
    private String password;

    private Boolean rememberme;

    public Authpojo(String username, String password, Boolean rememberme) {
        this.username = username;
        this.password = password;
        this.rememberme = rememberme;
    }

    public Authpojo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberme() {
        return rememberme;
    }

    public void setRememberme(Boolean rememberme) {
        this.rememberme = rememberme;
    }

    @Override
    public String toString() {
        return "Authpojo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberme=" + rememberme +
                '}';
    }
}
