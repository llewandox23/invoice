package com.oreillys.pos.invoice.payload;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Date;

public class LocalTimeData {

    private Date time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
