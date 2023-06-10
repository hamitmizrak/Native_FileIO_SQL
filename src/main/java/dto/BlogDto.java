package dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter @Setter
@AllArgsConstructor
@Builder
public class BlogDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String header;
    private String content;

}// end class
