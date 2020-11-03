package com.eli.fullweb.rest;

import com.eli.fullweb.beans.Cat;
import com.eli.fullweb.exceptions.ColorException;
import com.eli.fullweb.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatController {
    @Autowired
    private CatService service;

    @PostMapping("add")
//	@RequestMapping(path = "add",method = RequestMethod.POST)
    public ResponseEntity<?> addCat(@RequestBody Cat cat) {
        try {
            service.addCat(cat);
            return new ResponseEntity<String>("Cat added succussfully",HttpStatus.CREATED);
        } catch (ColorException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCat(@RequestBody Cat cat) {
        service.updateCat(cat);
        return new ResponseEntity<String>("Cat was updated",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteCat(@RequestBody Cat cat) {
        service.deleteCat(cat);
        return new ResponseEntity<String>("Cat was deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllCats(){
        return new ResponseEntity<List<Cat>>(service.getAllCats(),HttpStatus.OK);
    }

    @GetMapping("get-single")
    public ResponseEntity<?> getSingleCat(@RequestParam(name = "id") int id) {
        return new ResponseEntity<Cat>(service.getSingleCat(id),HttpStatus.OK);
    }

    @GetMapping("get-single2/{id}")
    public ResponseEntity<?> getSingleCat2(@PathVariable(name = "id") int id) {
        return new ResponseEntity<Cat>(service.getSingleCat(id),HttpStatus.OK);
    }
}