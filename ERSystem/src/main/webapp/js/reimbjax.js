/**
 * 
 */

function getPk(){
    const pkId = document.getElementById('pkid').value;
    /* 
        what is ajax?
            Asynchronous Javascript and xml
        There are 4 to implementing ajax
    */

    /* 
        step 1
            the following object allows us to make requests over
                http and get data back. This is our data retriever.
    */
   const xhr = new XMLHttpRequest();

   //step 2, add an event listener
   xhr.onreadystatechange = function (){
        // console.log('the ready state has changed');

        if(xhr.readyState===4 && xhr.status===200){
            // console.log('we are ready');

            /* 
             what is the ready state?
                 the state of the request
            status code
                http status code, the condition of the response
            
            status codes:
                100 = informational
                200 = ok
                300 = redirect
                400 = client side error
                500 = server side error
            
            ready state:
                0 = request has not been initialized
                1 = server connection has been established
                2 = request received
                3 = processing request
                4 = request has finished and the response is ready
                */
                const pk = JSON.parse(xhr.responseText);
                // console.log(pk);
                implant(pk);
            }


   }

   /* 
    step 3
        create a connection
            open(httpMethod, url)
            open(httpMethod, url, async (true by default))
   */
  xhr.open('GET', 'http://pokeapi.co/api/v2/pokemon/'+pkId);

  /* 
   step 4
    send the request to retrieve information
  */
 xhr.send();
}

document.getElementById('pksubmit').addEventListener('click',getpkBetter);


function implant(json){
    document.getElementById('pkinfo').innerHTML=json.name;
}

function getpk2(){
    const pkId = document.getElementById('pkid').value;
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function (){
        if(xhr.readyState===4&&xhr.status===200){
            implant(Json.parse(xhr.responseText));
        }
    }
    xhr.open('GET', 'http://pokeapi.co/api/v2/pokemon/'+pkId);
    xhr.send();
}

//fetch api
function getpkBetter(){
    const pkId = document.getElementById('pkid').value;
    fetch('http://localhost:8080/ERSystem/building.json?id='+pkId)
        .then(response=> response.json())
        .then(json=>implant(json));
}

function putBuilding(){
    fetch('http://localhost:9090/ArchitectProject/create.json',{
        method: 'put',
        body: `
    {"id":1,"name":"hey arnold","owner":3}
    `,
    }).then(r=>console.log(r));
}