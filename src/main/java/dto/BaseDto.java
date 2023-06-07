package dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
abstract public class BaseDto implements Serializable {
    public static final Long serialVersionUID=1L;

    private Long id;
    private Date systemCreatedDate;

    //parametresiz constructor (eğer private yaparsan BaseDto new yapamazsın)
    public BaseDto(){
        this.systemCreatedDate=new Date(System.currentTimeMillis());
    }

    public BaseDto(Long id, Date systemCreatedDate) {
        this.id = id;
        this.systemCreatedDate = systemCreatedDate;
    }
}// end class
