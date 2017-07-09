package lovage.companies.service;

import java.util.List;

import lovage.domain.Company;
import lovage.domain.Field;

public interface ICompaniesService {

	List<Company> getMinCompanies();

	Company getCompany(Long id);

	boolean addField(Long id, Field field);

	boolean create(Company company);

	boolean validate(Company company);

	Company login(Company company);
}
