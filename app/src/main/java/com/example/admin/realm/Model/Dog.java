package com.example.admin.realm.Model;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by admin on 2016/4/26.
 */
public class Dog extends RealmObject {
    @Required // Name cannot be null
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
