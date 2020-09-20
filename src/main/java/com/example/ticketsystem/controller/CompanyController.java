package com.example.ticketsystem.controller;

import com.example.ticketsystem.dto.CompanyDto;
import com.example.ticketsystem.model.Company;
import com.example.ticketsystem.serice.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAll")
    public List<CompanyDto> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/getById/{companyId}")
    public Company getById(Long id) {//or @PathVariable
        return companyService.getById(id);
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody List<CompanyDto> companyDtos) {
        companyService.addCompany(companyDtos);
    }
}
