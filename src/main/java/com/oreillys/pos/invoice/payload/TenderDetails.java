package com.oreillys.pos.invoice.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TenderDetails {
    private BigDecimal amount;
    private TenderType type;
}
