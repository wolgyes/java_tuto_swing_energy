package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private String name;

    @XmlElement(name = "oils")
    private HashMap<UUID, Oil> oils;

    @XmlElement(name = "waters")
    private HashMap<UUID, Water> waters;

    public Company() {
        this.oils = new HashMap<>();
        this.waters = new HashMap<>();
    }

    public Company(String name) {
        this.name = name;
        this.oils = new HashMap<>();
        this.waters = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }
    public void addWater(Water water){
        UUID uuid = UUID.randomUUID();
        for (UUID waterId: waters.keySet()) {
            if (waterId.equals(uuid)){
                addWater(water);
            }
        }
        waters.put(uuid, water);
    }
    public void addOil(Oil oil){
        UUID uuid = UUID.randomUUID();
        for (UUID oilId: oils.keySet()) {
            if (oilId.equals(uuid)){
                addOil(oil);
            }
        }
        oils.put(uuid, oil);
    }

    public void removeWater(UUID waterId){
        this.waters.remove(waterId);
    }
    public void removeOil(UUID oilId){
        this.oils.remove(oilId);
    }

    public HashMap<UUID, Water> getWaters(){
        return waters;
    }
    public HashMap<UUID, Oil> getOils(){
        return oils;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
