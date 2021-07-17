package com.iiht.training.eloan.boundary;

import static com.iiht.training.eloan.testutils.TestUtils.currentTest;
import static com.iiht.training.eloan.testutils.TestUtils.testReport;
import static com.iiht.training.eloan.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.eloan.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.eloan.model.LoanDto;
import com.iiht.training.eloan.model.ProcessingDto;
import com.iiht.training.eloan.model.SanctionDto;
import com.iiht.training.eloan.model.UserDto;
import com.iiht.training.eloan.testutils.MasterData;

@ExtendWith(SpringExtension.class)
// @WebMvcTest
public class BoundaryTest {
	private static Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @AfterAll
	public static void afterAll() {
		testReport();
	}
    
    
    @Test
	public void testAcresOfLandNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAcresOfLand(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAcresOfLandNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAcresOfLand(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLandValueNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setLandValue(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLandValueNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setLandValue(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testSuggestedAmountOfLoanNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setSuggestedAmountOfLoan(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testSuggestedAmountOfLoanNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setSuggestedAmountOfLoan(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyNotNull() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAddressOfProperty(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyMinThree() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAddressOfProperty("ab");
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyMaxOneFifty() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		String name = "";
		for(int i=0;i<160;i++) {
			name.concat("A");
		}
		processingDto.setAddressOfProperty(name);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
   
}
