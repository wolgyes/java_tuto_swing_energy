package models;

import enums.OilType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Oil class
 *
 * @see XmlAccessorType
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Oil extends FossilProduct {
    /**
     * Type of the oil!
     *
     * @see OilType
     */
    OilType oilType;

    /**
     * Default constructor
     * It's used by JAXB
     *
     * @see javax.xml.bind.JAXB
     */
    public Oil() {
    }

    /**
     * Constructor
     * @param type Oil type
     * @param liter Price per liter
     * @param literpirce Price per liter
     * @param oilType Oil type
     */
    public Oil(String type, int liter, int literpirce, OilType oilType) {
        super(type, liter, literpirce);
        this.oilType = oilType;
    }

    /**
     * Create a String representation of Oil
     * @return String representation of Oil
     */
    @Override
    public String toString() {
        return super.toString() + " - " + this.literprice;
    }
}



