package app.services.lens;

import app.model.entities.Lens;

import java.util.List;

public interface LensService {
    List<Lens> addAll(Iterable<Lens> lenses);

    List<Lens> findByIdIn(Iterable<Long> id);
}