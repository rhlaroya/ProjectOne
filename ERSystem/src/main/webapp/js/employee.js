window.onload = function(){
	let xmlhttp = new XMLHttpRequest();
	let url = "http://localhost:8080/ERSystem/html/reimb.json";
	xmlhttp.open("GET", url, true);
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        console.log("JSON DATA FETCHED");
	    }
	};
	
	xmlhttp.send();
	
	
}