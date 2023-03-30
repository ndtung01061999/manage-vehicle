package vn.com.devmaster.services.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemDetail {
    private String message;
    private String entity;
    private String code;
    private Integer status;
}
