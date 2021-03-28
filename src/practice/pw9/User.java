package practice.pw9;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String secretInformation;

    User(String login, String password) {
        this.login = login;
        this.password = password;
        secretInformation = "No information";
    }

    User(String login, String password, String secretInformation) {
        this.login = login;
        this.password = password;
        this.secretInformation = secretInformation;
    }

    public String getSecretInformation(String password) {
        if(this.password.equals(password))
            return secretInformation;
        else
            return null;
    }

    public void setSecretInformation(String password, String secretInformation) {
        if(!password.equals(this.password))return;
        this.secretInformation = secretInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

}
