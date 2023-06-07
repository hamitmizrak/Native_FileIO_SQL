package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
public class BlogDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String header;
    private String content;

    // extends ile çalışıyorsanız bunu yapalım.
    // parametresiz constructor
    public BlogDto() {
    }

    // parametreli constructor
    public BlogDto(Long id, Date systemCreatedDate, String header, String content) {
        super(id, systemCreatedDate);
        this.header = header;
        this.content = content;
    }
}
