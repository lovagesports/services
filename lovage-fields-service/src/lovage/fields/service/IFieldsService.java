package lovage.fields.service;

import java.util.List;

import lovage.domain.Field;

public interface IFieldsService {

	List<Field> getMinFields();
	Field getField(Long id);
	boolean create(Field field);
	boolean validate(Field field);
}
