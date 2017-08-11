package app.services.accessory;

import app.model.dto.accessories.AccessoryXMLDto;
import app.model.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    void add(Accessory accessory);
    List<Accessory> addAll(Iterable<Accessory> accessories);
}