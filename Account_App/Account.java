package acc_app;

public class Account {
	private int id;
	private String name;
	private String address;
	private double balance;
	private long mobileNo;
	private int minimumBalance = 500;

	Account(int id, String name, String address, double balance, long mobileNo) {
		this(id, name, address, mobileNo);
		if (balance <= minimumBalance)
			this.balance = 500;
		else
			this.balance = balance;
	}

	Account(int id, String name, String address, long mobileNo) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
