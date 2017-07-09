package lovage.companies.service;

import java.util.List;

import javax.ejb.Stateless;

import lovage.domain.Company;
import lovage.domain.Field;

@Stateless
public class CompaniesService implements ICompaniesService {

	@Override
	public List<Company> getMinCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompany(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Company login(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addField(Long id, Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
