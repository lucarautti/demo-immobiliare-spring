package srl.nexum.demoimmobiliare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "immobili")
public class Immobile {

    @Id
    private UUID _id;

    private String indirizzo;
    private String mq;

    public Immobile(){}

    public Immobile (String indirizzo, String mq) {
        this.indirizzo = indirizzo;
        this.mq = mq;
    }

    public UUID getId() {
        return _id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getMq() {
        return mq;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setMq(String mq) {
        this.mq = mq;
    }

    @Override
    public String toString() {
        return "Immobile [id=" +_id + ", indirizzo=" + indirizzo + ", mq=" + mq +"]";
    }
}
