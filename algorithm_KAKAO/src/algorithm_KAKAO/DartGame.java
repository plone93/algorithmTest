package algorithm_KAKAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame {
	final static String S = "S";
	final static String D = "D";
	final static String T = "T";
	final static String UPGRADE = "*";
	final static String DOWNGRADE = "#";

	public static void main(String[] args) {
		String str = "1D2S3T*";
		char[] temp = str.toCharArray();
		int[] dart = { 0, 0, 0 };
		int step = 0;

		Pattern p = Pattern.compile("([0-9]|10)([SDT])([*#]?)");
		Matcher m = p.matcher(str);

		while(m.find()) {
			int score = Integer.parseInt(m.group(1));
			int bonus = bonus(m.group(2));
			int option = option(m.group(3));
			
			//각 시도 총 좀수
			dart[step] = (int)Math.pow(score, bonus) * option;

			//현재 시도가 첫 번째가 아니고 스타상일 때 2배 적용
			if(step > 0 && option == 2) {
				dart[step-1] *= 2;
			}
			m.group();
			step++;
		}

		System.out.println(dart[0]);
		System.out.println(dart[1]);
		System.out.println(dart[2]);

	}

	

	public static int bonus(String str) {
		int bonus = 0;
		switch(str) {
			case S : bonus=1;break;
			case D : bonus=2;break;
			case T : bonus=3;break;
			default : break;
		}
		return bonus;
	}

	

	public static int option(String str) {
		int num = 1;

		switch(str) {
			case UPGRADE : num = 2;break;
			case DOWNGRADE  : num = -1;break;
			default : num = 1;break;
		}

		return num;

	}

	}


