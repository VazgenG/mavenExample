package education.model;

import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class User implements Serializable {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String type;

}
