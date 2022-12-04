package com.example.fashionblog.controller;


import com.example.fashionblog.dto.*;
import com.example.fashionblog.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<String> toRegisterAdmin(@RequestBody ClientSignUpDto clientSignUpDto){
        clientService.registerAClient(clientSignUpDto);
        return new ResponseEntity<>("Client successfully registered", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ClientResponseDto> toLoginAdmin(@RequestBody ClientLoginDto clientLoginDto, ClientResponseDto clientResponseDto){
        ClientResponseDto client = clientService.loginClient(clientLoginDto, clientResponseDto);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> toDeleteAdmin(@RequestBody ClientResponseDto clientResponseDto){
        clientService.deleteClientById(clientResponseDto);
        return new ResponseEntity<>("Client deleted", HttpStatus.OK);
    }
}
