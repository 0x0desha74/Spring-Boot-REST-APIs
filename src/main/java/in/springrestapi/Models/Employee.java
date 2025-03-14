package in.springrestapi.Models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name should not be null")
    private String name;
    private int age ;
    @NotNull(message = "Email should not be null")
    @Email(message = "Please enter a valid email")
    private String email;
    private String location;
    @NotNull(message = "Department should not be null")
    private String department;
    @CreationTimestamp
    @Column( name = "created_at",nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date updatedAt;
}
