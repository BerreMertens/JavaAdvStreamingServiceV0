package be.pxl.ja.streamingservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";

	public static int calculateStrength(String password) {
		List<Boolean> requirementsPasswordStrength = new ArrayList<>();
		int passwordLength=password.length();
		int passwordStrength;
		boolean isNumeric;
		boolean isLowerCase;
		boolean isUpperCase;
		boolean isSpecialCharacter;

		if (passwordLength < 6){
			passwordStrength =0;
			return passwordStrength;
		}else if (passwordLength <= 10){
			passwordStrength=1;
		}else {
			passwordStrength=2;
		}

		requirementsPasswordStrength.add(password.chars().distinct().anyMatch(Character::isDigit));
		requirementsPasswordStrength.add(password.chars().distinct().anyMatch(Character::isLowerCase));
		requirementsPasswordStrength.add(password.chars().distinct().anyMatch(Character::isUpperCase));
		requirementsPasswordStrength.add(password.chars().distinct().anyMatch(ch->SPECIAL_CHARACTERS.contains(String.valueOf(((char) ch)))));


		for (boolean bool:requirementsPasswordStrength) {
			if(bool){
				passwordStrength+=2;
			}
		}

		return passwordStrength;
	}
}
