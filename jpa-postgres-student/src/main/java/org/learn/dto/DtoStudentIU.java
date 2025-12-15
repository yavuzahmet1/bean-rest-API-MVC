package org.learn.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 2, max = 50, message = "First name must have between 2 and 50 characters")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must have between 2 and 50 characters")
    @NotNull(message = "Last name must not be null")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthOfDate;
}