package linad.JavaFraimworkSpringSem3_2.services;

import linad.JavaFraimworkSpringSem3_2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private NotificationService notification;
    public User addUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notification.notifyUser(user);

        return user;
    }

}
