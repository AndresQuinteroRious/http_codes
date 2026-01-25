package com.devsenior.andresquintero.httpcode.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.andresquintero.httpcode.model.House;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    List<String> list = new ArrayList<>(List.of("Hola", "Mundo"));

    @GetMapping

    /*
     * public List<String> getAll() {
     * return List.of("Hola", "Mundo");
     */

    public ResponseEntity<List<String>> getAll() {
        // return ResponseEntity.ok(List.of("Hola", "Mundo"));
        // var list = List.of("Hola", "Mundo");
        var list = List.<String>of();

        if (list.isEmpty()) {

            // return ResponseEntity.noContent().build();
            //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{index}")

    /*
     * public ResponseEntity<Object> getByIndex(@PathVariable Integer index) {
     * if (index < 0 || index >= list.size()) {
     * return ResponseEntity.notFound().build();
     * }
     * try {
     * var element = list.get(index);
     * return ResponseEntity.ok(element);
     * } catch (IndexOutOfBoundsException e) {
     * return ResponseEntity.noContent().build();
     * }
     * }
     */
    public ResponseEntity<String> getByIndex(@PathVariable String index) {
        try {
            var indexInList = Integer.parseInt(index);

            var element = list.get(indexInList);

            return ResponseEntity.ok(element);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.noContent().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest()
                    .body("el indice no puede ser convertido a un número");
        }
    }

    @PostMapping

    public ResponseEntity<Integer> create(@RequestBody String entity) {

        var h1 = House.builder()
                .address("Cra 1 # 2-03")
                .build();
        // h1= new House(null,null,"Cra 1 # 2-03", "White", false, 3);
        var h2 = House.builder()
                .numWindows(4)
                .color("Blue")
                .haveGarage(true)

                .build();
        // h2= new House(null,"Blue",true,4);
        /*
         * list.add(entity);
         * return ResponseEntity.created(null).body(list.size() - 1);
         */

        var index = list.size();
        list.add(entity);
        return ResponseEntity.created(URI.create("/api/sample/" + index))
                .body(index);
    }

}
