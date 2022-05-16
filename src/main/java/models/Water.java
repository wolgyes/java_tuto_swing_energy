package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Water extends FossilProduct {
    private int cleanliness;

    public Water() {
    }

    public Water(String name, int liter, int literprice, int cleanliness) {
        super(name, liter, literprice);
        this.cleanliness = cleanliness;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.cleanliness;
    }
}

