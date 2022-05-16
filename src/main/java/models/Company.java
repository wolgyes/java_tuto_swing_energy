package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.UUID;

/**
 * Company class
 *
 * @see XmlAccessorType
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Comparable<Company> {
    private String name;

    @XmlElement(name = "oils")
    private HashMap<UUID, Oil> oils;

    @XmlElement(name = "waters")
    private HashMap<UUID, Water> waters;

    /**
     * Default constructor
     */
    public Company() {
        this.oils = new HashMap<>();
        this.waters = new HashMap<>();
    }

    /**
     * Constructor
     * @param name name of the company
     */
    public Company(String name) {
        this.name = name;
        this.oils = new HashMap<>();
        this.waters = new HashMap<>();
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add water to the company
     * @param water water to add
     */
    public void addWater(Water water){
        UUID uuid = UUID.randomUUID();
        for (UUID waterId: waters.keySet()) {
            if (waterId.equals(uuid)){
                addWater(water);
            }
        }
        waters.put(uuid, water);
    }

    /**
     * Add oil to the company
     * @param oil oil to add
     */
    public void addOil(Oil oil){
        UUID uuid = UUID.randomUUID();
        for (UUID oilId: oils.keySet()) {
            if (oilId.equals(uuid)){
                addOil(oil);
            }
        }
        oils.put(uuid, oil);
    }

    /**
     * Remove water from the company
     * @param waterId id of the water
     */
    public void removeWater(UUID waterId){
        this.waters.remove(waterId);
    }

    /**
     * Remove oil from the company
     * @param oilId id of the oil
     */
    public void removeOil(UUID oilId){
        this.oils.remove(oilId);
    }

    /**
     * Getter for waters
     * @return waters
     */
    public HashMap<UUID, Water> getWaters(){
        return waters;
    }

    /**
     * Getter for oils
     * @return oils
     */
    public HashMap<UUID, Oil> getOils(){
        return oils;
    }

    /**
     * Create a String representation of the company
     * @return String representation of the company
     */
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * Compare two companies
     * @param o company to compare
     * @return 0 if the companies are equal, -1 if the current company is less than the other company, 1 if the current company is greater than the other company
     */
    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }
}
