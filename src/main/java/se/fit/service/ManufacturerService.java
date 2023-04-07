package se.fit.service;

import se.fit.model.Manufacturer;
import se.fit.repositories.GenericRepo;

import java.util.List;

public class ManufacturerService {
    private GenericRepo<Manufacturer, String> manufacturerRepo;

    public ManufacturerService() {
        manufacturerRepo = new GenericRepo<>("Manufacturer");
    }

    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        return manufacturerRepo.add(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return manufacturerRepo.update(manufacturer);
    }

    public boolean deleteManufacturer(Manufacturer manufacturer) {
        return manufacturerRepo.delete(manufacturer, manufacturer.getManID());
    }

    public Manufacturer getManufacturerById(String id) {
        return manufacturerRepo.findById(new Manufacturer(), id);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepo.findAll();
    }
}
