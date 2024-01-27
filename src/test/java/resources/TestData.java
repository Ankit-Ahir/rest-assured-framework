package resources;

import pojo_classes.AddPlace;
import pojo_classes.Location;

import java.util.ArrayList;

public class TestData {

    public AddPlace getAddPlacePayload(String name, String language, String address) {
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setName(name);
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress(address);
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage(language);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("shoe park");
        arrayList.add("shop");
        addPlace.setTypes(arrayList);
        return addPlace;
    }

    public String getDeletePlacePayload(String placeId) {
        return "{\n" +
                "    \"place_id\":\"" + placeId + "\"\n" +
                "}\n";
    }
}
