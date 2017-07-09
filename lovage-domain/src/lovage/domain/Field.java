package lovage.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Field {

	public Long id;
	public String name;
	public Long companyId;
	public FieldType type;
	public Integer length;
	public Integer width;

	public Field() {
	}

	public Field(Long companyId, FieldType type, String name, Integer length, Integer width) {
		this.companyId = companyId;
		this.type = type;
		this.name = name;
		this.length = length;
		this.width = width;
	}
}