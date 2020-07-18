package lk.kln.ac.RestaurantFinder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RestaurantFinderApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestaurantFinderApplication.class, args);
//		String location="PP,P";
//		System.out.println(location.contains(","));
	}



//	public static void test(){
//		final String API_KEY= "90732112b81ddc58a8be92c9533715bd";
//		String URL_CITY="https://developers.zomato.com/api/v2.1/search?q=london";
////		String URL="https://developers.zomato.com/api/v2.1/locations?query=london";
//
//
//		CloseableHttpClient client= HttpClients.createDefault();
//		HttpGet getRequest=new HttpGet(URL_CITY);
//		getRequest.addHeader("user-key",API_KEY);
//		CloseableHttpResponse response=null;
//		try {
//			response=client.execute(getRequest);
//			HttpEntity entity=response.getEntity();
//			System.out.println(EntityUtils.toString(entity));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
