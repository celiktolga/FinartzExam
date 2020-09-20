package com.example.ticketsystem.dto;

import com.example.ticketsystem.model.Company;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyMapper {

    public CompanyMapper() {

    }

    public static CompanyDto toDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompany_id(company.getId());
        companyDto.setName(company.getName());
        return companyDto;
    }

    public static Company toModel(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getCompany_id());
        company.setName(companyDto.getName());
        return company;
    }
}
