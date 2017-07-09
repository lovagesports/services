package lovage.companies.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import lovage.domain.Company;
import lovage.domain.Field;
import lovage.domain.FieldType;
import lovage.utils.KeyUtils;

public class CompaniesServiceMock implements ICompaniesService {

	private static final Map<Long, Company> companies = initMockCompanies();

	@Override
	public Company getCompany(Long id) {
		Company company = companies.get(id);
		return company;
	}

	@Override
	public List<Company> getMinCompanies() {
		List<Company> result = new ArrayList<Company>();
		for (Entry<Long, Company> entry : companies.entrySet()) {

			Company copy = new Company();
			copy.id = entry.getValue().id;
			copy.name = entry.getValue().name;
			copy.email = entry.getValue().email;
			copy.fields = entry.getValue().fields;
			result.add(copy);
		}

		return result;
	}

	@Override
	public boolean addField(Long id, Field field) {

		Company company = companies.get(id);
		if (company == null) {
			return false;
		}

		return company.fields.add(field);
	}

	@Override
	public boolean create(Company company) {
		if (company == null) {
			return false;
		}

		if (company.id == null) {
			company.id = KeyUtils.nextLong(companies.keySet());
		}

		companies.put(company.id, company);

		return true;
	}

	@Override
	public boolean validate(Company company) {

		if (StringUtils.isBlank(company.name)) {
			System.out.println(String.format("Company name is empty. Make sure the company name is filled."));
			return false;
		}

		if (StringUtils.isBlank(company.email)) {
			System.out.println(String.format("Company email is empty. Make sure the Company email is filled."));
			return false;
		}

		return true;
	}

	@Override
	public Company login(Company company) {

		Company found = findCompany(company.email);
		if (found == null) {
			System.out.println(String.format("Login attempt for %s failed. Unknown e-mail.", company.email));
			return null;
		}

		if (!StringUtils.equals(found.password, company.password)) {
			System.out.println(String.format("Login attempt for %s failed. Password mismatch.", company.email));
			return null;
		}

		return found;
	}

	private Company findCompany(String email) {

		Company found = companies.values().stream().filter(item -> StringUtils.equals(email, item.email)).findFirst()
				.orElse(null);

		return found;
	}

	private static Map<Long, Company> initMockCompanies() {
		Map<Long, Company> mockCompanies = new HashMap<Long, Company>();

		Company company1 = new Company(1L, "Baza Transilvania", "transilvania@primariacluj.ro", "test");
		Field field1 = new Field(1L, FieldType.Football, "Teren 1", 35, 20);
		field1.id = 20L;
		company1.fields.add(field1);
		mockCompanies.put(company1.id, company1);

		Company company2 = new Company(2L, "Cora", "contact@terencora.ro", "test");
		mockCompanies.put(company2.id, company2);

		return mockCompanies;
	}
}
