package models;

import enums.OilType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Oil extends FossilProduct {
    OilType oilType;

    public Oil() {
    }

    public Oil(String type, int liter, int literpirce, OilType oilType) {
        super(type, liter, literpirce);
        this.oilType = oilType;
    }



    @Override
    public String toString() {
        return super.toString() + " - " + this.literprice;
    }
}



