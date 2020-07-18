var urlCity = "http://localhost:8080/api/restaurant/location=";
var urlCodinate = "http://localhost:8080/api/restaurant/lan=";

var data;
function searchLocation(city){
    if(isNaN(city)){
        if(city.includes(",")){
            var cordinates=city.split(",");
            alert(cordinates[1]);
            getRestaurants(urlCodinate+cordinates[0]+"/lon="+cordinates[1]);
        }else{
            getRestaurants(urlCity+city);
        }
    }else{
        alert("Please insert a location");
    }
}
function getRestaurants(url){
    data=null;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",url,true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState===4 && xmlhttp.status ===200){
            data = JSON.parse(xmlhttp.responseText);
            for(var i=0; i<10;i++){
                var table = document.getElementById("tblRestaurant");
                var row = table.insertRow(i+1);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                cell1.innerHTML =(i+1);
                cell2.innerHTML = data[i];
            }
        }
    };
    xmlhttp.send();
}

function downloadResult(){
    var content=[];
    for(var i=0; i<data.length-1;i++){
        content.push(""+(i+1)+" "+ data[i]);
    }
    var doc = new jsPDF();
    doc.text(10,10,content)
    doc.save('results.pdf')
}