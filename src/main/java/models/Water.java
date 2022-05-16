package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * <h2>Water class</h2>
 *
 * @see XmlAccessorType
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Water extends FossilProduct {
    private int cleanliness;

    /**
     * Default constructor
     * It's used for JAXB
     *
     * @see javax.xml.bind.JAXB
     */
    public Water() {
    }

    /**
     * Constructor
     * @param name name of the water
     * @param liter liter of the water
     * @param literprice liter price of the water
     * @param cleanliness cleanliness of the water
     */
    public Water(String name, int liter, int literprice, int cleanliness) {
        super(name, liter, literprice);
        this.cleanliness = cleanliness;
    }

    /**
     * Getter for cleanliness
     * @return cleanliness
     */
    public int getCleanliness() {
        return cleanliness;
    }

    /**
     * Create a String representation of Water
     * @return String representation of Water
     */
    @Override
    public String toString() {
        return super.toString() + " - " + this.cleanliness;
    }
}

