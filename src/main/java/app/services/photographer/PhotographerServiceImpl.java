package app.services.photographer;

import app.model.entities.BasicCamera;
import app.model.entities.Lens;
import app.model.entities.Photographer;
import app.model.parsers.util.ValidationUtil;
import app.repositories.BasicCameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

	private final PhotographerRepository photographerRepository;

	private final LensRepository lensRepository;

	private final BasicCameraRepository basicCameraRepository;

	@Autowired
	public PhotographerServiceImpl(PhotographerRepository photographerRepository, LensRepository lensRepository, BasicCameraRepository basicCameraRepository) {
		this.photographerRepository = photographerRepository;
		this.lensRepository = lensRepository;
		this.basicCameraRepository = basicCameraRepository;
	}

	@Override
	public Photographer addPhotographer(Photographer photographer, Iterable<Long> lensIds) {
        Photographer persistedPhotographer = null;
		addCameras(photographer);
		if (ValidationUtil.isValid(photographer)) {
			List<Lens> lenses = lensRepository.findByIdIn(lensIds);
			List<Lens> resultList = new ArrayList<>();
			for (Lens lens : lenses) {
			    if (isCompatible(lens,photographer.getPrimaryBasicCamera()) ||
                isCompatible(lens, photographer.getSecondaryBasicCamera())){
                    lens.setOwner(photographer);
                    resultList.add(lens);
                }
			}
			photographer.setLenses(resultList);
            persistedPhotographer = photographerRepository.save(photographer);
            System.out.println("Successfully imported " + photographer);
        } else {
            System.out.println("Error. Invalid data provided");
        }
		return persistedPhotographer;
	}

	private void addCameras(Photographer photographer) {
		Long count = basicCameraRepository.count();
		Random random = new Random();
        Long generatedId = ThreadLocalRandom.current().nextLong(1, count);
        if (photographer.getPrimaryBasicCamera() == null){
			photographer.setPrimaryBasicCamera(basicCameraRepository.findOne(generatedId));
		}
        generatedId = ThreadLocalRandom.current().nextLong(1, count);
		if (photographer.getSecondaryBasicCamera() == null){
            photographer.setSecondaryBasicCamera(basicCameraRepository.findOne(generatedId));
		}
	}

	private boolean isCompatible(Lens lens, BasicCamera camera){
	    return lens.getCompatibleWith() != null &&
                lens.getCompatibleWith().equals(camera.getMake());
    }
}