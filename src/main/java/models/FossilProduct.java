package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
abstract class FossilProduct {
    protected String type;
    protected int liter;
    protected int literprice;

    public FossilProduct(){

    }
    public FossilProduct(String type, int liter, int literpirce){
        this.type = type;
        this.liter = liter;
        this.literprice = literpirce;
    }

    public String getType(){
        return type;
    }
    public int getLiter(){
        return liter;
    }
    public float getLiterPrice() {
        return literprice;
    }
    @Override
    public String toString(){
        return type +" "+ liter;
    }
}
