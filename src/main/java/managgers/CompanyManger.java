package managgers;

import models.Company;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.UUID;

/**
 * Company manager class.
 *
 * @see XmlRootElement
 * @see XmlAccessorType
 */
@XmlRootElement(name = "CM")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyManger {

    @XmlElement(name = "company")
    private HashMap<UUID, Company> companies;

    /**
     * Constructor.
     */
    public CompanyManger() {
        this.companies = new HashMap<>();
    }

    /**
     * Add company to the manager.
     * @param company company to add.
     */
    public void addCompany(Company company) {
        UUID uuid = UUID.randomUUID();
        for (UUID schoolId: companies.keySet()) {
            if (schoolId.equals(uuid)){
                addCompany(company);
            }
        }
        companies.put(uuid, company);
    }

    /**
     * Get all companies.
     * @return all companies.
     */
    public HashMap<UUID, Company> getCompanies() {
        return companies;
    }

    /**
     * Create a String representation of the Company.
     * @return String representation of the Company.
     */
    @Override
    public String toString(){
        return this.companies.toString();
    }
}
