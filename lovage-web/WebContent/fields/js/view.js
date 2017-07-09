function display(fieldId) {

    $.get({
	url : "http://localhost:8080/lovage-fields-web/fields/" + fieldId,
	success : function(field) {

	    $('#name').text(field.name);
	    $('#companyId').text(field.companyId);
	    $('#type').text(field.type);
	    $('#length').text(field.length);
	    $('#width').text(field.width);
	}
    });
}

display(getQueryParam("id"));