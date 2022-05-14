package managgers;

import models.Company;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.UUID;

@XmlRootElement(name = "CM")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyMangger {

    @XmlElement(name = "company")
    private HashMap<UUID, Company> companies;

    public CompanyMangger() {
        this.companies = new HashMap<>();
    }

    public void addCompany(Company company) {
        UUID uuid = UUID.randomUUID();
        for (UUID schoolId: companies.keySet()) {
            if (schoolId.equals(uuid)){
                addCompany(company);
            }
        }
        companies.put(uuid, company);
    }

    public HashMap<UUID, Company> getCompanies() {
        return companies;
    }

    @Override
    public String toString(){
        return this.companies.toString();
    }
}
