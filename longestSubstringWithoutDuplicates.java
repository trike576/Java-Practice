import java.util.Scanner;

public class longestSubstringWithoutDuplicates {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text;
        int maxLength = 0;
        System.out.println("Enter some text: ");
        text = scanner.nextLine();

        // loop till end of the string
        for (int i = 0; i < text.length(); i++){
            int length = 0;
            for (int j = i; j < text.length(); j++){
                boolean duplicate = false;
                for (int k = i; k < j; k++){
                    if (text.charAt(k) == text.charAt(j)){
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate){
                    break;
                }
                length++;
            }
            if (length > maxLength){
                maxLength = length;
            }
        }

        System.out.printf("The substring with maximum length with no duplicates has length of %d characters.", maxLength);
    }
}