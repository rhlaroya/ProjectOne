window.onload = function(){
	var reimb;
	var xmlhttp = new XMLHttpRequest();
	var url = "http://localhost:8080/ERSystem/reimb.json";
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
	    var amount = row.insertCell(0);
	    var date = row.insertCell(1);
	    var desc =row.insertCell(2);
	    var type = row.insertCell(3);
	    var status = row.insertCell(4);
	    
	    amount.setAttribute('style','color:white');
	    date.setAttribute('style','color:white');
	    desc.setAttribute('style','color:white');
	    type.setAttribute('style','color:white');
	    status.setAttribute('style','color:white');
	    
	    amount.innerHTML = data[index].amount;
	    date.innerHTML = data[index].submitted;
	    desc.innerHTML = data[index].description;
	    type.innerHTML = data[index].type_id;
	    status.innerHTML = data[index].status_id;

	}
}
