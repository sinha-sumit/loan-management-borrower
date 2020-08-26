package com.cde.fse.controller;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cde.fse.mock.MockData;
import com.cde.fse.repository.BorrowerRepository;
import com.cde.fse.service.BorrowerService;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowerControllerTest {
	
	@Mock
    BorrowerController borrowerController;

    @Mock
    BorrowerRepository borrowerRepository;

    @Mock
    BorrowerService borrowerService;

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    MockData mockData;
    
    @Test
	void contextLoads() {
	}
    
   String jsonString = "{\"borrower_id\": 101, \"borrower_name\": \"Sumit\", \"property_address1\": \"Manyata Tech Park\", \"property_address2\": \"Nagawara\", \"property_city\": \"Bangalore\", \"property_zipcode\": 6011, \"loan_amount\": 44000, \"loan_term\": 5, \"loan_id\": 420, \"loan_type\": \"Personal\", \"legal_documents\": \"Legal Documents\"}";
   
   @Test()
    public void testSearchBorrowers() throws Exception{

       Mockito.when(borrowerService.getBorrowerDetails("keyword")).thenReturn((mockData.getBorrowerDetails()));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/borrower/V1/search")
                .param("keyword", "Sumit")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("====================" + result.getResponse().getContentAsString());

        JSONAssert.assertEquals(jsonString, result.getResponse().getContentAsString(), false);

    }

    @Test()
    public void testSaveBorrower() throws Exception{

        Mockito.when(borrowerService.saveOrUpdate(mockData.borrowerData())).thenReturn(mockData.borrowerData());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/borrower/V1/save")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals("http://localhost:8092/borrower/V1/save", response.getHeader(HttpHeaders.LOCATION));

    }

}
