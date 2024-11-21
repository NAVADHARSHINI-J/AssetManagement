package entity;

public class Asset {
       private int assetId;
       private String name;
       private String type;
       private int serialNumber;
       private String purchaseDate;
       private String location;
       private String status;
       private int ownerId;
	public Asset(int assetId, String name, String type, int serialNumber, String purchaseDate, String location,
			String status, int ownerId) {
		super();
		this.assetId = assetId;
		this.name = name;
		this.type = type;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.location = location;
		this.status = status;
		this.ownerId = ownerId;
	}
	public int getassetId() {
		return assetId;
	}
	public void setassetId(int assetId) {
		this.assetId = assetId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getserialNumber() {
		return serialNumber;
	}
	public void setserialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getpurchaseDate() {
		return purchaseDate;
	}
	public void setpurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getownerId() {
		return ownerId;
	}
	public void setownerId(int ownerId) {
		this.ownerId = ownerId;
	}
       
}
