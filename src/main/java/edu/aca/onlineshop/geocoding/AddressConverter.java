package edu.aca.onlineshop.geocoding;

import edu.aca.onlineshop.delivery.cluster.Address;
import edu.aca.onlineshop.json.JSONReader;

/**
 *
 */
public class AddressConverter{
    
    public static Address convertToCoordinates(int buildingNumber, String street, String city, String country){
        String url = createURL(buildingNumber, street, city, country);
        try{
            String json = JSONReader.readUrl(url);
            return JSONReader.extractGeocode(json);
        }
        catch(Exception e){
            e.printStackTrace();
            //idk what to do with this right now
            return null;
        }
    }
    
    
    public static String createURL(int buildingNumber, String street, String city, String country){
        StringBuilder url = new StringBuilder();
        url.append("https://maps.googleapis.com/maps/api/geocode/json?address=");
        url.append(buildingNumber + '+');
        String[] streetArr = street.split(" ");
        for(String s : streetArr){
            url.append(s + '+');
        }
        String[] cityArr = city.split(" ");
        for(String s : cityArr){
            url.append(s + '+');
        }
        url.append(country + "&key=AIzaSyABmoN9gxdn5u7uXeV8RiKuz5mR9Grjw4c");
        return url.toString();
    }
}
