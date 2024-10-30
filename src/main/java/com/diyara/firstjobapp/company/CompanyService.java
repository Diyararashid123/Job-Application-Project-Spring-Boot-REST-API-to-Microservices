package com.diyara.firstjobapp.company;



import com.diyara.firstjobapp.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllComapnies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);

}
