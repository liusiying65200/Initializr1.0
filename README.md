|       功能描述       | @Value | @ConfigurationProperties |
| :------------------: | :----: | :----------------------: |
| 松散型语法的支持程度 | 不支持 |           支持           |

```properties
#application.properties文件内容
person.last-name=ls
```

> @ConfigurationProperties

```java
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private String email;
    private String lastName;
    private Date birth;
    private Boolean boss;
    private List<String> list;
    private Map<String,String> maps;
    private Dog dog;

    public String getName() {
        return name;
    }
}
```

> @Value

```java
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
}
```

