package edu.icet.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
public class Student {
    @Valid
    private Long id;
    @NotEmpty(message = "empty")
    private String firstName;
    @NotEmpty(message = "empty")
    private String lastName;
    @Pattern(regexp = "([0-9]{12})|([0-9]{9}[v])",message = "Incorrect")
    private String nic;
    @Email(message = "Invalid")
    @NotEmpty(message = "empty")
    private String emailAddress;
    @Pattern(regexp = "^0\\d{9}$", message = "Incorrect")
    private String contactNo;
    @NotEmpty(message = "empty")
    private String city;
    @NotEmpty(message = "empty")
    private String birthday;
    @NotEmpty(message = "empty")
    private String course;
    @NotEmpty(message = "empty")
    private String gender;
    private String imageName;
    private String imagePath;
}