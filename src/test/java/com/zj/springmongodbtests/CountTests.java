package com.zj.springmongodbtests;

import com.google.common.collect.Lists;
import com.zj.springmongodbtests.model.GroupResult;
import com.zj.springmongodbtests.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zj on 17-8-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountTests extends TestBase {
    private Criteria criteria;

    @Before
    public void prepareCriteria() {
        criteria = Criteria.where("sex").is(1);
    }

    // 第一种方式，直接调用count方法
    @Test
    public void testCount1() {
        System.out.println(mongoTemplate.count(Query.query(criteria), User.class));
    }

    // 第二种方式，通过aggregation
    @Test
    public void testCount2() {
        List<AggregationOperation> operations = Lists.newArrayList();
        operations.add(Aggregation.match(criteria));
        operations.add(Aggregation.count().as(GroupResult.COUNT_FIELD_COUNT));
        Aggregation aggregation = Aggregation.newAggregation(operations);
        GroupResult results = mongoTemplate.aggregate(aggregation, User.class, GroupResult.class)
                .getUniqueMappedResult();
        System.out.println(results.getCount());
    }
}
