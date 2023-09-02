package com.oreillys.pos.invoice.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InvoiceData {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date time;
    private TenderDetails tenderDetails;
    private String storeNumber;

}
