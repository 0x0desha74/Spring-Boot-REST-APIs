package in.springrestapi.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
//    @JsonProperty("full_name")
    private String name;
//    @JsonIgnore
    private int age;
    private String email;
    private String location;
    private String department;

}
