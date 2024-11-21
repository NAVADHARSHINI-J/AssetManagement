package entity;

public class MaintenanceRecord {
		private int maintenanceId;
		private int assetId;
		private String maintenanceDate;
		private String description;
		private double cost;
		public MaintenanceRecord(int maintenanceId, int assetId, String maintenanceDate, String description,
				double cost) {
			super();
			this.maintenanceId = maintenanceId;
			this.assetId = assetId;
			this.maintenanceDate = maintenanceDate;
			this.description = description;
			this.cost = cost;
		}
		public int getmaintenanceId() {
			return maintenanceId;
		}
		public void setmaintenanceId(int maintenanceId) {
			this.maintenanceId = maintenanceId;
		}
		public int getassetId() {
			return assetId;
		}
		public void setassetId(int assetId) {
			this.assetId = assetId;
		}
		public String getmaintenanceDate() {
			return maintenanceDate;
		}
		public void setmaintenanceDate(String maintenanceDate) {
			this.maintenanceDate = maintenanceDate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		
}
