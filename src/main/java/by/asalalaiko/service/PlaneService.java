package by.asalalaiko.service;


import by.asalalaiko.domain.Plane;

import java.util.List;

public interface PlaneService {

    Plane getPlaneById (Long id);

    List<Plane> getPlanes();

    void createPlane(Plane plane);

    void updatePlane(Plane plane);

    public void deleteById (Long id);


}
