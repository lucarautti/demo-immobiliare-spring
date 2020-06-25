package srl.nexum.demoimmobiliare.dto;

public class ImmobileQuotationDTO {

    private String cprMin;
    private String cprMax;

    public String getCprMin() {
        return cprMin;
    }

    public void setCprMin(String cprMin) {
        this.cprMin = cprMin;
    }

    public String getCprMax() {
        return cprMax;
    }

    public void setCprMax(String cprMax) {
        this.cprMax = cprMax;
    }

    @Override
    public String toString() {
        return "ImmobileQuotationDTO{" +
                "cprMin='" + cprMin + '\'' +
                ", cprMax='" + cprMax + '\'' +
                '}';
    }
}
