package lk.kln.ac.RestaurantFinder.dto;

public class RestaurantDTO {
    private String restaurantName;
    private String address;

    public RestaurantDTO() {
    }

    public RestaurantDTO(String restaurantName, String address) {
        this.restaurantName = restaurantName;
        this.address = address;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
