function createPlayer() {

    var name = $('#name').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var birth = $('#birth').val();

    var player = {
	"name" : name,
	"email" : email,
	"password" : password,
	"birth" : birth
    };

    $.post({
	url : "http://localhost:8080/lovage-players-web/players/",
	data : JSON.stringify(player),
	contentType : "application/json",
	success : function(result) {
	    window.location.href = '../index.html';
	}
    });
}