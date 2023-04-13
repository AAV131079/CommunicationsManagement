package com.example.CommunicationsManagement.service;

import com.example.CommunicationsManagement.entity.CompanyEntity;
import com.example.CommunicationsManagement.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyEntity> findAll() {
        return companyRepository.findAll();
    }

    public Optional<CompanyEntity> findById(Long id) {
        return companyRepository.findById(id);
    }

    public CompanyEntity save(CompanyEntity company) {
        return companyRepository.save(company);
    }

    public int deleteById(Long id) {
        return companyRepository.deleteByCompanyId(id);
    }

}