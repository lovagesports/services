function display(playerId) {

    $.get({
	url : "http://localhost:8080/lovage-players-web/players/" + playerId,
	success : function(player) {

	    $('#name').text(player.name);
	    $('#email').text(player.email);
	    $('#birth').text(player.birth);
	}
    });
}

display(getQueryParam("id"));