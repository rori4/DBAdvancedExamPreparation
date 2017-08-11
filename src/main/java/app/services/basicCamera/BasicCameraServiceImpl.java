package app.services.basicCamera;

import app.model.entities.BasicCamera;
import app.model.parsers.util.ValidationUtil;
import app.repositories.BasicCameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BasicCameraServiceImpl implements BasicCameraService {

	private final BasicCameraRepository basicCameraRepository;

	@Autowired
	public BasicCameraServiceImpl(BasicCameraRepository basicCameraRepository) { 
		this.basicCameraRepository = basicCameraRepository;
	}

	@Override
	public BasicCamera add(BasicCamera camera) {
		BasicCamera persistedCamera = null;
		if (ValidationUtil.isValid(camera)){
			persistedCamera = basicCameraRepository.save(camera);
			System.out.println("Successfully imported " + camera);
		} else {
			System.out.println("Error. Invalid data provided");
		}
		return persistedCamera;
	}
}