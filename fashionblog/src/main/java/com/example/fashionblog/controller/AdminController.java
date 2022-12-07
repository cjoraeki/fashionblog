package com.example.fashionblog.controller;


import com.example.fashionblog.dto.AdminLoginDto;
import com.example.fashionblog.dto.AdminRegisterDto;
import com.example.fashionblog.dto.AdminResponseDto;
import com.example.fashionblog.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminResponseDto> toRegisterAdmin(@Valid @RequestBody AdminRegisterDto adminRegisterDto){
        AdminResponseDto adminResponseDto = adminService.signUpAdmin(adminRegisterDto);
        return new ResponseEntity<>(adminResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AdminResponseDto> toLoginAdmin(@Valid @RequestBody AdminLoginDto adminLoginDto, AdminResponseDto adminResponseDto){
        AdminResponseDto admin = adminService.loginAdmin(adminLoginDto, adminResponseDto);
        return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
    }


}
