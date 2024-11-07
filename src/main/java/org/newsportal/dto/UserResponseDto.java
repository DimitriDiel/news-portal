package org.newsportal.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.newsportal.entity.Role;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Set<Role> roles;

    public UserResponseDto(UserResponseDto response) {
        this.id = response.getId();
        this.username = response.getUsername();
        this.firstName = response.getFirstName();
        this.lastName = response.getLastName();
        this.email = response.getEmail();
        this.phone = response.getPhone();
        this.address = response.getAddress();
        this.city = response.getCity();
        this.state = response.getState();
        this.zip = response.getZip();
        this.country = response.getCountry();
        this.roles = response.getRoles();
    }
}
