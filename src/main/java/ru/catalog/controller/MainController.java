package ru.catalog.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.catalog.entity.CategoryEntity;
import ru.catalog.repos.BooksRepo;
import ru.catalog.repos.CategoryRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    BooksRepo booksRepo;

    @RequestMapping("/categoryList")
    public String getCategoryList(){
        List<CategoryEntity> list = new ArrayList<>();
        Iterable<CategoryEntity> iterable = categoryRepo.findAll();

        iterable.forEach(list::add);

        String result = new Gson().toJson(list);

        return result;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity addCategory(@RequestParam("name") String name){
        try {
            categoryRepo.save(new CategoryEntity(name));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public ResponseEntity deleteCategory(@RequestParam("id") int id){
        try {
            categoryRepo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
