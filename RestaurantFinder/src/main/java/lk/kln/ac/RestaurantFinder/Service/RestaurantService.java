package lk.kln.ac.RestaurantFinder.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lk.kln.ac.RestaurantFinder.dto.RestaurantDTO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestaurantService {
    private final String API_KEY= "90732112b81ddc58a8be92c9533715bd";
    List<String> restaurantNames=new ArrayList<>();

    public List<String> searchRestaurant(String location){
        String URL="https://developers.zomato.com/api/v2.1/search?q=";
        return getHTTPRequest(URL+location);
    }

    public List<String> searchRestaurant(String lat, String lon){
        String URL="https://developers.zomato.com/api/v2.1/search?lat=";
        return getHTTPRequest(URL+lat+"&lon="+lon);
    }

    public List<String> getHTTPRequest(String url){

        CloseableHttpClient client= HttpClients.createDefault();
        HttpGet getRequest=new HttpGet(url);
        getRequest.addHeader("user-key",API_KEY);

        CloseableHttpResponse response=null;
        try {
            response=client.execute(getRequest);
            HttpEntity entity=response.getEntity();

            Pattern p = Pattern.compile("[n][a][m][e][\"][:][\"][a-z A-Z - ']{0,}");
            Matcher m = p.matcher(EntityUtils.toString(entity));
            while(m.find()) {
                restaurantNames.add(m.group(0).replace("name\":\"",""));
                //System.out.println(m.group(0).replace("name\":\"",""));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return restaurantNames;
    }
}
