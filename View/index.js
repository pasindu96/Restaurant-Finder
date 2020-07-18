var baseurl = "http://localhost:8080/api/restaurant/location=london";
function searchLocation(){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurl,true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState===4 && xmlhttp.status ===200){
            var data = JSON.parse(xmlhttp.responseText);
            alert(data);
        }
    };
    xmlhttp.send();
}
