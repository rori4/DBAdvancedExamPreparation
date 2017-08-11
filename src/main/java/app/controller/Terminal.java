package app.controller;

import app.model.dto.accessories.AccessoriesXMLDto;
import app.model.dto.accessories.AccessoryXMLDto;
import app.model.dto.cameras.CameraDto;
import app.model.dto.lens.LensesDto;
import app.model.dto.photographers.PhotographerDto;
import app.model.dto.workshops.WorkshopImportXMLDto;
import app.model.dto.workshops.WorkshopsImportXMLDto;
import app.model.entities.*;
import app.model.parsers.JsonParser;
import app.model.parsers.XMLParser;
import app.model.parsers.util.MappingUtil;
import app.repositories.AccessoryRepository;
import app.services.accessory.AccessoryService;
import app.services.basicCamera.BasicCameraService;
import app.services.lens.LensService;
import app.services.photographer.PhotographerService;
import app.services.workshop.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {
    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private XMLParser xmlParser;

    @Autowired
    private LensService lensService;

    @Autowired
    private BasicCameraService basicCameraService;

    @Autowired
    private PhotographerService photographerService;

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private WorkshopService workshopService;

    @Override
    public void run(String... strings) throws Exception {
       importLensesJson();
       importCamerasJson();
       importPhotographersJson();
       importAccessoriesXML();
       importWorkshopsXML();
    }

    private void importWorkshopsXML() throws JAXBException, IOException {
        WorkshopsImportXMLDto workshopsImportXMLDto = xmlParser.getObject(WorkshopsImportXMLDto.class, "/files/xml/input/workshops.xml");
        for (WorkshopImportXMLDto workshopImportXMLDto : workshopsImportXMLDto.getWorkshopImportXMLDtos()) {
            Workshop workshop = MappingUtil.convert(workshopImportXMLDto, Workshop.class);
            workshopService.addWorkshop(workshop);
        }

    }

    private void importAccessoriesXML() throws JAXBException, IOException {
        AccessoriesXMLDto accessoriesXMLDto = xmlParser.getObject(AccessoriesXMLDto.class, "/files/xml/input/accessories.xml");
        List<Accessory> accessories = MappingUtil.convert(accessoriesXMLDto.getAccessoryXMLDtos(), Accessory.class);
        accessoryService.addAll(accessories);
    }

    private void importPhotographersJson() {
        PhotographerDto[] photographerDtos = jsonParser.getObject(PhotographerDto[].class, "/files/json/input/photographers.json");
        for (PhotographerDto photographerDto : photographerDtos) {
            Photographer photographer = MappingUtil.convert(photographerDto,Photographer.class);
            photographerService.addPhotographer(photographer,photographerDto.getLenses());
        }
    }

    private void importCamerasJson() {
        CameraDto[] cameraDtos = jsonParser.getObject(CameraDto[].class, "/files/json/input/cameras.json");
        for (CameraDto cameraDto : cameraDtos) {
            BasicCamera basicCamera = null;
            if ("DSLR".equals(cameraDto.getType())){
                basicCamera = MappingUtil.convert(cameraDto, DSLRCamera.class);
                basicCameraService.add(basicCamera);
            } else if ("Mirrorless".equals(cameraDto.getType())){
                basicCamera = MappingUtil.convert(cameraDto, MirrorlessCamera.class);
                basicCameraService.add(basicCamera);
            }
        }
    }

    private void importLensesJson() {
        LensesDto[] lensesDtos = jsonParser.getObject(LensesDto[].class, "/files/json/input/lenses.json");
        List<Lens> lenses = MappingUtil.convert(Arrays.asList(lensesDtos),Lens.class);
        lensService.addAll(lenses);
    }
}
