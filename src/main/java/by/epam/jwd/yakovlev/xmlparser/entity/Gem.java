package by.epam.jwd.yakovlev.xmlparser.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Gem {

    private String id;
    private String name;
    private Preciousness preciousness;
    private String origin;
    private double value;
    private String color;
    private GregorianCalendar purchaseDate;

    public Gem(String id, String name, Preciousness preciousness, String origin, double value, String color) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.value = value;
        this.color = color;
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

    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
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
                getPreciousness() == gem.getPreciousness() &&
                id.equals(gem.id) &&
                name.equals(gem.name) &&
                origin.equals(gem.origin) &&
                color.equals((gem.color)) &&
                purchaseDate != null &&
                gem.purchaseDate != null &&
                purchaseDate.get(Calendar.YEAR) == gem.purchaseDate.get(Calendar.YEAR) &&
                purchaseDate.get(Calendar.MONTH) == gem.purchaseDate.get(Calendar.MONTH) &&
                purchaseDate.get(Calendar.DAY_OF_MONTH) == gem.purchaseDate.get(Calendar.DAY_OF_MONTH);
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
        if (purchaseDate != null) {
            res = res + prime * purchaseDate.get(Calendar.YEAR);
            res = res + prime * purchaseDate.get(Calendar.MONTH);
            res = res + prime * purchaseDate.get(Calendar.DAY_OF_MONTH);
        }
        return res;
    }
}
