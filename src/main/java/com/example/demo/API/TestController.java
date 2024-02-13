package com.example.demo.API;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TestController {
    public ArrayList<String> Items = new ArrayList<String>(List.of("1", "2", "3"));

    @GetMapping("/Test")
    public List<String> Test() {
        if (Items.isEmpty()) {
            return Collections.emptyList();
        }
        return Items;
    }

    @PostMapping("/Test")
    public ResponseEntity<Boolean> AddItem(@RequestParam String item) {
        try {
            System.out.println("List : " + Items);
            Items.add(item);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(false);
            // Handle the error here, e.g., log the error or throw a custom exception
        }
    }

    @DeleteMapping("/Test")
    public void DeleteItem(@RequestBody String itemToDelete) {
        Items.remove(itemToDelete);
    }

    @PutMapping("/Test")
    public void UpdateItem(@RequestBody String itemToUpdate) {
        Items.set(Items.indexOf(itemToUpdate), itemToUpdate);
    }

}
