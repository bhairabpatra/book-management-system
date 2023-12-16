package bookapp.user.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zipCode;
}
