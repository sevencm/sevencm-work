package sevencm.tools.test.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class TestHttp {
 
	
	@Test
	public void test1() throws Exception {
			String host = "http://huaban.com/pins/207763674/";
			Document doc =Jsoup.connect(host).timeout(60000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
			Elements link = doc.select("a").select("img");
			System.out.println(doc);
			for(int i=0,len=link.size();i<len;i++){
				Element elt = link.get(i);
				System.out.println(elt);
		}
	}
	
}

