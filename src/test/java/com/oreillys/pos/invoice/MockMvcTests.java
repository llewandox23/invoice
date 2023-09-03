package com.oreillys.pos.invoice;

import com.oreillys.pos.invoice.controller.InvoiceController;
import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.repository.InvoiceRepository;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InvoiceService invoiceService;

    @Test
    public void testGetTenderTypeForCustomerMockService() throws Exception {
        Map<Long, String> theMap = new HashMap<>();
        theMap.put(56L, "credit");
        theMap.put(57L, "credit");
        when(invoiceService.getTenderTypeMapByCustomerId(2))
                .thenReturn(theMap);

        this.mockMvc.perform(get("/api/invoice/tendertype/customer/2"))
                .andDo(print()).andExpect(status().isOk());
    }

}
