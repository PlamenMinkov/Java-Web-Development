function isLogged(condition) {
	if(condition) {
		$("#login").hide();
		$("#registration").hide();
	}
	else {
		$("#logout").hide();
		$("#ownGames").hide();
		$("#profile").hide();
	}
}