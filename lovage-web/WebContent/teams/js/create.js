function createTeam() {

	var name = $('#name').val();
	var capacity = $('#capacity').val();
	var location = $('#location').val();
	var start = $('#start').val();
	var duration = $('#duration').val();

	var team = {
		"name" : name,
		"capacity" : capacity,
		"location" : location,
		"start" : start,
		"duration" : duration
	};

	$.post({
		url : "http://localhost:8080/lovage-teams-web/teams/",
		data : JSON.stringify(team),
		contentType : "application/json",
		success : function(result) {
			window.location.href = '../index.html';
		}
	});
}