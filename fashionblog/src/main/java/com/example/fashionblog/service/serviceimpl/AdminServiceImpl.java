package com.example.fashionblog.service.serviceimpl;

import com.example.fashionblog.dto.AdminLoginDto;
import com.example.fashionblog.dto.AdminRegisterDto;
import com.example.fashionblog.dto.AdminResponseDto;
import com.example.fashionblog.entity.Admin;
import com.example.fashionblog.exception.ResourceNotFoundException;
import com.example.fashionblog.repository.AdminRepository;
import com.example.fashionblog.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    @Override
    public Admin signUpAdmin(AdminRegisterDto adminRegisterDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminRegisterDto, admin);

        return adminRepository.save(admin);
    }

    @Override
    public AdminResponseDto loginAdmin(AdminLoginDto adminLoginDto, AdminResponseDto adminResponseDto) {
        Admin admin = adminRepository.findAdminByEmail(adminLoginDto.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("Email not found!", "Enter a valid email address"));

        if (admin == null || !adminLoginDto.getEmail().equals(admin.getEmail())){
            throw new ResourceNotFoundException("Invalid password", "Check the password and try again");
        }
        BeanUtils.copyProperties(admin, adminResponseDto);
        return adminResponseDto;
    }

    @Override
    public void deleteAdminById(AdminResponseDto adminResponseDto){
        adminRepository.deleteById(adminResponseDto.getAdminId());
    }

}
