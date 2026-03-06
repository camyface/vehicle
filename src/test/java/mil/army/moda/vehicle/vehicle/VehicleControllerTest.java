package mil.army.moda.vehicle.vehicle;

import mil.army.moda.vehicle.operator.Operator;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    VehicleService vehicleService;

    @Captor
    ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);

    @Test
    void shouldSaveAVehicle() throws Exception {
        //arrange
        Operator cameron = new Operator("Cameron", 26);
        cameron.setId(1L);
        Vehicle cam = new Vehicle("Honda", "Civic", 2023, 55000, cameron);
        cam.setId(1L);
        when(vehicleService.saveVehicle(any(Vehicle.class))).thenReturn(cam);
        //act
        mockMvc.perform(post("/api/vehicle")
        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cam)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.make").value("Honda"))
                .andExpect(jsonPath("$.operator.name").value("Cameron"))
                .andDo(print());

        verify(vehicleService, only()).saveVehicle(captor.capture());
        assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(cam);
//        verify(vehicleService, times(1)).saveVehicle(any(Vehicle.class));
    }
}