package com.oreillys.pos.invoice.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InvoiceData {
    private String time;
    private TenderDetails tenderDetails;
    private String storeNumber;

}
