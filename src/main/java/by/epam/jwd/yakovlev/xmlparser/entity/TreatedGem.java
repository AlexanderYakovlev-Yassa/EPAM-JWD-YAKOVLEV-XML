package by.epam.jwd.yakovlev.xmlparser.entity;

import java.util.Objects;

public class TreatedGem extends Gem{

    double translucency;
    int facetsCount;

    public TreatedGem(Preciousness preciousness, String id, String name, String origin, double value, String color, double translucency, int facetsCount) {
        super(id, name, preciousness, origin, value, color);
        this.facetsCount = facetsCount;
        this.translucency = translucency;
    }

    public TreatedGem(int facetsCount) {
        this.facetsCount = facetsCount;
    }

    public TreatedGem() {
    }

    public int getFacetsCount() {
        return facetsCount;
    }

    public void setFacetsCount(int facetsCount) {
        this.facetsCount = facetsCount;
    }

    public double getTranslucency() {
        return translucency;
    }

    public void setTranslucency(double translucency) {
        this.translucency = translucency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        TreatedGem that = (TreatedGem) o;

        return getFacetsCount() == that.getFacetsCount() &&
                getTranslucency() == that.getTranslucency();
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res + prime * super.hashCode();
        res = res + prime * facetsCount;
        res = res + prime * Double.valueOf(translucency).hashCode();

        return res;
    }
}
