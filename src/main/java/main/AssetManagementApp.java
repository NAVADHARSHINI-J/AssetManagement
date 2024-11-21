package main;
import entity.Asset;

import java.util.Scanner;

import dao.*;

public class AssetManagementApp {
		public static void main(String[] args) {
			AssetManagementService imp= AssetManagementServiceObj.getObject();
			boolean exit=false;
			Scanner sc=new Scanner(System.in);
			while(!exit) {
			System.out.println("Digital asset Management System");
			System.out.printf("1.Add Asset%n2.Update Asset%n3.Delete Asset%n4.Allocate Asset%n5.Deallocate Asset%n6.Perform Maintenance%n7.Reserve Asset%n8.Withdraw Asset%n9.Exit%nEnter the operation to perform:%n");
		    int c=sc.nextInt();
		    sc.nextLine();
			switch(c){
			case 1:
				System.out.print("Enter the assetId:");
				int assetId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Asset Name:");
				String assetName=sc.nextLine();
				System.out.print("Enter the type of the asset(laptop,vehicle,equipment):");
				String type=sc.nextLine();
				System.out.print("Enter the Serial number of an asset:");
				int serialNumber=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Purchase Date(yyyy-mm-dd):");
				String purchaseDate=sc.nextLine();
				System.out.print("Enter the Location:");
				String location=sc.nextLine();
				System.out.print("Enter the Status of an asset(in use,decommissioned,under maintenance)):");
				String status=sc.nextLine();
				System.out.print("Enter the ownerId:");
				int ownerId=sc.nextInt();
				Asset asset=new Asset(assetId,assetName,type,serialNumber,purchaseDate,location,status,ownerId);
				boolean result=imp.addAsset(asset);
				if(result)System.out.println("Asset Added Successfully");
				else System.out.println("Asset is not added");
				break;
			case 2:
				System.out.print("Enter the Asset id to update: ");
				 assetId=sc.nextInt();
				 sc.nextLine();
				 System.out.print("Enter the Asset Name to update:");
			     assetName=sc.nextLine();
				 System.out.print("Enter the type of the asset to update(laptop,vehicle,equipment):");
				 type=sc.nextLine();
			   	 System.out.print("Enter the Serial number of an asset to update:");
				 serialNumber=sc.nextInt();
				 sc.nextLine();
				 System.out.print("Enter the Purchase Date(yyyy-mm-dd) to update:");
				 purchaseDate=sc.nextLine();
				 System.out.print("Enter the Location to update:");
				 location=sc.nextLine();
			   	 System.out.print("Enter the Status of an asset(in use,decommissioned,under maintenance) to update):");
				 status=sc.nextLine();
				 System.out.print("Enter the ownerId to update:");
				 ownerId=sc.nextInt();
				 asset=new Asset(assetId,assetName,type,serialNumber,purchaseDate,location,status,ownerId);
				 result=imp.updateAsset(asset);
				 if(result)System.out.println("Asset Updated Successfully");
				 else System.out.println("Asset is not Updated");
				 break;
			case 3:
				System.out.print("Enter the Asset Id to delete:");
				assetId=sc.nextInt();
				result=imp.deleteAsset(assetId);
				if(result)System.out.println("Asset Deleted Successfully");
				else System.out.println("Asset is not Deleted");
				break;			 
			case 4:
				System.out.print("Enter the Asset Id to Allocate Asset:");
				assetId=sc.nextInt();
				System.out.print("Enter the Employee Id to Allocate Asset:");
				int employeeId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Date to Allocate Asset:");
				String allocation_date=sc.nextLine();
				result=imp.allocateAsset(assetId, employeeId, allocation_date);
				if(result)System.out.println("Asset Allocated Successfully");
				else System.out.println("Asset is not Allocated");
				break;
			case 5:
				System.out.print("Enter the Asset Id to deallocate Asset:");
				assetId=sc.nextInt();
				System.out.print("Enter the Employee Id to deallocate Asset:");
				employeeId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Return Date to deallocate Asset:");
				String returnDate = sc.nextLine();
				result=imp.deallocateAsset(assetId, employeeId, returnDate);
				if(result)System.out.println("Asset Deallocated Successfully");
				else System.out.println("Asset is not Deallocated");
				break;
			case 6:
				System.out.print("Enter the Asset Id to Perform Maintenance:");
				assetId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Maintenance Date:");
				String maintenanceDate=sc.nextLine();
				System.out.print("Enter the Description:");
				String description=sc.nextLine();
				System.out.print("Enter the Cost to perform Maintenance:");
				double cost=sc.nextDouble();
				result=imp.performMaintenance(assetId, maintenanceDate, description, cost);
				if(result)System.out.println("Asset Maintenance record added Successfully");
				else System.out.println("Asset Maintenance record os not added Successfully");
				break;
			case 7:
				System.out.print("Enter the Asset Id for Reservation:");
				assetId=sc.nextInt();
				System.out.print("Enter the Employee id for Reservation:");
				employeeId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the Reservation Date:");
				String reservationDate=sc.nextLine();
				System.out.print("Enter the Start Date for Reservation:");
				String startDate=sc.nextLine();
				System.out.print("Enter the End Date for Reservation:");
				String endDate=sc.nextLine();
				System.out.print("Enter the status of the asset:");
				status=sc.nextLine();
				result=imp.reserveAsset(assetId, employeeId, reservationDate, startDate, endDate,status);
				if(result)System.out.println("Asset Reserved Successfully");
				else System.out.println("Asset is not reserved");
				break;
			case 8:
				System.out.print("Enter the Reservation id to withdraw Reservation");
				int reservationId=sc.nextInt();
				result=imp.withdrawReservation(reservationId);				if(result)System.out.println("Asset Reservation is withdrawed Successfully");
				else System.out.println("Asset Reservation is not withdrawed");
				break;
			case 9:
				exit=true;
				System.out.println("Exited");
				break;
			default:
				System.err.println("Wrong Option");
			}
			
			}
			sc.close();
		}
}
