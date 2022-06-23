package com.flightfare.flightfare;

import com.flightfare.flightfare.model.Fare;
import com.flightfare.flightfare.repository.FareRopository;
import com.flightfare.flightfare.service.FareService;
import com.flightfare.flightfare.service.FareServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class FlightfareApplicationTests {
//	@Autowired
//	private FareService fareService;
//	@MockBean
//	private FareRopository fareRopository;

	@Test
	void contextLoads() {
	}

}//	@Test
//	public void getflightTest(){
//		Fare fareList = new Fare("BF101",101);
//		Object fareServiceImplMock = null;
//		when(fareServiceImplMock.getFlight("BF101")).thenReturn(fareList);
//		assertEquals(fareList,fareServiceImplMock.getFlight("BF101"));
//	}
//	public void fareTest(){
//		Fare fare= new Fare("BF101",101);
//		when(this.fareRopository.save(fare)).thenReturn(fare);
//		assertEquals(fare,fareService.setfare(fare));
//	}
//	}

