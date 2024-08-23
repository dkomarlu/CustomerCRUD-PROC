package com.mycompany.apexdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long Id;
    @NonNull
    @NotEmpty
    @Size(min = 3, max = 25)
    private String firstName;
    @NonNull
    @NotEmpty
    @Size(min = 3, max = 25)
    private String lastName;
    @NonNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String emailId;
}
