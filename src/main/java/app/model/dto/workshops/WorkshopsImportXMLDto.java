package app.model.dto.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsImportXMLDto {

    @XmlElement(name = "workshop")
    public List<WorkshopImportXMLDto> workshopImportXMLDtos;

    public List<WorkshopImportXMLDto> getWorkshopImportXMLDtos() {
        return this.workshopImportXMLDtos;
    }

    public void setWorkshopImportXMLDtos(List<WorkshopImportXMLDto> workshopImportXMLDtos) {
        this.workshopImportXMLDtos = workshopImportXMLDtos;
    }
}

