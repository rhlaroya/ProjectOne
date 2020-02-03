var sort = 0;
window.onload = function(){
	let reimb;
	let xmlhttp = new XMLHttpRequest();
	let url = "http://localhost:8080/ERSystem/reimball.json";
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
	for(let index = 0; index!=data.length; index++){
		let tbl = document.getElementById('tabledata').getElementsByTagName('tbody')[0], // table reference
        row = tbl.insertRow(tbl.rows.length),      // append table row
        i;
		let id = row.insertCell(0);
		let amount = row.insertCell(1);
		let datesub = row.insertCell(2);
		let dateres = row.insertCell(3);
		let desc = row.insertCell(4);
		let auth = row.insertCell(5);
		let res = row.insertCell(6)
	    let type = row.insertCell(7);
		let status = row.insertCell(8);
		let butt = row.insertCell(9);

	    id.setAttribute('style','color:white');
	    amount.setAttribute('style','color:white');
        datesub.setAttribute('style','color:white');
        dateres.setAttribute('style','color:white');
        desc.setAttribute('style','color:white');
        auth.setAttribute('style','color:white');
        res.setAttribute('style','color:white');
	    type.setAttribute('style','color:white')
	    status.setAttribute('style','color:white');
        
        id.innerHTML = data[index][0];
        amount.innerHTML = data[index][1];
        datesub.innerHTML = data[index][2];
        dateres.innerHTML = data[index][3];
        desc.innerHTML = data[index][4];
        auth.innerHTML = data[index][7];
        res.innerHTML = data[index][8];
	    type.innerHTML = data[index][5];
		status.innerHTML = data[index][6];


		butt.innerHTML = "<div id='buttones"+data[index][0]+"'><input class='btn btn-success' type='submit' value='Approve' onClick='approve("+data[index][0]+")'><input class='btn btn-danger' type='submit' value='Deny' onClick='deny("+data[index][0]+")'></div>";

	}		
}

function approve(id){
	let formData = new FormData(); 
    formData.append("id",id);
    let xmlHttp = new XMLHttpRequest();
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
	let formData = new FormData(); 
	formData.append("id",id);
	let xmlHttp = new XMLHttpRequest();
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

//
//sortType() => {
//	
//}
