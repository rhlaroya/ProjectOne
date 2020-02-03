window.onload = function(){
	let reimb;
	let xmlhttp = new XMLHttpRequest();
	let url = "http://localhost:8080/ERSystem/reimb.json";
	xmlhttp.open("GET", url, true);
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        console.log("JSON DATA FETCHED");
	        reimb = JSON.parse(this.responseText);
	        console.log(reimb.length);
	        console.log(reimb[0][0]);
	        dataAppend(reimb);
	    }
	};
	
	xmlhttp.send();
}
function dataAppend(data){
	console.log(data[0]);

	
	//first loop appends row
	for(let index = 0; index!=data.length; index++){
		let tbl = document.getElementById('tabledata').getElementsByTagName('tbody')[0], // table reference
        row = tbl.insertRow(tbl.rows.length),      // append table row
        i;
		let amount = row.insertCell(0);
		let date = row.insertCell(1);
		let desc =row.insertCell(2);
		let type = row.insertCell(3);
		let status = row.insertCell(4);
	    
	    amount.setAttribute('style','color:white');
	    date.setAttribute('style','color:white');
	    desc.setAttribute('style','color:white');
	    type.setAttribute('style','color:white');
	    status.setAttribute('style','color:white');
	    
	    amount.innerHTML = data[index][1];
	    date.innerHTML = data[index][2];
	    desc.innerHTML = data[index][4];
	    type.innerHTML = data[index][5];
	    status.innerHTML = data[index][6];
	}
}
