package net.hualisheng.Initializr;

import net.hualisheng.Initializr.model.Person;
import net.hualisheng.Initializr.model.Person2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitializrApplicationTests {
	@Autowired
	private Person person;
	@Autowired
	private Person2 person2;

	@Test
	public void contextLoads() {
		System.err.println("@ConfigurationProperties person");
		System.err.println(person);
		System.err.println("@Value person2");
		System.err.println(person2);
	}

}
