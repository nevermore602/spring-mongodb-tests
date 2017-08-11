package com.zj.springmongodbtests.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by zj on 17-8-10.
 */
@Getter
@Setter
@ToString
public class GroupResult<T> {
    public static final String COUNT_FIELD_ID = "_id";
    public static final String COUNT_FIELD_COUNT = "count";

    @Field(COUNT_FIELD_ID)
    private T id;

    @Field(COUNT_FIELD_COUNT)
    private long count;
}
