import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PeopleFile {

	public static List<Person> readFilePeople() {
		Scanner input = readFile();
		List<Person> peopleList = loadList(input);	
		if (input != null) {
			input.close();
		}
		return peopleList;		
	}
	
	public static List<Person> loadList(Scanner input) {
		String line = null;
		List<Person> people = new ArrayList<Person>();
		List<String> strList = new ArrayList<String>();

		while (input.hasNext()) {
			line = input.nextLine();
			strList = Arrays.asList(Pattern.compile("\\|").split(line));
			people.add(Person.fromArray(strList));
		}
		return people;
	}

	public static Scanner readFile() {
		JFileChooser fileChooser = new JFileChooser();
		Scanner input = null;

		fileChooser.showOpenDialog(fileChooser);
		String route = fileChooser.getSelectedFile().getAbsolutePath();
		File file = new File(route);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void savePeople(List<Person> people) {
		try {
			File file = new File("people");
			if (file != null) {
				FileWriter fwriter = new FileWriter(file + ".out");
				for (int i = 0; i < people.size(); i++) {
					fwriter.write(people.get(i).getPersonId().toString() + "\n");
				}
				fwriter.close();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado");
		}
	}
}