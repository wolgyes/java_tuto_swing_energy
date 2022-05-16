package managgers;

import enums.OilType;
import gui.MainWindow;
import managgers.CompanyMangger;
import models.Company;
import models.Oil;
import models.Water;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.UUID;

/**
 * managgers.App class is the actual main class of the application.
 */
public class App {

    public static CompanyMangger companyMangger = new CompanyMangger();

    static class XmlManagger {
        static File xmlFile = new File("Companies.xml");

        public static void xmlLoad() {
            try {
                JAXBContext jc = JAXBContext.newInstance(CompanyMangger.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                companyMangger = (CompanyMangger) unmarshaller.unmarshal(xmlFile);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public static void xmlWrite() {
            try {
                JAXBContext context = JAXBContext.newInstance(CompanyMangger.class);
                Marshaller marsh = context.createMarshaller();
                marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                marsh.marshal(companyMangger, new File(String.valueOf(xmlFile)));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public static File getXmlFile() {
            return xmlFile;
        }

        public static void setXmlFile(File xmlFile) {
            XmlManagger.xmlFile = xmlFile;
        }
    }

    public void run(){
        XmlManagger.xmlLoad();

        new MainWindow();
    }

    // ========================
    // ||   ADDING METHODS   ||
    // ========================

    static void addCompany(Company company){
        companyMangger.addCompany(company);
        XmlManagger.xmlWrite();
    }
    static void addWater(Company company, Water water){
        company.addWater(water);
        XmlManagger.xmlWrite();
    }
    static void addOil(Company company, Oil oil){
        company.addOil(oil);
        XmlManagger.xmlWrite();
    }


    // ========================
    // ||   REMOVE METHODS   ||
    // ========================

    static void removeCompany(Company company){
        companyMangger.getCompanies().values().remove(company);
        XmlManagger.xmlWrite();
    }
    static void removeWater(Company company, UUID waterUUID){
        company.removeWater(waterUUID);
        XmlManagger.xmlWrite();
    }
    static void removeOil(Company company, UUID oilUUID){
        company.removeOil(oilUUID);
        XmlManagger.xmlWrite();
    }


    // ===========================
    // ||   CHOOSING METHODS   ||
    // ===========================

    static Company chooseCompany(UUID uuid){
        return companyMangger.getCompanies().get(uuid);
    }

    static Oil chooseOil(UUID companyUUID, UUID oilUUID){
        Company company = chooseCompany(companyUUID);
        return company.getOils().get(oilUUID);
    }

    static Water chooseTeacher(UUID companyUUID, UUID waterUUID){
        Company company = chooseCompany(companyUUID);
        return company.getWaters().get(waterUUID);
    }


//    // ==========================
//    // ||   LISTING METHODS   ||
//    // ==========================
//
//    static void listCompanies(){
//        for (Map.Entry<UUID, Company> is: companyMangger.getCompanies().entrySet()){
//            System.out.println("\t" + (is.getKey()) + ": " + is.getValue());
//        }
//    }
//
//    static void listOils(Company company){
//        for (Map.Entry<UUID, Oil> is: company.getOils().entrySet()){
//            System.out.println("\t" + (is.getKey()) + ": " + is.getValue());
//        }
//    }
//
//    static void listWaters(Company company){
//        for (Map.Entry<UUID, Water> is: company.getWaters().entrySet()){
//            System.out.println("\t" + (is.getKey()) + ": " + is.getValue());
//        }
//    }
}
