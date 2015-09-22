package sevencm.tools.regx;

import java.util.regex.Pattern;

public class CharsetFilter {
	
	public enum FilterType{
		CHINESE,
		LETTER,
		MIX;
	}
	
	private final static String regExChinese = "[\u4e00-\u9fa5]";
	private final static Pattern pChinese = Pattern.compile(regExChinese);
	
	//过滤字母关键字
	private final static String regExLetter ="[A-Za-z]";
	private final static Pattern pLetter = Pattern.compile(regExLetter);
	
	//过滤字母中文混合关键字
	private final static String regExChineseLetter ="[A-Za-z\u4e00-\u9fa5]";
	private final static Pattern pChineseLetter = Pattern.compile(regExChineseLetter);
	
	/**
	 * 返回过滤后的字符
	 * @param content
	 * @param type
	 * @return
	 */
	public static String getFilterCharset(String content, FilterType type){
		if(content!=null){
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < content.length(); i++) {
				String one = content.substring(i, i + 1);
				if (type == FilterType.CHINESE && pChinese.matcher(one).matches()) {
					str.append(one);
				}else if(type == FilterType.LETTER && pLetter.matcher(one).matches()){
					str.append(one);
				}else if(type == FilterType.MIX && pChineseLetter.matcher(one).matches()){
					str.append(one);
				}
			}
			return str.toString();
		}
		return null;
	}
	
}
