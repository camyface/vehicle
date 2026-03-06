package mil.army.moda.vehicle.vehicle;

import mil.army.moda.vehicle.operator.Operator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    VehicleRepository vehicleRepository;

    @InjectMocks
    VehicleService vehicleService;

    @Test
    void shouldSaveNewVehicle() {
        //Arrange
        Operator cameron = new Operator("Cameron", 26);
        Vehicle cam = new Vehicle("Honda", "Civic", 2023, 55000, cameron);
        Vehicle savedCam = new Vehicle("Honda", "Civic", 2023, 55000, cameron);
        //Act
        when(vehicleRepository.save(cam)).thenReturn(savedCam);
        Vehicle result = vehicleService.saveVehicle(cam);

        //Assert
        assertThat(result.getMake()).isEqualTo(cam.getMake());
        verify(vehicleRepository).save(cam);
    }
}