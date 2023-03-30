package vn.com.devmaster.services.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BadAlertRequestException extends RuntimeException {
    private String msg;
    private String entity;
    private String code;
}
