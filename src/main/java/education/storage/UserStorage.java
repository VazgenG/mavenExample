package education.storage;


import education.exeption.UserNotFoundException;
import education.model.User;
import education.util.FileUtil;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String, User> userMap = new HashMap<>();


    public void add(User user) {
        userMap.put(user.getEmail(), user);
        FileUtil.serializeUserMap(userMap);
    }


    public void print() {
        for (User value : userMap.values()) {
            System.out.println(value);
        }
    }

    public User getByEmail(String email) {
        return userMap.get(email);

    }

    public void initData() {
        Map<String, User> userMapFile = FileUtil.deserializeSUserMap();
        if (userMapFile != null) {
            userMap = userMapFile;
        }
    }
}