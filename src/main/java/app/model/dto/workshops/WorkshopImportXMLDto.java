package app.model.dto.workshops;

import app.model.dto.photographers.ParticipantXMLDto;
import app.model.dto.photographers.TrainerXMLDto;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopImportXMLDto {
    @XmlAttribute
    private String name;

    @XmlAttribute(name = "start-date")
    private Date startDate;

    @XmlAttribute(name = "end-date")
    private Date endDate;

    @XmlAttribute
    private String location;

    @XmlAttribute(name = "price")
    private BigDecimal pricePerParticipant;

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    private List<ParticipantXMLDto> participants;

    @XmlElement(name = "trainer")
    private TrainerXMLDto trainer;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public List<ParticipantXMLDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<ParticipantXMLDto> participants) {
        this.participants = participants;
    }

    public TrainerXMLDto getTrainer() {
        return this.trainer;
    }

    public void setTrainer(TrainerXMLDto trainer) {
        this.trainer = trainer;
    }
}
