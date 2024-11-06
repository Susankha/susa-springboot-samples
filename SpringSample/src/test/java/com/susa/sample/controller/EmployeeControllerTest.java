package com.susa.sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.susa.sample.dto.EmployeeDTO;
import com.susa.sample.service.EmployeeService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(EmployeeController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebAppConfiguration
class EmployeeControllerTest {

  EmployeeDTO employeeDTO;
  @Autowired private MockMvc mockMvc;

  @MockBean
  @Autowired
  @Qualifier("employeeServiceImpl")
  private EmployeeService employeeService;

  @Autowired private ObjectMapper objectMapper;

  @BeforeAll
  static void beforeAll() {
    System.out.println("******** EmployeeControllerTest beforeAll *******");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("******** EmployeeControllerTest afterAll *******");
  }

  @BeforeEach
  void setUp() {
    System.out.println("******** EmployeeControllerTest setUp *******");
    employeeDTO = EmployeeDTO.builder().id(23).name("Shevin").age(24).address("mathugama").build();
  }

  @Test
  @Order(1)
  void addEmployeeTest() throws Exception {
    System.out.println("******** EmployeeControllerTest addEmployeeTest *******");
    ResultActions response =
        mockMvc.perform(
            post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO)));

    response.andDo(print()).andExpect(status().isCreated());
  }

  @AfterEach
  void tearDown() {
    System.out.println("******** EmployeeControllerTest tearDown *******");
  }
}
