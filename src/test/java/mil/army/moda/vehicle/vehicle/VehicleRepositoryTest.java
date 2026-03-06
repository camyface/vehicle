package mil.army.moda.vehicle.vehicle;

import mil.army.moda.vehicle.operator.Operator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {


    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    void shouldSaveAVehicle() {
        // Arrange
        Operator cameron = new Operator("Cameron", 26);
        Vehicle cam = new Vehicle("Honda", "Civic", 2023, 55000, cameron);
        //Act
        Vehicle savedCam = vehicleRepository.save(cam);
        Optional<Vehicle> found = vehicleRepository.findById(cam.getId());
        //Assert
        assertEquals("Honda", found.get().getMake());
        assertThat(found.get().getMake()).isEqualTo(savedCam.getMake());
        assertThat(found.get()).isEqualTo(savedCam);
    }


}