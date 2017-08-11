package app.services.lens;

import app.model.entities.Lens;
import app.repositories.LensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class LensServiceImpl implements LensService {

	private final LensRepository lensRepository;

	@Autowired
	public LensServiceImpl(LensRepository lensRepository) { 
		this.lensRepository = lensRepository;
	}

	@Override
	public List<Lens> addAll(Iterable<Lens> lenses) {
		return lensRepository.save(lenses);
	}

	@Override
	public List<Lens> findByIdIn(Iterable<Long> id) {
		return lensRepository.findByIdIn(id);
	}
}