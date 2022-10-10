package Exercise_06_AdvertisementMessage_01;

public class AdvertisementMessage {
    String phrases;
    String events;
    String authors;
    String cities;

    public AdvertisementMessage(String phrases, String events, String authors, String cities) {
        this.phrases = phrases;
        this.events = events;
        this.authors = authors;
        this.cities = cities;
    }

    public String getPhrases() {
        return phrases;
    }

    public String getEvents() {
        return events;
    }

    public String getAuthors() {
        return authors;
    }

    public String getCities() {
        return cities;
    }

}
