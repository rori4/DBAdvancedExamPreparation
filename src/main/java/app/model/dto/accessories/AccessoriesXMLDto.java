package app.model.dto.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesXMLDto {

    @XmlElement(name = "accessory")
    private List<AccessoryXMLDto> accessoryXMLDtos;

    public List<AccessoryXMLDto> getAccessoryXMLDtos() {
        return this.accessoryXMLDtos;
    }

    public void setAccessoryXMLDtos(List<AccessoryXMLDto> accessoryXMLDtos) {
        this.accessoryXMLDtos = accessoryXMLDtos;
    }
}
