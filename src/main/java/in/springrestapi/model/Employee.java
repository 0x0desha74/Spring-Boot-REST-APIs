package in.springrestapi.model;


import in.springrestapi.dto.EmployeeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private int age ;

    @NotBlank
    @Email(message = "Please enter a valid email")
    private String email;

    private String location;
   @JoinColumn(name = "department_id")
   @ManyToOne
    private Department department;

    @CreationTimestamp
    @Column( name = "created_at",nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date updatedAt;


    public Employee(EmployeeDTO empDto) {
        this.name = empDto.getName();
        this.age = empDto.getAge();
        this.email = empDto.getEmail();
        this.location = empDto.getLocation();
    }
}
