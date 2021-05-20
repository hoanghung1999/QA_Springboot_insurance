package com.example.demo;

import com.example.demo.controller.DealController;
import com.example.demo.entity.Deal;
import com.example.demo.entity.Insurance;
import com.example.demo.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ApplicationContext context;

	//Deal


	// Lay toan bo Hoa Don co trong  co so du lieu
	@Test
	void TestDealServiceGetAll() {
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(10,dealService.getAllDeal().size());
	}

	//testCase Lay so luong deal trong 1 khoang
	@Test
	void getDealByTimeValid1(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(2,dealService.getDealByDate("2020-05-05","2020-05-06").size());
	}
	@Test
	void getDealByTimeValid2(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(5,dealService.getDealByDate("2020-05-05","2020-05-08").size());
	}
	@Test
	void getDealByTimeValid3(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(10,dealService.getDealByDate("2020-04-05","2020-06-06").size());
	}
	@Test
	//Bien Duoi
	void getDealByTimeValid4(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(1,dealService.getDealByDate("2020-03-05","2020-05-04").size());
	}
	@Test
	void getDealByTimeValid4_1(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(0,dealService.getDealByDate("2020-03-05","2020-05-03").size());
	}
	//Bien Tren
	@Test
	void getDealByTimeValid5(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(1,dealService.getDealByDate("2020-06-06","2020-06-08").size());
	}

	@Test
	void getDealByTimeValid5_1(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(0,dealService.getDealByDate("2020-06-07","2020-06-08").size());
	}
	// Nhap Dai Dinh Dang
	@Test
	void getDealByTimeInValidSDD_1(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(0,dealService.getDealByDate("ABC","2020-05-05").size());
	}

	@Test
	void getDealByTimeInValidSDD_2(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(0,dealService.getDealByDate("2020-05-05","BCD").size());
	}

	@Test
	void getDealByTimeInValidSDD_3(){
		DealService dealService=context.getBean(DealImpl.class);
		Assertions.assertEquals(0,dealService.getDealByDate("EFG","BCD").size());
	}
	//User
	@Test
	void TestGetAllUser(){
		UserService userService=context.getBean(UserServiceImpl.class);
		Assertions.assertEquals(10,userService.getAllUser().size());
	}


	// Insurance
	@Test
	void TestGetAllInsurance(){
		InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
		Assertions.assertEquals(3,insuranceService.getAllInsurance().size());
	}

	@Test
	void TestUpdateInsuranceInDB(){
		InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
		//thong tin insurance update
		Insurance insurance=new Insurance();
		insurance.setId(1);
		insurance.setNametype("BH_update");
		insurance.setPrice(100000);

		//Insurance Truoc khi update
		Insurance insuranceDB=insuranceService.findInsuranceById(1).get();

		//update
		insuranceService.UpdateInsurance(insurance);
		// Sau update
		Insurance insuranceAfterUD=insuranceService.findInsuranceById(1).get();

		Assertions.assertEquals(insurance.getId(),insuranceAfterUD.getId());
		Assertions.assertEquals(insurance.getNametype(),insuranceAfterUD.getNametype());
		Assertions.assertEquals(insurance.getPrice(),insuranceAfterUD.getPrice());

		//Back up lai du lieu
		insuranceService.UpdateInsurance(insuranceDB);
	}

	@Test
	void UpdateInsuranceNotInDB(){
		InsuranceService insuranceService=context.getBean(InsuranceImpl.class);
		//thong tin insurance update
		Insurance insurance=new Insurance();
		insurance.setId(4);
		insurance.setNametype("BH_update");
		insurance.setPrice(100000);

		//update
		insuranceService.UpdateInsurance(insurance);

		// Sau update
		Assertions.assertEquals(false,insuranceService.findInsuranceById(4).isPresent());
	}


}
