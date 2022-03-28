import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args){
        String filePath = null;

        Scanner s = new Scanner(System.in);
        try{
            System.out.println("Please enter file path in the format diskLetter:/dir/textfile.txt :");
            filePath = s.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }

        String read;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while((read = br.readLine()) !=null){
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
