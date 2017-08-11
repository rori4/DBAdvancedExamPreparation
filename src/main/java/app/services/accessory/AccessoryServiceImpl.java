package app.services.accessory;

import app.model.dto.accessories.AccessoryXMLDto;
import app.model.entities.Accessory;
import app.model.parsers.util.MappingUtil;
import app.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService {

	private final AccessoryRepository accessoryRepository;

	@Autowired
	public AccessoryServiceImpl(AccessoryRepository accessoryRepository) { 
		this.accessoryRepository = accessoryRepository;
	}

	@Override
	public void add(Accessory accessory) {
		accessoryRepository.saveAndFlush(accessory);
	}

	@Override
	public List<Accessory> addAll(Iterable<Accessory> accessories) {
		return this.accessoryRepository.save(accessories);
	}
}