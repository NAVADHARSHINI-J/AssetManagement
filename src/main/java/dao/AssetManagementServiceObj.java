package dao;

public class AssetManagementServiceObj {
		public static AssetManagementService getObject() {
			return new AssetManagementServiceImpl();		
		}
}
