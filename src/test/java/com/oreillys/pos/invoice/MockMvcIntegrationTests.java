package com.oreillys.pos.invoice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetTenderTypeForCustomerMockService() throws Exception {

        this.mockMvc.perform(get("/api/invoice/tendertype/customer/2"))
                .andDo(print()).andExpect(status().isOk());
    }
}
