package com.oreillys.pos.invoice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreillys.pos.invoice.payload.TenderDetails;

public class TenderTypeUtils {

    public static String getTenderTypeFromInvoiceData(String invoiceData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String searchStr = "\"tenderDetails\": ";
        int tenderDetailsStart = invoiceData.indexOf(searchStr) + searchStr.length();
        String tenderDetails = invoiceData.substring(tenderDetailsStart);
        TenderDetails tenderDetailsObject = objectMapper.readValue(tenderDetails, TenderDetails.class);
        return tenderDetailsObject.getType();
    }
}
