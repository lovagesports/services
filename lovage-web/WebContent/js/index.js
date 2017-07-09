var selectedPlayer = null;
var players = null;

var selectedTeam = null;
var teams = null;

var selectedCompany = null;
var companies = null;

function findPlayerLocal(id, players) {
    if (players != null) {
	var arr = $.grep(players, function(a) {
	    return a.id == id;
	});

	var identifiedPlayer = arr[0];
	return identifiedPlayer;
    }
    return null;
}

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

function findCompany(id, companies) {
    if (companies != null) {
	var arr = $.grep(companies, function(a) {
	    return a.id == id;
	});

	var identifiedCompany = arr[0];
	return identifiedCompany;
    }
    return null;
}

function selectPlayer(id) {
    selectedPlayer = findPlayerLocal(id, players);
    $('#selectedPlayerContent').text('Selected player: ' + selectedPlayer.name);
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

function displayPlayers(players) {
    $("#playersContent").html('');
    players.forEach(displayPlayer);
}

function displayPlayer(item, index) {
    h1 = $("<h1></h1>").text(item.name);
    a1 = $("<a href='player.html?playerid=" + item.id + "'></a>").append(h1);
    a2 = $("<a href='#' onclick='selectPlayer(" + item.id + ");'>Select</a>")
    article = $("<article></article>").append(a1, a2);

    $("#playersContent").append(article);
}

function displayCompanies(companies) {
    $("#companiesSelect").html('<select></select>');
    companies.forEach(displayCompanyOption);
    $("#companiesSelect select").change(
	    function() {
		var selectedCompanyId = $(
			"#companiesSelect select option:selected").val();
		selectedCompany = findCompany(selectedCompanyId, companies);
		displayCompany(selectedCompany, $("#companiesContent"));
	    });
}

function displayCompanyOption(item, index) {
    var option = $("<option></option>").val(item.id).append(item.name);
    $("#companiesSelect select").append(option);
}

function displayCompany(company, content) {
    content.html('');
    var article = $("<article></article>");
    content.append(article);

    h1 = $("<h1></h1>").text(company.name);
    article.append(h1);

    company.fields
	    .forEach(function(field, index) {
		p6 = $("<p><a href='http://localhost:8080/lovage-web/fields/view.html?id="
			+ field.id + "'>" + field.name + "</a></p>");
		article.append(p6);
	    });
}

function addSelectedPlayerToSelectedTeam() {

    $.post({
	url : "http://localhost:8080/lovage-teams-web/teams/" + selectedTeam.id
		+ "/add",
	data : JSON.stringify(selectedPlayer),
	contentType : "application/json; charset=utf-8",
	success : function(result) {

	    if (result === true) {
		selectedTeam.players.push(selectedPlayer);
		displayTeams(teams);
	    }
	}
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

    var playersLoaded = $.get({
	url : "http://localhost:8080/lovage-players-web/players/",
	success : function(result) {
	    players = result;
	    displayPlayers(players);
	}
    });

    var companiesLoaded = $.get({
	url : "http://localhost:8080/lovage-companies-web/companies/",
	success : function(result) {
	    companies = result;
	    displayCompanies(companies);
	}
    });

    $.when(teamsLoaded, playersLoaded, companiesLoaded).done(
	    function(resultTeamsLoaded, resultPlayersLoaded,
		    resultCompaniesLoaded) {

		checkLogin();
	    });

    $("#menuLogout td a").click(function() {
	$("#menuLogin").show();
	$("#menuLogout").hide();
	sessionStorage.removeItem("login");
    });
}

initialize();
