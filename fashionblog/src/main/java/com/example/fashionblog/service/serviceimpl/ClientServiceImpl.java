package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.ClientLoginDto;
import com.example.fashionblog.dto.ClientResponseDto;
import com.example.fashionblog.dto.ClientSignUpDto;
import com.example.fashionblog.entity.Client;
import com.example.fashionblog.exception.ResourceNotFoundException;
import com.example.fashionblog.repository.ClientRepository;
import com.example.fashionblog.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Client registerAClient(ClientSignUpDto clientSignUpDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientSignUpDto, client);

        return clientRepository.save(client);
    }

    @Override
    public ClientResponseDto loginClient(ClientLoginDto clientLoginDto, ClientResponseDto clientResponseDto) {
        Client client = clientRepository.findClientByEmail(clientLoginDto.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("Email not found!", "Enter a valid email address"));

        if (client == null || !clientLoginDto.getEmail().equals(client.getEmail())){
            throw new ResourceNotFoundException("Invalid password", "Check the password and try again");
        }
        BeanUtils.copyProperties(client, clientResponseDto);

        return clientResponseDto;
    }

    @Override
    public void deleteClientById(ClientResponseDto clientResponseDto) {
        clientRepository.deleteById(clientResponseDto.getClientId());
    }
}
