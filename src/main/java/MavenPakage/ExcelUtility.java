package MavenPakage;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ExcelUtility {
    
   // @Test
    public int sheetNumber() {
    	Scanner input = new Scanner(System.in);
        System.out.print("Enter Sheet number: ");
        int sheetNumber = input.nextInt();
        return sheetNumber;
    }
}