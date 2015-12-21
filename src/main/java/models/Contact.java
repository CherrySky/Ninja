package models;
public class Contact {

    private String name;
    private String email;
    public String description;
    public int id;

    public Contact() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", description=" + description + ", id=" + id + "]";
	}

}  