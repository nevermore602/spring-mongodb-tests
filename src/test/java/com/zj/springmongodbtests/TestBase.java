package com.zj.springmongodbtests;

import com.zj.springmongodbtests.utils.TestUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by zj on 17-8-11.
 */
public class TestBase {
    @Autowired
    protected MongoTemplate mongoTemplate;

    @Before
    public void prepareData() {
        System.out.println("--------------prepare mongodbTemplate-------------");
        TestUtils.prepareData(mongoTemplate, 20);
    }
}
