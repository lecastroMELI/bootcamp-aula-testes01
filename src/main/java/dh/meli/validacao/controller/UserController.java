package dh.meli.validacao.controller;

import dh.meli.validacao.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    // @Valid é utilizado com conjunto com a anotação NotBlank que está em UserDto
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity(userDto, HttpStatus.CREATED);
    }
}
