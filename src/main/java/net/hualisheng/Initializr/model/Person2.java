package net.hualisheng.Initializr.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
//@ConfigurationProperties(prefix = "person")
public class Person2 {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    @Value("${person.email}")
    private String email;
//    @Value("${person.lastName}") --不支持松散型语法
    @Value("${person.last-name}")
    private String lastName;
    @Value("${person.birth}")
    private Date birth;
    @Value("${person.boss}")
    private Boolean boss;
    @Value("${person.list}")
    private List<String> list;
    @Value("${person.maps}")
    private Map<String,String> maps;
    @Value("${person.dog}")
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", boss=" + boss +
                ", list=" + list +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
