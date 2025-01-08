package com.usuario.usuario_ms.exception;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;

    public StandardError (Instant timestamp, Integer status, String message, String error, String path){
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
    }

    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public Integer getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public String getError() {
        return error;
    }
    public String getPath() {
        return path;
    }
}
