package resources;

public enum APIResource {
    AddPlaceApiResource("/maps/api/place/add/json"),
    GetPlaceApiResource("/maps/api/place/get/json"),
    DeletePlaceResource("/maps/api/place/delete/json");
    private String resource;

    APIResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
