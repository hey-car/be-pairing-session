package com.heycar.pairingservice;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.heycar.pairingsession.PairingServiceApplication;
import com.heycar.pairingsession.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PairingServiceApplication.class)
@AutoConfigureMockMvc
public class ListingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListing() throws Exception {
        List<Car> cars = new ArrayList<>() {{
            add(new Car("ABC", "Audi", 2017, "blue", 30000));
        }};
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cars);
        mockMvc.perform(MockMvcRequestBuilders.post("/listings/1").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isCreated());
        mockMvc.perform(MockMvcRequestBuilders.get("/listings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].code").value("ABC"));
    }
}
