package srl.nexum.demoimmobiliare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "immobili")
public class Immobile {

    @Id
    private String id;

    private String indirizzo;
    private String mq;

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
        return "Immobile [id=" +id + ", indirizzo=" + indirizzo + ", mq=" + mq +"]";
    }
}
