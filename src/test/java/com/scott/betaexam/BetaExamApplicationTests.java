package com.scott.betaexam;

import com.scott.betaexam.dao.impl.EmployeeRepository;
import com.scott.betaexam.dto.Employee;
import com.scott.betaexam.restController.EmployeeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
class BetaExamApplicationTests {

	@Autowired
	private EmployeeController employeeController;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	void testCreateEmployee() throws Exception {

		String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(formattedDate).getTime());

		Employee employee = new Employee();

		employee.setId("05efd9e8-10f7-4ed7-8c2a-41849512d985");
		employee.setName("Ryan Michael");
		employee.setAddress("Ashford");
		employee.setCity("Monoroe");
		employee.setState( "Lousiana");
		employee.setEmail("ryanmichael@accn.com");
		employee.setCreateDate( timestamp );

		assertEquals(employeeRepository.insertEmployeeInfo(employee),null);//.thenReturn(employee);

		assertEquals( 12,employee.getName().length());

	}


	@Test
	public void getEmployeeByIdTest()
	{
		List<Employee> employeeList=new ArrayList<>();
		Employee employee =new Employee();
		employeeList.add( employee );
		String filterByName="Sam";
		String filterWithColumn="Name";
		when(employeeRepository.findEmployeeByNameOrEmail(filterByName,filterWithColumn)).thenReturn(employeeList);

		assertEquals(1, employeeList.size());


	}
}

