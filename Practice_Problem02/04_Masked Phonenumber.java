import java.lang.Character;
import java.lang.StringBuilder;

public class Problem4 {

    public String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4Digits = phone.substring(6);
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.insert(6, "-");
        masked.append(last4Digits);

        return masked.toString();
    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        System.out.println(p.maskPhoneNumber("9876543210"));
        System.out.println(p.maskPhoneNumber("98765"));
    }
}
