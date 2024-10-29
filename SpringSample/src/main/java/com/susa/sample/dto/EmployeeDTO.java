package com.susa.sample.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {

  private long id;
  @NotNull(message = "Invalid Name: Empty name")
  @NotBlank(message = "Invalid Name: Name is NULL")
  @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
  private String name;
  @NotNull
  @Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
  @Max(value = 100, message = "Invalid Age: Exceeds 100 years")
  private int age;
  @NotNull(message = "Invalid Address: Empty Address")
  @NotBlank(message = "Invalid Address: Address is NULL")
  private String address;

  public EmployeeDTO(long id, String name, int age, String address) {
    //this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
  }

}
