package education.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor



public class Lesson implements Serializable {

    private String name;
    private double duration;
    private String lecturerName;
    private double price;
    private Set<Student> students;

}
