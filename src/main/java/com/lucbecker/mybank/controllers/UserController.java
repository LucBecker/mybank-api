package com.lucbecker.mybank.controllers;

import com.lucbecker.mybank.domain.Transaction;
import com.lucbecker.mybank.domain.User;
import com.lucbecker.mybank.dtos.UserDTO;
import com.lucbecker.mybank.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService service;


    @ApiOperation(value = "Return a list of UserDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success method")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @ApiOperation(value = "Return a UserDTO by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @ApiOperation(value = "Insert a new User")
    @ApiResponse(code = 201, message = "Created")
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserDTO obj){
        User newObj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        obj = service.fromDTO(newObj);
        return ResponseEntity.created(uri).build();
    }

    @PostMapping
    public ResponseEntity<Transaction> makeWithdwawal(@PathVariable Integer id, @PathVariable Double value){
        User user = service.findById(id);
        Transaction transaction = service.makeWithdrawal(user, value);
        return ResponseEntity.ok().body(transaction);
    }
}
