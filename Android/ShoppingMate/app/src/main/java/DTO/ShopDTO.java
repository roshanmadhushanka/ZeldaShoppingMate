package DTO;

/**
 * Created by User on 3/24/2016.
 */
public class ShopDTO {
    private int id;
    private String name;
    private String address;
    private String contact;

    public ShopDTO(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public ShopDTO(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
