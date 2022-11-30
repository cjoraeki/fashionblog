package com.example.fashionblog.service;

import com.example.fashionblog.dto.*;
import com.example.fashionblog.entity.Client;

public interface ClientService {

    Client registerAClient(ClientSignUpDto clientSignUpDto);

    ClientResponseDto loginClient(ClientLoginDto clientLoginDto, ClientResponseDto clientResponseDto);

    void deleteClientById(ClientResponseDto clientResponseDto);
}
