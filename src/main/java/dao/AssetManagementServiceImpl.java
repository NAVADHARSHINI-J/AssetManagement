package dao;

import entity.Asset;
import exception.AssetNotFoundException;
import exception.AssetNotMaintainException;
import exception.EmployeeNotFoundException;
import util.*;
import java.sql.*;
import java.time.*;

public class AssetManagementServiceImpl implements AssetManagementService{


	public boolean addAsset(Asset asset) {
		String sql="insert into assets(asset_id,name,type,serial_number,purchase_date,location,status,owner_id)  values(?,?,?,?,?,?,?,?)";
		try(Connection con=DBConnUtil.getConnection()) {
			PreparedStatement p=con.prepareStatement("Select * from employees where employee_id=?");
			p.setInt(1,asset.getownerId());
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new EmployeeNotFoundException("Employee with id "+ asset.getownerId()+" is not found");
			p=con.prepareStatement(sql);
			p.setInt(1, asset.getassetId());
			p.setString(2,asset.getName());
			p.setString(3, asset.getType());
			p.setInt(4,asset.getserialNumber());
			p.setString(5, asset.getpurchaseDate());
			p.setString(6,asset.getLocation());
			p.setString(7, asset.getStatus());
			p.setInt(8, asset.getownerId());
			p.executeUpdate();
		}
		catch(EmployeeNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateAsset(Asset asset) {
		String sql="update assets set type=?, name=?,serial_number=? , purchase_date=? ,location=? , status=? , owner_id=? where asset_id=?";
	    try(Connection con=DBConnUtil.getConnection()) {
	    	PreparedStatement p=con.prepareStatement("Select * from assets where asset_id=?");
			p.setInt(1,asset.getassetId());
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new AssetNotFoundException("Asset with id "+asset.getassetId()+" is not found");
	    	PreparedStatement st=con.prepareStatement(sql);
	    	st.setString(1, asset.getType());
	    	st.setString(2,asset.getName());
	        st.setInt(3, asset.getserialNumber());
	        st.setString(4,asset.getpurchaseDate());
	        st.setString(5,asset.getLocation());
	        st.setString(6, asset.getStatus());
	        st.setInt(7,asset.getownerId());
	        st.setInt(8, asset.getassetId());
	        st.executeUpdate();
	        }
	    catch(AssetNotFoundException | SQLException e) {
	    	System.err.println(e.getMessage());
	    	return false;
	    }
	    return true;
	}

	@Override
	public boolean deleteAsset(int assetId) {
		String sql="delete from assets where asset_id=?";
		try(Connection con=DBConnUtil.getConnection()) {
			PreparedStatement p=con.prepareStatement("Select * from assets where asset_id=?");
			p.setInt(1,assetId);
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new AssetNotFoundException("Asset with id "+assetId+" is not found");
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, assetId);	
			st.executeUpdate();
		}
		catch(AssetNotFoundException | SQLException e) {
	    	System.err.println(e.getMessage());
	    	return false;
	    }
		return true;
	}

	@Override
	public boolean allocateAsset(int assetId, int employeeId, String allocationDate) {
		String sql="insert into asset_allocations(asset_id,employee_id,allocation_date) values (?,?,?)";
		try(Connection con = DBConnUtil.getConnection()) {
			PreparedStatement p=con.prepareStatement("Select * from assets where asset_id=?");
			p.setInt(1,assetId);
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new AssetNotFoundException("Asset with id "+assetId+" is not found");
		    p=con.prepareStatement("Select * from employees where employee_id=?");
			p.setInt(1,employeeId);
		    rs=p.executeQuery();
			if(!rs.next()) throw new EmployeeNotFoundException("Employee with id " +employeeId+" is not found");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,assetId);
			st.setInt(2,employeeId);
			st.setString(3,allocationDate);
			st.executeUpdate();
		}
		catch(AssetNotFoundException | EmployeeNotFoundException |SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deallocateAsset(int assetId, int employeeId, String returnDate) {
		String sql="Update asset_allocations set return_date=? where asset_id=? and employee_id=?";
		try(Connection con=DBConnUtil.getConnection()) {
			PreparedStatement p=con.prepareStatement("Select * from assets where asset_id=?");
			p.setInt(1,assetId);
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new AssetNotFoundException("Asset with id "+assetId+" is not found");
		    p=con.prepareStatement("Select * from employees where employee_id=?");
			p.setInt(1,employeeId);
		    rs=p.executeQuery();
			if(!rs.next()) throw new EmployeeNotFoundException("Employee with id "+employeeId+" is not found");
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,returnDate);
			st.setInt(2,assetId);
			st.setInt(3, employeeId);
			st.executeUpdate();
		}
		catch(AssetNotFoundException | EmployeeNotFoundException |SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) {
		String sql="insert into maintenance_records(asset_id,maintenance_date,description,cost) values(?,?,?,?)";
		try(Connection con=DBConnUtil.getConnection()) {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,assetId);
			st.setString(2, maintenanceDate);
			st.setString(3, description);
			st.setDouble(4, cost);
			st.executeUpdate();	
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate, String status) {
		String sql="insert into reservations(asset_id,employee_id,reservation_date,start_date,end_date,status) values(?,?,?,?,?,?)";
		try(Connection con=DBConnUtil.getConnection()){
			PreparedStatement p=con.prepareStatement("Select * from assets where asset_id=?");
			p.setInt(1,assetId);
			ResultSet rs=p.executeQuery();
			if(!rs.next()) throw new AssetNotFoundException("Asset with id "+assetId+" is not found");
		    p=con.prepareStatement("Select * from employees where employee_id=?");
			p.setInt(1,employeeId);
		    rs=p.executeQuery();
			if(!rs.next()) throw new EmployeeNotFoundException("Employee with id "+ employeeId+" is not found");
			p=con.prepareStatement("Select max(maintenance_date) from maintenance_records where asset_id=?");
			p.setInt(1,assetId);
		    rs=p.executeQuery();
			if(rs.next()) {
				String d1=rs.getString(1);
				if(d1!=null) {
				LocalDate ld1=LocalDate.now();
				LocalDate ld2=LocalDate.parse(d1);
				Period period=Period.between(ld2, ld1);
				int years=period.getYears();
				if(years>=2) throw new AssetNotMaintainException("The Asset is not maintained properly..");
			}
			}
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, assetId);
			st.setInt(2, employeeId);
			st.setString(3, reservationDate);
			st.setString(4, startDate);
			st.setString(5, endDate);
			st.setString(6,status);
			st.executeUpdate();
		}
		catch(AssetNotFoundException | EmployeeNotFoundException | AssetNotMaintainException |SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean withdrawReservation(int reservationId) {
		String sql="delete from reservations where reservation_id=?";
		try(Connection conn=DBConnUtil.getConnection()) {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, reservationId);
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

}
