package app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cameras")
@DiscriminatorColumn(name = "camera_type")
public abstract class BasicCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "make")
    private String make;

    @NotNull
    @Column(name = "model")
    private String model;

    @Column(name = "is_full_frame")
    private Boolean isFullFrame;

    @NotNull
    @Column(name = "min_iso")
    @Min(100)
    private Integer minISO;

    @Column(name = "max_iso")
    private Integer maxISO;

    //No Constructor

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getIsFullFrame() {
        return this.isFullFrame;
    }

    public void setIsFullFrame(Boolean isFullFrame) {
        this.isFullFrame = isFullFrame;
    }

    public Integer getMinISO() {
        return this.minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    public Integer getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }

    protected abstract String type();

    @Override
    public String toString() {
        return type() + " " + make + " " + model;
    }
}
