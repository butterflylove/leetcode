package practice;

public class RegexTest {
	public static void main(String[] args){
		String url = "adas?sadsa/sad:::::adas*dasd|das<dasd>";
		url=url.replaceAll("[\\?/:*|<>\"]", "_");
		System.out.print(url);
	}
}
