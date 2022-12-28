

public class Agency {
    private int agencyID;
	private String name;
	private int AddressID;
	private String phoneNumber;
    private String LicenseNumber;

	public Agency(int agencyID, String name, int AddressID, String phoneNumber, String LicenseNumber){
		this.agencyID = agencyID;
		this.name = name;
		this.AddressID = AddressID;
        this.phoneNumber = phoneNumber;
        this.LicenseNumber = LicenseNumber;
	}
}
