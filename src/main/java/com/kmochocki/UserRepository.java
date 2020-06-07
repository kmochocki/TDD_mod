package com.kmochocki;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private final Map<Integer, User> users = new HashMap<>();

    public void createUser(String imie) {
        if (imie == null || imie.length() < 3) {
            throw new RepositoryException("Imie nie moze byc krotsze jak 3 znaki");
        }
        int id = users.size();
        users.put(id, new User(id, imie));
    }

    public Optional<User> findUserByName(String imie) {
        return users.values()
                .stream()
                .filter(user -> user.getImie().equals(imie))
                .findFirst();
    }

    public void modifyUser(User user) {
        users.put(user.getId(), user);
    }
}
