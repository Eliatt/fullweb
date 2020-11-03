package com.eli.fullweb.service;

import com.eli.fullweb.beans.Cat;
import com.eli.fullweb.beans.Color;
import com.eli.fullweb.exceptions.ColorException;
import com.eli.fullweb.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public void addCat(Cat cat) throws ColorException {
        if(cat.getColor().equals(Color.RED)) {
            throw new ColorException("Red cats are not allowed");
        }
        catRepository.save(cat);
    }

    public void updateCat(Cat cat) {
        catRepository.saveAndFlush(cat);
    }

    public void deleteCat(Cat cat) {
        catRepository.delete(cat);
    }

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }


    public Cat getSingleCat(int id) {
        return catRepository.getOne(id);
    }
}
