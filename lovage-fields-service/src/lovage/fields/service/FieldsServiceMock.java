package lovage.fields.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lovage.domain.Field;
import lovage.domain.FieldType;
import lovage.utils.KeyUtils;

public class FieldsServiceMock implements IFieldsService {

	private static final Map<Long, Field> fields = initMockFields();

	@Override
	public Field getField(Long id) {
		Field field = fields.get(id);
		return field;
	}

	@Override
	public List<Field> getMinFields() {
		List<Field> result = new ArrayList<Field>();
		for (Entry<Long, Field> entry : fields.entrySet()) {

			Field copy = new Field();
			copy.id = entry.getValue().id;
			copy.companyId = entry.getValue().companyId;
			copy.type = entry.getValue().type;
			copy.name = entry.getValue().name;
			copy.length = entry.getValue().length;
			copy.width = entry.getValue().width;

			result.add(copy);
		}

		return result;
	}

	@Override
	public boolean create(Field field) {
		if (field == null) {
			return false;
		}

		if (field.id == null) {
			field.id = KeyUtils.nextLong(fields.keySet());
		}

		fields.put(field.id, field);

		return true;
	}

	@Override
	public boolean validate(Field field) {

		if (field.companyId == null) {
			System.out.println(String.format("Field company id is empty. Make sure the field company id is filled."));
			return false;
		}

		return true;
	}

	private static Map<Long, Field> initMockFields() {
		Map<Long, Field> mockFields = new HashMap<Long, Field>();

		Field field1 = new Field(1L, FieldType.Football, "Teren 1", 35, 20);
		field1.id = 20L;
		mockFields.put(field1.id, field1);

		Field field2 = new Field(1L, FieldType.Football, "Teren fotbal", 37, 19);
		field2.id = 21L;
		mockFields.put(field2.id, field2);

		return mockFields;
	}
}
