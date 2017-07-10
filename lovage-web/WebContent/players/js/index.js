var selectedPlayer = null;
var players = null;

function findTeam(id, callback) {
    $.get({
	url : "http://localhost:8080/lovage-teams-web/teams/" + id,
	success : function(team) {
	    callback(team);
	},
	fail : function(team) {
	    callback(null);
	}
    });
}

function findTeamLocal(id, teams) {
    if (teams != null) {
	var arr = $.grep(teams, function(a) {
	    return a.id == id;
	});

	var identifiedTeam = arr[0];
	return identifiedTeam;
    }
    return null;
}

function displayTeams(teams) {
    $("#teamsSelect").html('<select></select>');
    teams.forEach(displayTeamOption);
    $("#teamsSelect select").change(function() {
	var selectedTeamId = $("#teamsSelect select option:selected").val();
	findTeam(selectedTeamId, function(result) {
	    if (result == null) {
		// no team found
	    } else {
		selectedTeam = result;
		displayTeam(selectedTeam, $("#teamsContent"));
	    }
	});
    });
    $("#teamsSelect select").change();
}

function displayTeamOption(item, index) {
    var option = $("<option></option>").val(item.id).append(item.name);
    $("#teamsSelect select").append(option);
}

function displayTeam(team, content) {
    content.html('');
    var article = $("<article></article>");
    content.append(article);

    h1 = $("<h1></h1>").text(team.name);
    article.append(h1);

    p2 = $("<p></p>").text("Location: " + team.location);
    article.append(p2);

    p3 = $("<p></p>").text("Free spots: " + (team.capacity - team.joined));
    article.append(p3);

    p1 = $("<p></p>").text("From: " + team.start);
    article.append(p1);

    p4 = $("<p></p>").text("Duration: " + team.duration + " hours");
    article.append(p4);

    p5 = $("<p></p>").text("Players");
    article.append(p5);

    team.players
	    .forEach(function(player, index) {
		p6 = $("<p><a href='http://localhost:8080/lovage-web/players/view.html?id="
			+ player.id + "'>" + player.name + "</a></p>");
		article.append(p6);
	    });
}

function checkLogin() {
    var login = sessionStorage.getItem("login");

    if (login == null) {
	$("#menuLogin").show();
	$("#menuLogout").hide();
	sessionStorage.removeItem("login");
    } else {
	var loginParts = login.split("#");
	if (loginParts.length !== 2) {
	    $("#menuLogin").show();
	    $("#menuLogout").hide();
	    sessionStorage.removeItem("login");
	} else {
	    var id = loginParts[0];
	    var email = loginParts[1];

	    if (id == null || email == null) {
		$("#menuLogin").show();
		$("#menuLogout").hide();
		sessionStorage.removeItem("login");
	    } else {
		var loggedIn = findPlayerLocal(id, players);
		if (loggedIn == null) {
		    loggedIn = findCompany(id, companies);
		}
		if (loggedIn == null) {
		    $("#menuLogin").show();
		    $("#menuLogout").hide();
		    sessionStorage.removeItem("login");
		} else {
		    $("#menuLogin").hide();
		    $("#menuLogout").show();
		    $("#menuLogout td label").text(loggedIn.name);
		}
	    }
	}
    }
}

function initialize() {

    var teamsLoaded = $.get({
	url : "http://localhost:8080/lovage-teams-web/teams/",
	success : function(result) {
	    teams = result;
	    displayTeams(teams);
	}
    });

    $.when(teamsLoaded).done(function(resultTeamsLoaded) {

    });

    checkLogin();

    $("#menuLogout td a").click(function() {
	sessionStorage.removeItem("login");
	window.location.replace("../login.html");
    });
}

initialize();
