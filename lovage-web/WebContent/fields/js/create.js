function create() {

    var name = $('#name').val();
    var type = $('#type').val();
    var length = $('#length').val();
    var width = $('#width').val();
    var companyId = $('#companyId').val();

    var field = {
	"name" : name,
	"companyId" : companyId,
	"type" : type,
	"length" : length,
	"width" : width
    };

    var url = "http://localhost:8080/lovage-companies-web/companies/"
	    + companyId + "/add";

    $.post({
	url : url,
	data : JSON.stringify(field),
	contentType : "application/json",
	success : function(result) {
	    window.location.href = '../index.html';
	}
    });
}
