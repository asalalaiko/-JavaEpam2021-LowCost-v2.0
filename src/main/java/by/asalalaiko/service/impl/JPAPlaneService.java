package by.asalalaiko.service.impl;

import by.asalalaiko.domain.Plane;
import by.asalalaiko.repo.PlaneRepo;
import by.asalalaiko.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAPlaneService implements PlaneService {

    @Autowired
    private PlaneRepo planeRepo;

    @Override
    public Plane getPlaneById(Long id) {
        return planeRepo.getOne(id);
    }

    @Override
    public List<Plane> getPlanes() {
        return planeRepo.findAll();
    }

    @Override
    public void createPlane(Plane plane) {
        planeRepo.save(plane);
    }

    @Override
    public void updatePlane(Plane plane) { planeRepo.save(plane);
    }

    @Override
    public void deleteById(Long id) {
        planeRepo.deleteById(id);
    }
}
