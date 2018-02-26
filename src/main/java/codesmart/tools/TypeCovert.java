package codesmart.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auth fkxuexi
 * Date 2017/9/25
 * QQ群：fkxuexi.top   570980002
 */
public class TypeCovert {

	/**
	 * 用于列明的转换
     * @param underline
     * @return 数据库的风格和java的风格转换
	 */
	public static String underline2hump(String underline){
		return underline2hump(underline, false);
	}
	
	
    /**
     * 用于表名到类名的转换
     * @param underline
     * @param isFirstUp
     * @return 数据库的风格和java的风格转换
     */
    public static String underline2hump(String underline, boolean isFirstUp) {
        String regex = "([A-Za-z\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(underline);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(Character.toUpperCase(word.charAt(0))+word.substring(1,word.length()));
        }
        String result = sb.toString();
        return isFirstUp?result:Character.toLowerCase(result.charAt(0))+result.substring(1,result.length());
    }
}
