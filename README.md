|                          |       @Value       | @ConfigurationProperties |
| :----------------------: | :----------------: | :----------------------: |
|           功能           | 需要一个一个的指定 | 批量注入配置文件中的属性 |
|   松散型语法的支持程度   |       不支持       |           支持           |
| 复杂数据结构(Map,Object) |       不支持       |           支持           |
|      SpEL语法的支持      |        支持        |                          |
|      JSR303数据校验      |       不支持       |           支持           |

#### 松散型语法

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

#### JSR303数据校验

```java
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String name;
    private Integer age;
    @Email
    private String email;
}
```



```java
Caused by: org.springframework.boot.context.properties.bind.validation.BindValidationException: Binding validation errors on person
   - Field error in object 'person' on field 'email': rejected value [1111]; codes [Email.person.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [person.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@1a15b789,org.springframework.validation.beanvalidation.SpringValidatorAdapter$ResolvableAttribute@57f791c6]; default message [不是一个合法的电子邮件地址]; origin class path resource [application.properties]:3:14
```

#### 复杂型数据结构的支持程度

```java
@Value("${person.maps}")
private Map<String,String> maps;
```

```java
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'person.maps' in value "${person.maps}"
```

#### SpEL语法的支持

```java
/    @Value("${person.age}")
    @Value("#{41*74}") //SpEL语法的支持
    private Integer age;
```

> 使用@ConfigurationProperties注解的先决条件是需要添加以下依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-configuration-processor</artifactId>
	<optional>true</optional>
</dependency>
```

