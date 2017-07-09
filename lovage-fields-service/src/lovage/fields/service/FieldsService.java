package lovage.fields.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import lovage.domain.Field;

@Stateless
public class FieldsService implements IFieldsService {

	@PostConstruct
	public void init() {
		System.out.println("Started FieldsService implementation for IFieldsService.");
	}

	@Override
	public List<Field> getMinFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field getField(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Field field) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(Field field) {
		// TODO Auto-generated method stub
		return false;
	}
}
