package androidAutomation.pages;

public class User {
    private String description;
    private String email;
    private String timezone;

    public User(String description, String email, String timezone) {
        this.description = description;
        this.email = email;
        this.timezone = timezone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
