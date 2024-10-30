package com.diyara.firstjobapp.company.impl;

import com.diyara.firstjobapp.company.Company;
import com.diyara.firstjobapp.company.CompanyRepository;
import com.diyara.firstjobapp.company.CompanyService;
import com.diyara.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository comapanyRepository;

    public CompanyServiceImpl(CompanyRepository comapanyRepository) {
        this.comapanyRepository = comapanyRepository;
    }

    @Override
    public List<Company> getAllComapnies() {
        return comapanyRepository.findAll();
    }
    @Override
    public boolean deleteCompanyById(Long id) {

            if(comapanyRepository.existsById(id)) {
                comapanyRepository.deleteById(id);
                return true;
            }else{

            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return comapanyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> CompanyOptional = comapanyRepository.findById(id);

        if(CompanyOptional.isPresent()){
            Company companyToUpdate= CompanyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            comapanyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }



    @Override
    public void createCompany(Company company) {
        comapanyRepository.save(company);
    }



}
