package com.zj.springmongodbtests.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by zj on 17-8-11.
 */
@Getter
@Setter
@ToString
public class BucketResult {
    public static final String FIELD_NAMES = "names";
    public static final String FIELD_COUNT = "count";
    public static final String FIELD_MIN_VALUE = "minValue";
    public static final String FIELD_MAX_VALUE = "maxValue";

    private List<String> names;
    private long count;
    private int minValue;
    private int maxValue;
}
