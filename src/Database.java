import java.util.HashMap;

import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;


public class Database {
	
	public static HashMap search(String title, String kind, String productionYear)
	{
		HashMap infoMap = new HashMap();
		
		infoMap.put("title", new String(title));
		infoMap.put("kind", new String(kind));

		try {
			//String url = "jdbc:mysql://71.15.195.219:3306/moviedb";
			
			String infoData[] = {"plot","runtimes","genres","release dates","mpaa","budget","gross"};
			SimpleMySQL mysql = new SimpleMySQL();
			mysql.connect("71.15.195.219:3306", "root","","moviedb");
			SimpleMySQLResult result;
			SimpleMySQLResult infoResult = null;
			
			/*
			 * The following query gets all movies somePerson played in
			 * and sorts them from oldest to newest made.
			 */
			result = mysql.Query("SELECT * FROM title WHERE title='"+title+"' "
					+ "AND kind_id=(SELECT id FROM kind_type WHERE kind='"+kind+"')");
			
			while(result.next())
			{
				String movie = result.getString("production_year");
				System.out.println(movie);
			}
			
			for(int i = 0; i < infoData.length; i++)
			{
				infoResult = mysql.Query("SELECT * FROM movie_info WHERE movie_id IN(SELECT id FROM title "
						+ "WHERE title='"+title+"' AND kind_id=(SELECT id FROM kind_type WHERE kind='"+kind+"') "
								+ "AND production_year="+productionYear+") "
										+ "AND info_type_id=(SELECT id FROM info_type WHERE info='"+infoData[i]+"')");
				
				infoMap.put(infoData[i], new String(infoResult.getString("info")));
				//System.out.println(infoResult.getString("info"));
			}
			result.close();
			infoResult.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hello!!!");
		return infoMap;
	}
}
