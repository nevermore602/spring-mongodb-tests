package com.zj.springmongodbtests;

import com.zj.springmongodbtests.model.BucketResult;
import com.zj.springmongodbtests.model.GroupResult;
import com.zj.springmongodbtests.model.User;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zj on 17-8-10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BucketTests extends TestBase {

    @Test
    public void testBucketAuto() {
        List<AggregationOperation> operations = Lists.newArrayList();
        operations.add(Aggregation.bucketAuto("age", 5) //根据age自动分成5段
                .andOutput(User.FIELD_NAME).push().as(BucketResult.FIELD_NAMES) // 将每段的结果的name字段合并为一个数组，得到一个新的字段names
                .andOutputCount().as(BucketResult.FIELD_COUNT) // 指定count字段记录每段的结果数
                .andOutput(User.FIELD_AGE).min().as(BucketResult.FIELD_MIN_VALUE) // 指定minValue字段记录每段最小的age值
                .andOutput(User.FIELD_AGE).max().as(BucketResult.FIELD_MAX_VALUE) // 指定maxValue字段记录每段最大的age值
        );
        Aggregation aggregation = Aggregation.newAggregation(operations);
        List<BucketResult> list = mongoTemplate.aggregate(aggregation, User.class, BucketResult.class)
                .getMappedResults();
        list.forEach(System.out::println);
    }

    @Test
    public void testBucket() {
        List<AggregationOperation> operations = Lists.newArrayList();
        operations.add(Aggregation.bucket("age")
                .withBoundaries(0, 25, 40, 50)
                .withDefaultBucket("Other")
        );
        Aggregation aggregation = Aggregation.newAggregation(operations);
        List<GroupResult> list = mongoTemplate.aggregate(aggregation, User.class, GroupResult.class)
                .getMappedResults();
        list.forEach(System.out::println);
    }
}
