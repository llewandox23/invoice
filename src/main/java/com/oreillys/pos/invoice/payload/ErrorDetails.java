package com.oreillys.pos.invoice.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
public class ErrorDetails {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    private Date timestamp;
    private String message;
    private String details;
    private String statusMsg;

    public ErrorDetails(Date timestamp, String message, String details, HttpStatus statusCodeMsg) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.statusMsg = statusCodeMsg.value() + " " + statusCodeMsg.getReasonPhrase();
    }

}
