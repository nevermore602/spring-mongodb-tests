package com.zj.springmongodbtests.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by zj on 17-8-10.
 */
@Getter
@Setter
@ToString
@Document(collection = User.COLLECTION_NAME)
public class User {
    public static final String COLLECTION_NAME = "user";

    public static final String FIELD_NAME = "name";
    public static final String FIELD_AGE = "age";
    public static final String FIELD_SEX = "sex";
    public static final String FIELD_ID = "id";

    public User() {}

    public User(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String id, String name, int age, int sex) {
        this(name, age, sex);
        this.id = id;
    }

    @Id
    private String id;
    private String name;
    private int age;
    private int sex;
}
