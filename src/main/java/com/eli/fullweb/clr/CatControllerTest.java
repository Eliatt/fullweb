package com.eli.fullweb.clr;

import com.eli.fullweb.beans.Cat;
import com.eli.fullweb.beans.Color;
import com.eli.fullweb.utils.ArtUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
//@Order(2)
public class CatControllerTest implements CommandLineRunner {

    private static final String URL = "http://localhost:8080/cats/";
    private RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> res;
    ResponseEntity<Cat> resCat =null;

    public CatControllerTest() {
        res = null;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.CAT_CONTROLLER_TESTING);
        System.out.println("Add cat");
        Cat c1 = new Cat("Simba", Color.WHITE, LocalDate.of(2019, 3, 22));
        res = restTemplate.postForEntity(URL + "add", c1, String.class);
        System.out.println(res);

        System.out.println("Update cat");
        ResponseEntity<Cat> res2 = restTemplate.getForEntity(URL + "get-single?id=1", Cat.class);
        c1 = res2.getBody();
        c1.setColor(Color.BLACK);
        c1.setName("Kobi");
        restTemplate.put(URL + "update", c1);

        res = restTemplate.getForEntity(URL + "get-all", String.class);
        System.out.println(res);


        System.out.println("Delete cat");
        res2 = restTemplate.getForEntity(URL + "get-single?id=1", Cat.class);
        c1 = res2.getBody();
        HttpEntity<Cat> entity = new HttpEntity<>(c1);
        restTemplate.exchange(URL + "delete", HttpMethod.DELETE, entity, String.class);

        System.out.println("Get All");
        res = restTemplate.getForEntity(URL + "get-all", String.class);
        System.out.println(res);

        System.out.println("Get Single");
        res = restTemplate.getForEntity(URL + "get-single?id=2", String.class);

        System.out.println(res);
    }

}
