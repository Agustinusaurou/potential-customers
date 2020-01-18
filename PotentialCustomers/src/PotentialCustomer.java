import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PotentialCustomer {

	public static void main(String[] args) {
		List<Person> people = PeopleFile.readFilePeople();
		customerValue(people);
		orderPeople(people);
		people = people.stream().limit(100).collect(Collectors.toList());
		PeopleFile.savePeople(people);
	}

	public static void customerValue(List<Person> people) {
		Integer roleValue;
		Integer industryValue;
		
		PropertiesLoader pLoader = new PropertiesLoader();
		List<ImportantWord> roles = pLoader.loadRole();
		List<ImportantWord> industries = pLoader.loadIndustry();
		for (int i = 0; i < people.size(); i++) {
			roleValue = wordValue(people.get(i).getCurrentRole(), roles);
			industryValue = wordValue(people.get(i).getIndustry(), industries);
			people.get(i).setCustomerValue(industryValue * roleValue);
		}

	}

	private static Integer wordValue(String str, List<ImportantWord> words) {
		Integer value = 1;
		
		for(int i = 0; i<words.size(); i++) {
			if(str.contains(words.get(i).getWord())) {
				switch(words.get(i).getImportance()) {
					case "role.priority.first":
						value = value + 10;
						break;
					case "role.priority.second":
						value = value + 8;
						break;
					case "role.priority.third":
						value = value + 6;
						break;
					case "role.priority.forth":
						value = value + 4;
						break;
				}
			}		
		}
		return value;
	}

	public static void orderPeople(List<Person> people) {
		Collections.sort(people, new Comparator<Person>(){
		    public int compare(Person p1, Person p2) {
		        return p1.getCustomerValue().compareTo(p2.getCustomerValue());
		    }
		});
		Collections.reverse(people);
	}
}
