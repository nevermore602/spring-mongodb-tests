package com.zj.springmongodbtests;

import com.zj.springmongodbtests.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zj on 17-8-11.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveInsertTests extends TestBase {
    private User user;

    @Before
    public void prepareUser() {
        // id为0001的在库中已存在（TestBase中已经构建）
        user = new User("0001", "James", 48, 1);
    }

    // save方法，如果库中存在相同id的记录，则会更新原纪录，否则添加新记录
    @Test
    public void testSaveExist() {
        mongoTemplate.save(user);
    }

    // insert方法，如果库中存在相同id的记录，则会抛异常
    @Test
    public void testInsertExist() {
        mongoTemplate.insert(user);
    }
}
