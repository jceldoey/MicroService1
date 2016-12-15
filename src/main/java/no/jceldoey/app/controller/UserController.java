package no.jceldoey.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String hiThere(@PathVariable String name){

		String response = "Hi there, " + name;

		return response;
	}

	@RequestMapping(value = "/{name}/image", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getImage(@PathVariable String name){

		String response = "Hi there, " + name + ". You want an image?";
		
		try {
			URL url = new URL("https://api.github.com/users/" + name);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			InputStream is = conn.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
			String jsonData = buffer.lines().collect(Collectors.joining("\n"));
			is.close();
			conn.disconnect();
			
			JsonNode rootNode = new ObjectMapper().readTree(new StringReader(jsonData));
			JsonNode avatarNode = rootNode.path("avatar_url");
			String avatarUrl = avatarNode.asText();
			System.out.println("avatar = " + avatarUrl);
			
			response += " " + avatarNode.asText();
			
//			url = new URL(avatarUrl);
//			conn = (HttpURLConnection) url.openConnection();
			
//			ByteBuffer bb = new ByteB
//			byte[] image = conn.getInputStream().
			
//			org.springframework.http.HttpHeaders headers = new HttpHeaders();
//		    headers.setContentType(MediaType.IMAGE_JPEG);
//		    headers.setContentLength(image.length);
		    
		    return new ResponseEntity<>(response, null);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			response = e.getMessage();
		}

		return null;
	}

}
