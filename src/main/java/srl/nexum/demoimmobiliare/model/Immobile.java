package srl.nexum.demoimmobiliare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "immobili")
public class Immobile {

    @Id
    @JsonIgnore
    private String id;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String surname;

    @JsonProperty("indirizzo_completo")
    private String address;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String phone;
    private String latitude;
    private String longitude;
    private int stato;

    @JsonProperty("tipologia")
    private int descrizione_tipologia;

    public Immobile(){}

    public Immobile (String name,
                     String surname,
                     String address,
                     String city,
                     String email,
                     String phone,
                     String latitude,
                     String longitude,
                     int stato,
                     int descrizione_tipologia,
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

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

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

    public int getDescrizione_tipologia() {
        return descrizione_tipologia;
    }

    public void setDescrizione_tipologia(int descrizione_tipologia) {
        this.descrizione_tipologia = descrizione_tipologia;
    }

    @Override
    public String toString() {
        return "Immobile [name=" + name
                + ", surname=" + surname
                + ", address=" + address
                + ", city=" + city
                + ", email=" + email
                + ", phone=" + phone
                + ", latitude=" + latitude
                + ", longitude=" + longitude
                + ", stato=" + stato
                + ", descrizione_tipologia=" + descrizione_tipologia
                +"]";
    }
}
