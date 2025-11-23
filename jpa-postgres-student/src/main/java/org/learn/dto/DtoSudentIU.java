package org.learn.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoSudentIU {
    private String firstName;
    private String lastName;
    private Date birthOfDate;
}
