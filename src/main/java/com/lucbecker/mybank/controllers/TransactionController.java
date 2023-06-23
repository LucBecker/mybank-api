package com.lucbecker.mybank.controllers;

import com.lucbecker.mybank.domain.Transaction;
import com.lucbecker.mybank.dtos.TransactionDTO;
import com.lucbecker.mybank.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @ApiOperation(value = "Return all transactions")
    @ApiResponse(code = 200, message = "Success method return")
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<Transaction> list = service.findAll();
        List<TransactionDTO> listDTO = list.stream().map(obj -> service.fromDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }



}
