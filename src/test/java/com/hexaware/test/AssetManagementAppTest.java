package com.hexaware.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import dao.AssetManagementService;
import dao.AssetManagementServiceObj;
import entity.Asset;
import exception.AssetNotFoundException;
import exception.AssetNotMaintainException;
import exception.EmployeeNotFoundException;

public class AssetManagementAppTest {
		static AssetManagementService imp=null;
		ArrayList<Executable> arr=null;
		@BeforeAll
		static void beforeAll() {
			 imp= AssetManagementServiceObj.getObject();
		}
		@BeforeEach
		void beforeEach() {
			arr=new ArrayList<>();
		}
		@AfterEach
		void AfterEach() {
			arr=null;
		}
		@Test
		void testAddAsset() {
			Asset asset1=new Asset(6,"lenova","laptop",6,"2024-10-21","Salem","in use",101);
			Asset asset2=new Asset(7,"suzuki","vehicle",7,"2024-10-25","Bangalore","decommissioned",102);
			Asset asset3=new Asset(8,"Del","laptop",8,"2024-11-12","chennai","in use",103);
			Asset asset4=new Asset(9,"scanner","equipment",9,"2024-11-19","Mumbai","under maintenance",104);
			Asset asset5=new Asset(10,"cab","vehicle",10,"2024-10-27","Coimbatore","in use",105);
			arr.add(()->assertEquals(true,imp.addAsset(asset1)));
			arr.add(()->assertEquals(true,imp.addAsset(asset2)));
			arr.add(()->assertEquals(true,imp.addAsset(asset3)));
			arr.add(()->assertEquals(true,imp.addAsset(asset4)));
			arr.add(()->assertEquals(true,imp.addAsset(asset5)));
			assertAll(arr);
		}
		@Test
		void testPerformMaintenance() {
			arr.add(()->assertEquals(true,imp.performMaintenance(1,"2024-10-27","OS Service",5000.00)));
			arr.add(()->assertEquals(true,imp.performMaintenance(2,"2024-11-02","Engine Service",10000.00)));
			arr.add(()->assertEquals(true,imp.performMaintenance(4,"2024-11-21","HardDisk Problem",1000.00)));
			arr.add(()->assertEquals(true,imp.performMaintenance(1,"2024-11-15","HardDisk Problem",1000.00)));
			arr.add(()->assertEquals(true,imp.performMaintenance(2,"2024-11-21","Cleaning Service",2000.00)));
			assertAll(arr);	
		}
		@Test
		void testReservation() {
			arr.add(() -> assertEquals(true, imp.reserveAsset(1, 101, "2024-11-25", "2024-11-27", "2024-11-29", "approved")));
			arr.add(() -> assertEquals(true, imp.reserveAsset(2, 103, "2024-11-26", "2024-11-28", "2024-11-30", "canceled")));
			arr.add(() -> assertEquals(true, imp.reserveAsset(3, 104, "2024-11-23", "2024-11-26", "2024-11-28", "approved")));
			arr.add(() -> assertEquals(true, imp.reserveAsset(4, 105, "2024-11-25", "2024-11-27", "2024-11-29", "approved")));
			arr.add(() -> assertEquals(true, imp.reserveAsset(5, 102, "2024-11-25", "2024-11-27", "2024-11-29", "pending")));
			assertAll(arr);
		}
		
//		@Test
//		void testExceptionHandling() {
//			arr.add(()->assertThrows(AssetNotFoundException.class, ()->imp.deleteAsset(100)));
//			arr.add(()->assertThrows(EmployeeNotFoundException.class,()->imp.allocateAsset(1, 201, "2024-11-21")));
//			arr.add(()->assertThrows(EmployeeNotFoundException.class,()->imp.deallocateAsset(2, 201, "2024-11-30")));
//			arr.add(()->assertThrows(AssetNotMaintainException.class, ()->imp.reserveAsset(4, 102, "2024-11-25", "2024-11-27", "2024-11-29", "pending")));
//			assertAll(arr);
//			assertThrows(AssetNotFoundException.class, ()->imp.deleteAsset(100));
//		}
}
