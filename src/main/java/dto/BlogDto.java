package dto;

import lombok.*;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
public class BlogDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String header;
    private String content;

    // parametresiz constructor
    public BlogDto() {
    }

    // parametreli super constructor
    public BlogDto(Long id, Date systemCreatedDate) {
        super(id, systemCreatedDate);
    }

    // parametreli constructor
    public BlogDto(Long id, Date systemCreatedDate, String header, String content) {
        super(id, systemCreatedDate);
        this.header = header;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogDto{" +
                "header='" + header + '\'' +
                ", content='" + content + '\'' +
                "} " + super.toString();
    }
}// end class
