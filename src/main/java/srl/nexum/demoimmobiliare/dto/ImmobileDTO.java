package srl.nexum.demoimmobiliare.dto;

public class ImmobileDTO {

    private String name;
    private String surname;
    private String address;
    private String city;
    private String email;
    private String phone;
    private String latitude;
    private String longitude;
    private String stato;
    private String descrizione_tipologia;
    private String fascia;

    public String getName() {
        return name;
    }

    public String getSurname() {return surname; }

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getLatitude() { return latitude; }

    public String getLongitude() { return longitude; }

    public String getStato() { return stato; }

    public String getDescrizione_tipologia() { return descrizione_tipologia; }

    public String getFascia() { return fascia; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) { this.surname = surname; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) { this.phone = phone; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

    public void setStato(String stato) { this.stato = stato; }

    public void setDescrizione_tipologia(String descrizione_tipologia) {
        this.descrizione_tipologia = descrizione_tipologia; }

    public void setFascia(String fascia) { this.fascia = fascia; }
}
