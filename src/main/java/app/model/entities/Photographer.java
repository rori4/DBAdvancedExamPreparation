package app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 50)
    private String lastName;

    @Basic
    private String phone;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "primary_camera_id")
    private BasicCamera primaryBasicCamera;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "secondary_camera_id")
    private BasicCamera secondaryBasicCamera;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Lens> lenses;

    @OneToMany(mappedBy = "owner")
    private List<Accessory> accessories;

    //No Constructor

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryBasicCamera() {
        return this.primaryBasicCamera;
    }

    public void setPrimaryBasicCamera(BasicCamera primaryBasicCamera) {
        this.primaryBasicCamera = primaryBasicCamera;
    }

    public BasicCamera getSecondaryBasicCamera() {
        return this.secondaryBasicCamera;
    }

    public void setSecondaryBasicCamera(BasicCamera secondaryBasicCamera) {
        this.secondaryBasicCamera = secondaryBasicCamera;
    }

    public List<Lens> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public List<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return firstName + " "+ lastName + " | Lenses: " + (lenses == null ? "0" : lenses.size());
    }
}
