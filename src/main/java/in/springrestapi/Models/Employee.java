package in.springrestapi.Models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
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
    private String name;
    private int age;
    private String email;
    private String location;
    private String department;
    @CreationTimestamp
    @Column( name = "created_at",nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date updatedAt;
}
