package by.epam.jwd.yakovlev.xmlparser.entity;

import java.util.Objects;

public class Gem {

    private Preciousness preciousness;
    private String id;
    private String name;
    private String origin;
    private double value;
    private String color;
    private int translucence;

    public Gem(Preciousness preciousness, String id, String name, String origin, double value, String color, int translucence) {
        this.preciousness = preciousness;
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.value = value;
        this.color = color;
        this.translucence = translucence;
    }

    public Gem() {
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTranslucence() {
        return translucence;
    }

    public void setTranslucence(int translucence) {
        this.translucence = translucence;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Gem gem = (Gem) o;

        return Double.compare(gem.getValue(), getValue()) == 0 &&
                getTranslucence() == gem.getTranslucence() &&
                getPreciousness() == gem.getPreciousness() &&
                Objects.equals(getId(), gem.getId()) &&
                Objects.equals(getName(), gem.getName()) &&
                Objects.equals(getOrigin(), gem.getOrigin()) &&
                Objects.equals(getColor(), gem.getColor());
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res + prime * (preciousness == null ? 0 : preciousness.hashCode());
        res = res + prime * (id == null ? 0 : id.hashCode());
        res = res + prime * (name == null ? 0 : name.hashCode());
        res = res + prime * (origin == null ? 0 : origin.hashCode());
        res = res + prime * Double.hashCode(value);
        res = res + prime * (color == null ? 0 : color.hashCode());
        res = res + prime * translucence;

        return res;
    }
}
