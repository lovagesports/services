function login() {

    var email = $('#email').val();
    var password = $('#password').val();

    var login = {
	"email" : email,
	"password" : password
    };

    $
	    .post({
		url : "http://localhost:8080/lovage-players-web/players/login",
		data : JSON.stringify(login),
		contentType : "application/json",
		success : function(result) {
		    if (result != null) {
			sessionStorage.setItem("login", result.id + "#"
				+ result.email);
			window.location.href = 'index.html';
		    } else {

			$
				.post({
				    url : "http://localhost:8080/lovage-companies-web/companies/login",
				    data : JSON.stringify(login),
				    contentType : "application/json",
				    success : function(result) {
					if (result != null) {
					    sessionStorage.setItem("login",
						    result.id + "#"
							    + result.email);
					    window.location.href = 'index.html';
					} else {
					    $("#message").show();
					}
				    }
				});

		    }
		}
	    });
}