package testandohelper;

import java.util.List;

public class Empresa {
    private String banner;
    private String cnpj;
    private int companyId;
    private String companyName;
    private String corporateName;
    private String email;
    private String latitude;
    private String longitude;
    private String neighborhood;
    private String number;
    private String phone;
    private List<String> serviceDays;
    private List<String> serviceType;
    private String facebook;
    private String instagram;
    private String street;

    // Constructor
    public Empresa(String banner, String cnpj, int companyId, String companyName, String corporateName, String email,
                   String latitude, String longitude, String neighborhood, String number, String phone,
                   List<String> serviceDays, List<String> serviceType, String facebook, String instagram, String street) {
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da empresa não pode ser vazio.");
        }
        this.banner = banner;
        this.cnpj = cnpj;
        this.companyId = companyId;
        this.companyName = companyName;
        this.corporateName = corporateName;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhood = neighborhood;
        this.number = number;
        this.phone = phone;
        this.serviceDays = serviceDays;
        this.serviceType = serviceType;
        this.facebook = facebook;
        this.instagram = instagram;
        this.street = street;
    }

    // Getters y Setters
    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da empresa não pode ser vazio.");
        }
        this.companyName = companyName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getServiceDays() {
        return serviceDays;
    }

    public void setServiceDays(List<String> serviceDays) {
        this.serviceDays = serviceDays;
    }

    public List<String> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<String> serviceType) {
        this.serviceType = serviceType;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Método toString
    @Override
    public String toString() {
        return "Empresa{" +
                "banner='" + banner + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", email='" + email + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", serviceDays=" + serviceDays +
                ", serviceType=" + serviceType +
                ", facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
