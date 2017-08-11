package app.model.dto.photographers;

import com.google.gson.annotations.Expose;

import java.util.List;

public class PhotographerDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String phone;

    @Expose
    private List<Long> lenses;

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

    public List<Long> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<Long> lenses) {
        this.lenses = lenses;
    }
}
