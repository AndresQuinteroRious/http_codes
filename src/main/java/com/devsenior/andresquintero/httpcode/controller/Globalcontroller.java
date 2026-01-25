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

import com.devsenior.andresquintero.httpcode.exepcion.EmailAlreadyExistEcxeption;

@RestController
@RequestMapping("/api/global")
public class Globalcontroller {
    private List<Map<String, Object>> list = new ArrayList<>();

    @GetMapping
    public List<Map<String, Object>> getList() {
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createandReturnIndex(@RequestBody Map<String, Object> entity) {
        var email = entity.get("email");
        if (isEmailList(email)) {
            throw new EmailAlreadyExistEcxeption("");
        }

        var size = list.size();
        list.add(entity);
        return size;
    }

    private boolean isEmailList(Object email) {
        var count = list.stream()
                .filter(o -> o.get("email").equals(email))
                .count();
        return count == 1;
    }

}
