package com.amol.entities;

        import jakarta.persistence.Column;
        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;
        import jakarta.persistence.Table;

@Entity
@Table(
        name = "users"
)
public class Users {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(
            length = 16,
            nullable = false
    )
    private String password;
    @Column(
            nullable = false,
            length = 45,
            unique = false,
            name = "first_name"
    )
    private String firstName;
    @Column(
            nullable = false,
            length = 35,
            unique = false,
            name = "last_name"
    )
    private String lastName;
    @Column(
            nullable = false,
            unique = true,
            length = 48,
            name = "email"
    )
    private String email;
    @Column(
            nullable = false,
            name = "description"
    )
    private String status;
    @Column(
            name = "isActive"
    )
    private boolean isActive;

    public Users(int id, String password, String firstName, String lastName, String email, String status, boolean isActive) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.isActive = isActive;
    }

    public Users() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = this.isActive;
    }

    public String toString() {
        return "Users{id=" + this.id + ", password='" + this.password + "', firstName='" + this.firstName + "', lastName='" + this.lastName + "', email='" + this.email + "', status='" + this.status + "', isActive=" + this.isActive + "}";
    }
}
