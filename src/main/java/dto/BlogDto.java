package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@Builder
public class BlogDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String header;
    private String content;

}// end class
