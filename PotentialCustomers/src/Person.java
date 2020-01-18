import java.util.List;

public class Person {
	private Integer personId;
	private String name;
	private String lastName;
	private String currentRole;
	private String country;
	private String industry;
	private Integer recommendations;
	private Integer connections;
	private Integer customerValue;

	public Person(Integer personId, String name, String lastName, String currentRole, String country, String industry,
			Integer recommendations, Integer connections) {
		super();
		this.personId = personId;
		if (name != null) {
			this.name = name;
		}
		if (lastName != null) {
			this.lastName = lastName;
		}
		if (currentRole != null) {
			this.currentRole = currentRole;
		}
		if (country != null) {
			this.country = country;
		}
		if (industry != null) {
			this.industry = industry;
		}
		if (recommendations != null) {
			this.recommendations = recommendations;
		}
		if (connections != null) {
			this.connections = connections;
		}
	}
	
	public static Person fromArray(List<String> strList) {
		return new Person(	Integer.valueOf(strList.get(0)), strList.get(1), strList.get(2),
				strList.get(3), strList.get(4), strList.get(5), Integer.valueOf(strList.get(6)),
				Integer.valueOf(strList.get(7)));
	}


	public Integer getPersonId() {
		return personId;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCurrentRole() {
		return currentRole;
	}

	public String getCountry() {
		return country;
	}

	public String getIndustry() {
		return industry;
	}

	public Integer getRecommendations() {
		return recommendations;
	}

	public Integer getConnections() {
		return connections;
	}
	
	public Integer getCustomerValue() {
		return customerValue;
	}

	public void setCustomerValue(Integer customerValue) {
		this.customerValue = customerValue;
	}
}