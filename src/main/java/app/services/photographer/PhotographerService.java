package app.services.photographer;

import app.model.entities.Photographer;

import java.util.List;

public interface PhotographerService {
    Photographer addPhotographer(Photographer photographer, Iterable<Long> lensIds);

}