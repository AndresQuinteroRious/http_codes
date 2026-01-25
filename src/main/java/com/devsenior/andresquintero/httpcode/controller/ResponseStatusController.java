package com.devsenior.andresquintero.httpcode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.andresquintero.httpcode.exepcion.StatusBadRequestException;




@RestController
@RequestMapping("/api/status")
public class ResponseStatusController {

    private List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

    @GetMapping
    public List<Integer> getAll() {
        return list;
    }
    
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Integer add (@RequestBody Map<String, Integer> entity) {
    try {
        var number = Integer.valueOf(entity.get("number"));
        list.add(number);
        return number;
    } catch (NumberFormatException e) {
       //debuelva Bad Request 400
        }
        throw new StatusBadRequestException();
}


}
