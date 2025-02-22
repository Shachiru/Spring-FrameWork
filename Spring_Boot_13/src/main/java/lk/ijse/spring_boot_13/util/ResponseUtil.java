package lk.ijse.spring_boot_13.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUtil {
    private int code;
    private String message;
    private Object data;        //most super type
}
