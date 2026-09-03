import java.lang.Character;
import java.lang.StringBuilder;

public class Problem5 {

    public String normalizeReference(String raw) {
        raw = raw.trim();
        if (raw.length() < 3) {
            return raw;
        }

        String bankCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bankCode + rest;
    }

    public String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem5 p = new Problem5();
        
        String input1 = p.normalizeReference(" hdf03022600042 ");
        System.out.println(p.validateAndFormat(input1));

        String input2 = p.normalizeReference("12F03022600042");
        System.out.println(p.validateAndFormat(input2));
    }
}
