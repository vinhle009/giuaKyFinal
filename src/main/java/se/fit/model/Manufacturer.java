package se.fit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    private String manID;
    private String manName;
    private String manContactName;
    private String manContactEmail;
    private String manContactPhone;
    private String manWebsite;
    @OneToMany(mappedBy = "manID")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(String manID, String manName, String manContactName, String manContactEmail, String manContactPhone, String manWebsite) {
        this.manID = manID;
        this.manName = manName;
        this.manContactName = manContactName;
        this.manContactEmail = manContactEmail;
        this.manContactPhone = manContactPhone;
        this.manWebsite = manWebsite;
    }

    public String getManID() {
        return manID;
    }

    public void setManID(String manID) {
        this.manID = manID;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManContactName() {
        return manContactName;
    }

    public void setManContactName(String manContactName) {
        this.manContactName = manContactName;
    }

    public String getManContactEmail() {
        return manContactEmail;
    }

    public void setManContactEmail(String manContactEmail) {
        this.manContactEmail = manContactEmail;
    }

    public String getManContactPhone() {
        return manContactPhone;
    }

    public void setManContactPhone(String manContactPhone) {
        this.manContactPhone = manContactPhone;
    }

    public String getManWebsite() {
        return manWebsite;
    }

    public void setManWebsite(String manWebsite) {
        this.manWebsite = manWebsite;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manID='" + manID + '\'' +
                ", manName='" + manName + '\'' +
                ", manContactName='" + manContactName + '\'' +
                ", manContactEmail='" + manContactEmail + '\'' +
                ", manContactPhone='" + manContactPhone + '\'' +
                ", manWebsite='" + manWebsite + '\'' +
                '}';
    }
}
