package org.example.springapi.service;

import org.example.springapi.api.model.PostUserRequest;
import org.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Guilherme", 21, "guilherme@mail.com");
        User user2 = new User(2, "Arthur", 18,"arthur@mail.com");
        User user3 = new User(3, "Audric", 27, "audric@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3));
    }

    public Optional<User> getUser(Integer id) {
        return userList
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public int createUser(PostUserRequest user) throws Exception {
        int lastId = userList.get(userList.size() - 1).getId();

        if(!user.isValid())
            throw new Exception("User is not valid.");

        int userId = lastId + 1;
        userList.add(new User(userId, user.getName(), user.getAge(), user.getEmail()));

        return userId;
    }
}
