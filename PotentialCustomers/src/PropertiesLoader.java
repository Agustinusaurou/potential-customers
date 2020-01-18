import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertiesLoader {
	public List<ImportantWord> loadProperties(String file) {
		List<ImportantWord> words = null;

		Properties p = new Properties();
		
		try {
			InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(file);
			p.load(inputStream);
			for (Enumeration<Object> e = p.keys(); e.hasMoreElements();) {
				Object obj = e.nextElement();
				if(words != null) {
					words.addAll(loadValues(p,obj));	
				}else {
					words = loadValues(p,obj);	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
	
	public static List<ImportantWord> loadValues(Properties p, Object obj) {
		String line =  p.getProperty(obj.toString());
		List<String> strList = new ArrayList<String>();
		List<ImportantWord> words = new ArrayList<ImportantWord>();
		
		strList = Arrays.asList(Pattern.compile("\\|").split(line));
		for(int i = 0; i < strList.size(); i++) {
			words.add(new ImportantWord(obj.toString(), strList.get(i)));
		}
		return words;
	}
	
	public List<ImportantWord> loadRole() {
		String file = "roles.properties";
		List<ImportantWord> words = loadProperties(file);
		return words;
	}
	
	public List<ImportantWord> loadIndustry() {
		String file = "industry.properties";
		List<ImportantWord> words = loadProperties(file);
		return words;
	}
}
