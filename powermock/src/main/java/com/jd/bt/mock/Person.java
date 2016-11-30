package com.jd.bt.mock;

/**
 * User: 吴海旭
 * Date: 2016-12-01
 * Time: 上午00:28
 */
public class Person {
    private String name;
    private int age;
    private Father father;

    public Person() {

    }

    private Person(String name, int age, Father father) {
        this.name = name;
        this.age = age;
        this.father = father;
    }

    public String hello() {
        return "world";
    }

    public Father getFather() {
        return father;
    }

    public String toString() {
        return name + "->" + age + "->" + father.getName();
    }
}
