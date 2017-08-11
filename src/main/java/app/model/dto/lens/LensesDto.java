package app.model.dto.lens;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LensesDto {
    @Expose
    private String make;

    @Expose
    private Integer focalLength;

    @Expose
    @SerializedName(value = "maxAperture")
    private Double maxAperture;

    @Expose
    private String compatibleWith;


    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return this.compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
