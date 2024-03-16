package com.ksamorodov.dickname.dao.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateDickNameRequest {
    @NotNull(message = "Name can not be null")
    @Length(min = 1)
    private String name;
}

