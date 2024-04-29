package linad.JavaFraimworkSpringSem3_2.services;

import linad.JavaFraimworkSpringSem3_2.domain.User;
import linad.JavaFraimworkSpringSem3_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository users;

    public UserRepository getUsers() {
        return users;
    }
    public void addUser(User user){
        users.getUsers().add(user);
    }
    public List<User> sortedUsersByName (){//???
        return users.getUsers().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }
    public List<User> sortedUsersByAge (){//???
        return users.getUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }
    public List<User> filterUsersByAge(int age){
        return users.getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }
    public double calculateAverageAge() {
        return users.getUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
