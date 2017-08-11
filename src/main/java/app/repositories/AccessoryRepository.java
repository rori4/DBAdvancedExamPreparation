package app.repositories;

import app.model.dto.accessories.AccessoryXMLDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.entities.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long> {

}