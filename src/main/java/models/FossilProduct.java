package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Fossil Product class
 *
 * @see XmlAccessorType
 */
@XmlAccessorType(XmlAccessType.FIELD)
abstract class FossilProduct {
    protected String type;
    protected int liter;
    protected int literprice;

    /**
     * Default constructor
     * It's used by JAXB
     *
     * @see javax.xml.bind.JAXB
     */
    public FossilProduct(){}

    /**
     * Constructor
     * @param type type of product
     * @param liter amount of liter
     * @param literpirce price of liter
     */
    public FossilProduct(String type, int liter, int literpirce){
        this.type = type;
        this.liter = liter;
        this.literprice = literpirce;
    }

    /**
     * Get the type of product
     * @return type of product
     */
    public String getType(){
        return type;
    }

    /**
     * Get the amount of liter
     * @return amount of liter
     */
    public int getLiter(){
        return liter;
    }

    /**
     * Get the price of liter
     * @return price of liter
     */
    public float getLiterPrice() {
        return literprice;
    }

    /**
     * Create a String representation of the FossilProduct
     * @return String representation of the FossilProduct
     */
    @Override
    public String toString(){
        return type +" - "+ liter;
    }
}
