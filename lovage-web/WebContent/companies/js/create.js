function createCompany() {

    var name = $('#name').val();
    var email = $('#email').val();
    var password = $('#password').val();

    var company = {
	"name" : name,
	"email" : email,
	"password" : password,
    };

    $.post({
	url : "http://localhost:8080/lovage-companies-web/companies/",
	data : JSON.stringify(company),
	contentType : "application/json",
	success : function(result) {
	    window.location.href = '../index.html';
	}
    });
}