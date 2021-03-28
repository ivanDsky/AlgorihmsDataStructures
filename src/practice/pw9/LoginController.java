package practice.pw9;

import java.util.List;

public class LoginController {
    private List<User> users = List.of(
            new User("Ivan", "12_34", "Be happy"),
            new User("Dmytro", "do_work!", "True|false")
    );

    public String onSendClick(String login, String password) {
        User curUser = new User(login, password);
        int idx = users.indexOf(curUser);
        if(idx != -1){
            User newUser = users.get(idx);
            String secretInfo = newUser.getSecretInformation(password);
            return secretInfo;
        }
        return null;
    }
}
