package no.jceldoey.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import no.jceldoey.app.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroService1ApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAvatarUrl() throws Exception {
		
		ResponseEntity<String> response = new UserController().getImage("jceldoey");
		
		Assert.notNull(response, "The image avatar object must not be null");
	}

}
