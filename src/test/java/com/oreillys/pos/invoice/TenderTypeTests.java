package com.oreillys.pos.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.LocalTimeData;
import com.oreillys.pos.invoice.payload.TenderDetails;
import com.oreillys.pos.invoice.payload.TenderType;
import com.oreillys.pos.invoice.utils.TenderTypeUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TenderTypeTests {

    @Test
    public void checkEnumVals() {
        assertEquals("cash", TenderType.CASH.getType() );
        assertEquals("credit", TenderType.CREDIT.getType() );
    }

    @Test
    public void checkAmountVals(){
        BigDecimal money = new BigDecimal("25.43");
        TenderDetails td = new TenderDetails();
        td.setAmount(money);
        td.setType(TenderType.CASH.name());
        InvoiceData data = new InvoiceData();
        data.setTenderDetails(td);
        data.setStoreNumber("999");
        System.out.println(data.toString());
    }

    @Test
    public void testLocalTimeJson() throws JsonProcessingException {
        LocalTimeData localTimeData = new LocalTimeData();
        localTimeData.setTime(new Date());
        System.out.println("time " + localTimeData.getTime());
    }

    @Test
    public void testTenderTypeMapper() throws JsonProcessingException {
        String invoiceData = "{\"time\": 12:00, \"tenderDetails\": {\"amount\": 4.95, \"type\": \"cash\"}, \"storeNumber\": \"999\"}";
        String tenderType = TenderTypeUtils.getTenderTypeFromInvoiceData(invoiceData);
        assertEquals("cash", tenderType);
    }

    @Test
    public void testTenderTypeMapperNotEqual() throws JsonProcessingException {
        String invoiceData = "{\"time\": 12:00, \"tenderDetails\": {\"amount\": 4.95, \"type\": \"credit\"}, \"storeNumber\": \"999\"}";
        String tenderType = TenderTypeUtils.getTenderTypeFromInvoiceData(invoiceData);
        assertNotEquals("cash", tenderType);
    }

    @Test
    public void testTenderTypeMapperError()  {
        JsonProcessingException exception = assertThrows(JsonProcessingException.class, () -> {
            String invoiceData = "{\"time\": 12:00, \"tenderDetails\": {\"amount\": 4.95, \"typo\": \"credit\"}, \"storeNumber\": \"999\"}";
            String tenderType = TenderTypeUtils.getTenderTypeFromInvoiceData(invoiceData);
        });
        System.out.println(exception.getMessage());
    }

    @Test
    public void testGroupingToMap() {
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(new Invoice(54, 1, "cash"));
        invoiceList.add(new Invoice(55, 2, "cash"));
        invoiceList.add(new Invoice(56, 2, "credit"));
        Map<Long, Invoice> invoiceMap = invoiceList.stream().filter(inv -> 2 == inv.getCustomer_id()).collect(Collectors.toMap(Invoice::getId, Function.identity()));
        Map<Long, String> tenderMap = invoiceList.stream().collect(Collectors.toMap(Invoice::getId, Invoice::getTenderType));
        invoiceMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        tenderMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

    class Invoice {
        long id;
        long customer_id;
        String tenderType;

        Invoice(long id, long customer_id, String tenderType) {
            this.id = id;
            this.customer_id = customer_id;
            this.tenderType = tenderType;
        }

        long getId() {
            return id;
        }
        String getTenderType() {
            return tenderType;
        }
        long getCustomer_id() {
            return customer_id;
        }

        public String toString() {
            return String.format("id=%d, customer_id=%d, tenderType=%s", id, customer_id, tenderType);
        }
    }

}
