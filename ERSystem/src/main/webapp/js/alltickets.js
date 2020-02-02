window.onload = function(){
	var reimb;
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8080/ERSystem/reimball.json";
	xmlhttp.open("GET", url, true);
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        console.log("JSON DATA FETCHED");
	        reimb = JSON.parse(this.responseText);
	        console.log(reimb.length);
	        dataAppend(reimb);
	    }
	};
	
	xmlhttp.send();
	
	
	
}
function dataAppend(data){
	console.log(data[0]);

	
	//first loop appends row
	for(var index = 0; index!=data.length; index++){
	    var tbl = document.getElementById('tabledata').getElementsByTagName('tbody')[0], // table reference
        row = tbl.insertRow(tbl.rows.length),      // append table row
        i;
        var id = row.insertCell(0);
	    var amount = row.insertCell(1);
        var datesub = row.insertCell(2);
        var dateres = row.insertCell(3);
        var desc = row.insertCell(4);
        var auth = row.insertCell(5);
        var res = row.insertCell(6)
	    var type = row.insertCell(7);
		var status = row.insertCell(8);
		var butt = row.insertCell(9);
    
	    id.setAttribute('style','color:white');
	    amount.setAttribute('style','color:white');
        datesub.setAttribute('style','color:white');
        dateres.setAttribute('style','color:white');
        desc.setAttribute('style','color:white');
        auth.setAttribute('style','color:white');
        res.setAttribute('style','color:white');
	    type.setAttribute('style','color:white')
	    status.setAttribute('style','color:white');
        
        id.innerHTML = data[index].id;
        amount.innerHTML = data[index].amount;
        datesub.innerHTML = data[index].submitted;
        dateres.innerHTML = data[index].resolved;
        desc.innerHTML = data[index].description;
        auth.innerHTML = data[index].author;
        res.innerHTML = data[index].resolver;
	    type.innerHTML = data[index].type_id;
		status.innerHTML = data[index].status_id;


		butt.innerHTML = "<div id='buttones'><input class='btn btn-success' type='submit' value='Approve' onClick='approve("+data[index].id+")'><input class='btn btn-danger' type='submit' value='Deny' onClick='deny("+data[index].id+")'></div>";


	}		
}

function approve(id){
    var formData = new FormData(); 
    formData.append("id",id);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("post", "/ERSystem/ApproveReimb");
    xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState > 3 && xmlHttp.status === 200)
            {
                alert("Data saved");
                alert(xmlHttp.responseText);                        
            }
        }; 
   
   xmlHttp.send(formData);
   alert("Data approved!");
   return false;
}

function deny(id){
	var formData = new FormData(); 
	formData.append("id",id);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("post", "/ERSystem/DenyReimb");
    xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState > 3 && xmlHttp.status === 200)
            {
                alert("Data saved");
                alert(xmlHttp.responseText);                        
            }
        }; 
   
   xmlHttp.send(formData);
   alert("Data denied");
 
   return false;
}

function test(){
	alert('hi');
}

sortType() => {
	
}
