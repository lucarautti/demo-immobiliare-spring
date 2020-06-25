package srl.nexum.demoimmobiliare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "immobili")
public class Immobile {

    @Id
    private String id;

    private String name;
    private String surname;
    private String address;
    private String city;
    private String email;
    private String phone;
    private String latitude;
    private String longitude;

    @JsonProperty("status")
    private String stato;

    @JsonProperty("description_type")
    private String descrizione_tipologia;

    @JsonProperty("band")
    private String fascia;

    public Immobile(){}

    public Immobile (String name,
                     String surname,
                     String address,
                     String city,
                     String email,
                     String phone,
                     String latitude,
                     String longitude,
                     String stato,
                     String descrizione_tipologia,
                     String fascia
                     ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stato = stato;
        this.descrizione_tipologia = descrizione_tipologia;
        this.fascia = fascia;
    }

    public String getId(){ return id;}

    public String getName() {
        return name;
    }

    public String getSurname() { return surname; }

    public String getAddress() { return address;}

    public String getCity() { return city;}

    public String getEmail() { return email;}

    public String getPhone() {
        return phone;
    }

    public String getLatitude() { return latitude; }

    public String getLongitude() { return longitude; }

    public String getStato() { return stato; }

    public String getDescrizione_tipologia() { return descrizione_tipologia; }

    public String getFascia() { return fascia; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) { this.surname = surname; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setEmail(String email) { this.email = email;}

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

    public void setStato(String stato) { this.stato = stato; }

    public void setDescrizione_tipologia(String descrizione_tipologia) {
        this.descrizione_tipologia = descrizione_tipologia;
    }

    public void setFascia(String fascia) { this.fascia = fascia; }

    @Override
    public String toString() {
        return "Immobile [name=" + name
                + ", surname=" + surname
                + ", address=" + address
                + ", city=" + city
                + "email=" + email
                + ", phone=" + phone
                + ", latitude=" + latitude
                + ", longitude=" + longitude
                + ", stato=" + stato
                + ", descrizione_tipologia=" + descrizione_tipologia
                + ", fascia=" + fascia
                +"]";
    }
}
