package entity;

public class Reservation {
		private int reservationId;
		private int assetId;
		private int employeeId;
		private String reservationDate;
		private String startDate;
		private String endDate;
		private String status;
		public Reservation(int reservationId, int assetId, int employeeId, String reservationDate,
				String startDate, String endDate, String status) {
			super();
			this.reservationId = reservationId;
			this.assetId = assetId;
			this.employeeId = employeeId;
			this.reservationDate = reservationDate;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}
		public int getreservationId() {
			return reservationId;
		}
		public void setreservationId(int reservationId) {
			this.reservationId = reservationId;
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
		public String getreservationDate() {
			return reservationDate;
		}
		public void setreservationDate(String reservationDate) {
			this.reservationDate = reservationDate;
		}
		public String getstartDate() {
			return startDate;
		}
		public void setstartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getendDate() {
			return endDate;
		}
		public void setendDate(String endDate) {
			this.endDate = endDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
}
