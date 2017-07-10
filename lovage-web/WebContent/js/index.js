function forceLogin() {
    sessionStorage.removeItem("login");
    window.location.replace("login.html");
}

function tryLogin() {

}

function checkLogin() {
    var login = sessionStorage.getItem("login");

    if (login == null) {
	forceLogin();
    } else {
	var loggedIn = tryLogin(login);
	if (loggedIn == null) {
	    forceLogin();
	} else {
	    // TODO: redirect to correct index
	}
    }
}

function initialize() {
    checkLogin();
}

initialize();
