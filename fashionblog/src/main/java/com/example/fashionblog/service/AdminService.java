package com.example.fashionblog.service;

import com.example.fashionblog.dto.AdminLoginDto;
import com.example.fashionblog.dto.AdminRegisterDto;
import com.example.fashionblog.dto.AdminResponseDto;
import com.example.fashionblog.entity.Admin;

public interface AdminService {

    Admin signUpAdmin(AdminRegisterDto adminRegisterDto);

    AdminResponseDto loginAdmin(AdminLoginDto adminLoginDto, AdminResponseDto adminResponseDto);

    void deleteAdminById(AdminResponseDto adminResponseDto);

}
