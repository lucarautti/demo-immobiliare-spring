package srl.nexum.demoimmobiliare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "immobili")
public class Immobile {

    @Id
    private UUID id;

    private String indirizzo;
    private int mq;

    public Immobile(){}

    public Immobile (String indirizzo, String mq) {
        this.indirizzo = indirizzo;
        this.mq = mq;
    }

    public String getId() {
        return id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getMq() {
        return mq;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setMq(int mq) {
        this.mq = mq;
    }

    @Override
    public String toString() {
        return "Immobile [id=" +id + ", indirizzo=" + indirizzo + ", mq=" + mq +"]";
    }
}
