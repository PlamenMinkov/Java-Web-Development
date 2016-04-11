 

var OperationsWithDB = (function()
    {
        function OperationsWithDB(){}
        
        OperationsWithDB.prototype.addOrUpdateGameVote  = function(gameId, value) {
        	var url = "addOrUpdateUserVote.htm";
        	
        	var data = {
                gameId: gameId,
                value: value
            };
                
            var success = function(data){
            	$("#" + gameId + "_vote").html(data);
            };
            
            var error = function(er){
                console.log('error');
            };
            
            var req = ajaxRequester.post(url, data, success, error);
        }
        
        OperationsWithDB.prototype.editGame  = function(gameId, title, description) {
        	var url = "editGame.htm";
        	
        	var data = {
                gameId: gameId,
                title: title,
                description: description
            };
                
            var success = function(data){
            	console.log(data);
            };
            
            var error = function(er){
                console.log('error');
            };
            
            var req = ajaxRequester.post(url, data, success, error);
        }
        
        OperationsWithDB.prototype.deleteGame  = function(gameId) {
        	var url = "deleteGame.htm";
        	
        	var data = {
                gameId: gameId
            };
                
            var success = function(data){
            	$("#" + gameId).parent("div.gameForm").remove();
            };
            
            var error = function(er){
                console.log('error');
            };
            
            var req = ajaxRequester.post(url, data, success, error);
        }
        
        OperationsWithDB.prototype.addPeriod  = function(accountId) {
        	var url = "addActivePeriod.htm";
        	
        	var data = {
        		accountId: accountId
            };
                
            var success = function(data){
            	$("#" + accountId + "_period").html(data);
            };
            
            var error = function(er){
                console.log('error');
            };
            
            var req = ajaxRequester.post(url, data, success, error);
        }
        
        return OperationsWithDB;
    }());
var operationsWithDB = new OperationsWithDB();