package com.example.ticketsystem.serice;

import com.example.ticketsystem.dto.CompanyDto;
import com.example.ticketsystem.dto.CompanyMapper;
import com.example.ticketsystem.model.Company;
import com.example.ticketsystem.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public Company getById(Long companyId) {
        return companyRepository.getOne(companyId);
    }

    public List<CompanyDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyMapper::toDto).collect(Collectors.toList());
    }

    public void addCompany(List<CompanyDto> companyDtos) {
        companyRepository.saveAll(companyDtos.stream().map(CompanyMapper::toModel).collect(Collectors.toList()));
    }

}
