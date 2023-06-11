package dto;

import lombok.*;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegisterDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String uName;
    private String uSurname;
    private String uEmail;
    private String uPassword;

    // extends ile çalışıyorsanız bunu yapalım.
    // parametresiz constructor
    public RegisterDto() {}

    // parametreli constructor
    public RegisterDto(Long id, Date systemCreatedDate, String uName, String uSurname, String uEmail, String uPassword) {
        super(id, systemCreatedDate);
        this.uName = uName;
        this.uSurname = uSurname;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
    }
}// end class
