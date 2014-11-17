import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;

public class Database {

	public static HashMap search(String title, String kind,
			String productionYear) {
		HashMap infoMap = new HashMap();

		infoMap.put("title", new String(title));
		infoMap.put("kind", new String(kind));

		try {

			String infoData[] = { "plot", "runtimes", "genres",
					"release dates", "mpaa", "budget", "gross" };
			
			SimpleMySQL mysql = new SimpleMySQL();
			mysql.connect("71.15.195.219:3306", Login.user, Login.password, "moviedb");
			SimpleMySQLResult result;
			SimpleMySQLResult infoResult = null;

			result = mysql.Query("SELECT * FROM title WHERE title='" + title
					+ "' "
					+ "AND kind_id=(SELECT id FROM kind_type WHERE kind='"
					+ kind + "')");

			ArrayList<String> prodYears = new ArrayList<String>();
			while (result.next()) {
				String year = result.getString("production_year");
				if(year != null)
					prodYears.add(year);
			}

			if (productionYear.equals("*")) {
				if(prodYears.size() > 1)
				{
				productionYear = (String) JOptionPane.showInputDialog(null,
						"Please choose a production year.", title
								+ " Production Year",
						JOptionPane.QUESTION_MESSAGE, null,
						prodYears.toArray(), prodYears.toArray()[0]);
				}
				else
					productionYear = prodYears.get(0);
			}
			infoMap.put("production_year", productionYear);
			
			for (int i = 0; i < infoData.length; i++) {
				infoResult = mysql
						.Query("SELECT * FROM movie_info WHERE movie_id IN(SELECT id FROM title "
								+ "WHERE title='"
								+ title
								+ "' AND kind_id=(SELECT id FROM kind_type WHERE kind='"
								+ kind
								+ "') "
								+ "AND production_year="
								+ productionYear
								+ ") "
								+ "AND info_type_id=(SELECT id FROM info_type WHERE info='"
								+ infoData[i] + "')");

				String in = infoResult.getString("info");
				if(in == null)
					in = "unknown";
				
				infoMap.put(infoData[i],
						new String(in));
			}
			result.close();
			infoResult.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoMap;
	}
}
