package srl.nexum.demoimmobiliare.model;

public class ImmobileQuotation {

    private double cprMin;
    private double cprMax;

    public ImmobileQuotation() {

    };

    public ImmobileQuotation (double cprMin, double cprMax) {
        this.cprMax = cprMax;
        this.cprMin = cprMin;
    }

    public double getCprMin() {
        return cprMin;
    }

    public void setCprMin(double cprMin) {
        this.cprMin = cprMin;
    }

    public double getCprMax() {
        return cprMax;
    }

    public void setCprMax(double cprMax) {
        this.cprMax = cprMax;
    }

    @Override
    public String toString() {
        return "ImmobileQuotation [cprMin="+cprMin+", cprMax="+cprMax+"]";
    }
}
