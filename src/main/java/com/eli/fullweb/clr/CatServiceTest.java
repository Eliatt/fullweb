package com.eli.fullweb.clr;

import com.eli.fullweb.beans.Cat;
import com.eli.fullweb.beans.Color;
import com.eli.fullweb.service.CatService;
import com.eli.fullweb.utils.ArtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
@Order(1)
public class CatServiceTest implements CommandLineRunner {

    @Autowired
    private CatService catService;
    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.CAT_SERVICE_TESTING);
        System.out.println("add cats");
        Cat c1 = new Cat("Mitzi", Color.BLACK, LocalDate.of(2018, 3, 17));
        Cat c2 = new Cat("Pitzi", Color.BLACK, LocalDate.of(2016, 4, 18));
        Cat c3 = new Cat("Litzi", Color.BLACK, LocalDate.of(2019, 5, 12));

        catService.addCat(c1);
        catService.addCat(c2);
        catService.addCat(c3);
        System.out.println(catService.getAllCats());

        System.out.println("update cats");
        c1 = catService.getSingleCat(1);
        c1.setColor(Color.WHITE);
        catService.updateCat(c1);

        System.out.println(catService.getAllCats());
        System.out.println("delete cats");
        catService.deleteCat(catService.getSingleCat(2));
        System.out.println(catService.getAllCats());
        System.out.println("get single");
        System.out.println(catService.getSingleCat(3));
        System.out.println("get all cats");
        System.out.println(catService.getAllCats());

    }

}