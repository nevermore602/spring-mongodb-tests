package com.zj.springmongodbtests.utils;

import com.zj.springmongodbtests.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.util.Lists;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by zj on 17-8-11.
 */
public class TestUtils {
    public static void prepareData(MongoTemplate mongoTemplate, int count) {
        mongoTemplate.dropCollection(User.COLLECTION_NAME);
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            String id = "0000".substring(String.valueOf(i).length()) + i;
            String name = RandomStringUtils.randomAlphabetic(4, 6);
            int sex = RandomUtils.nextInt(0, 2);
            int age = RandomUtils.nextInt(18, 50);
            User user = new User(id, name, age, sex);
            System.out.println("user = " + user);
            users.add(user);
        }
        mongoTemplate.insert(users, User.COLLECTION_NAME);
    }
}
