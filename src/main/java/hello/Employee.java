package hello;

public class Employee {

	
	

	
    @Override
	public String toString() {
		return "Employee [empno=" + empno + ", description=" + description + ", createdbyUserId=" + createdbyUserId
				+ "]";
	}

	private String empno;
	
	private String description;
	
	private String createdbyUserId;

	public String getId() {
		return empno;
	}

	public void setId(String id) {
		this.empno = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedbyUserId() {
		return createdbyUserId;
	}

	public void setCreatedbyUserId(String createdbyUserId) {
		this.createdbyUserId = createdbyUserId;
	}
	
}
