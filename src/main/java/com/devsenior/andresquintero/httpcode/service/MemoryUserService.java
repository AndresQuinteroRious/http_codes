package com.devsenior.andresquintero.httpcode.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.andresquintero.httpcode.dto.UserDto;
import com.devsenior.andresquintero.httpcode.dto.UserRequest;
import com.devsenior.andresquintero.httpcode.exepcion.AlreadyExistEcxeption;
import com.devsenior.andresquintero.httpcode.exepcion.MissingValuesException;
import com.devsenior.andresquintero.httpcode.exepcion.UserNotFoundException;

@Service
public class MemoryUserService implements UserService {

    private List<UserDto> list = new ArrayList<>();

    @Override
    public List<UserDto> getAll() {
        return list;
    }

    @Override
    public UserDto getByUsername(String username) {
        return list.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public UserDto getByEmail(String email) {

        return list.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(
                        "no fue encontrado el usuario con el email dado"));
    }

    @Override
    public UserDto create(UserRequest user) {

        // VALIDAR QUE EL USUARIO NO EXISTE

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new MissingValuesException("Faltan valores obligatorios del nombre");
        }
        try {
            getByUsername(user.getUsername());
            throw new AlreadyExistEcxeption("El nombre de usuario ya existe");
        } catch (UserNotFoundException e) {
            // esta bien

            // Usuario no encontrado, se puede crear

            var newUser = new UserDto();
            newUser.setName(user.getName());
            newUser.setUsername(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setHireDate(LocalDate.now());
            newUser.setActive(true);
          
            System.out.println(newUser);
            list.add(newUser);
            return newUser;
        }

        /*
         * if (getByUsername(user.getUsername()) != null) {
         * throw new AlreadyExistEcxeption("El nombre de usuario ya existe");
         * }
         * 
         * //validar que el email no existe
         * 
         * if (user.getEmail() == null || user.getEmail().isBlank()) {
         * throw new MissingValuesException("Faltan valores obligatorios del correo");
         * }
         * if (getByEmail(user.getEmail()) != null) {
         * throw new
         * EmailAlreadyExistEcxeption("El correo electronico ya existe en la lista de usuarios"
         * );
         * 
         * }
         * list.add(user);
         * return user;
         */
    }

    @Override
    public String toString() {
        return "MemoryUserService [list=" + list + ", getAll()=" + getAll() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    @Override
    public void delete(String username) {
        var existing = getByUsername(username);
        list.remove(existing);
    }

}
