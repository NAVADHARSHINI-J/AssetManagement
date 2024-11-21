package entity;

public class AssetAllocation {
		private int allocationId;
		private int assetId;
		private int employeeId;
		private String allocationDate;
		private String returnDate;
		public AssetAllocation(int allocationId, int assetId, int employeeId, String allocationDate,
				String returnDate) {
			super();
			this.allocationId = allocationId;
			this.assetId = assetId;
			this.employeeId = employeeId;
			this.allocationDate = allocationDate;
			this.returnDate = returnDate;
		}
		public int getallocationId() {
			return allocationId;
		}
		public void setallocationId(int allocationId) {
			this.allocationId = allocationId;
		}
		public int getassetId() {
			return assetId;
		}
		public void setassetId(int assetId) {
			this.assetId = assetId;
		}
		public int getemployeeId() {
			return employeeId;
		}
		public void setemployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getallocationDate() {
			return allocationDate;
		}
		public void setallocationDate(String allocationDate) {
			this.allocationDate = allocationDate;
		}
		public String getreturnDate() {
			return returnDate;
		}
		public void setreturnDate(String returnDate) {
			this.returnDate = returnDate;
		}
		
}
