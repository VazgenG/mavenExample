package education.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Objects;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode


public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private int phone;
    private String lesson;

}