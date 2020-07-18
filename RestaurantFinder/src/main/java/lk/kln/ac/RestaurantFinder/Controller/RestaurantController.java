package lk.kln.ac.RestaurantFinder.Controller;

import lk.kln.ac.RestaurantFinder.Service.RestaurantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/restaurant")
public class RestaurantController {

    private final String API_KEY= "90732112b81ddc58a8be92c9533715bd";
    private String URL="https://developers.zomato.com/api/v2.1/search?q=";
    private RestaurantService service=new RestaurantService();

    @RequestMapping(value="/{location}")
    public List<String> getRestaurantByCity(@PathVariable("location") String location){
            return service.searchRestaurant(location.replace("location=",""));
    }

    @GetMapping(value="/{lan}/{lon}",consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getRestaurantByCordinates(@PathVariable("lan") String lan,@PathVariable("lon") String lon){
            return service.searchRestaurant(lan.replace("lan=",""),lon.replace("lon=",""));
    }
}
