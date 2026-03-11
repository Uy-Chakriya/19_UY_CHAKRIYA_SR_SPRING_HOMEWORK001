package org.chakriya._9_uy_chakriya_sr_spring_homework001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String success;
    private String message;
    private String status;
    private T payload;
    private LocalDateTime timestamp;
//    private String error;
//    private String path;

}
