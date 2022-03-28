import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadWrite {
    private Scanner s = new Scanner(System.in);

    public void FileRead(String filePath){
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

    public boolean CheckDuplicates(String input, String filePath){
        boolean duplicate = false;
        ArrayList<String> words = FileToArray(filePath);
        int count = 0;
        String currentWord;

        while (count<words.size()){
            currentWord = words.get(count).toLowerCase();
            input = input.toLowerCase();

            if (currentWord.equals(input)){
                duplicate = true;
            }
            count++;
        }
        return duplicate;
    }

    public void FileWrite(String input, String filePath){
        boolean duplicate = true;

        try
        {
            duplicate = CheckDuplicates(input, filePath);

            FileWriter fw = new FileWriter(filePath,true); //the true will append the new data
            if(duplicate==true){
                System.err.println("This input is a duplicate");
            } else {
                fw.write(input+"\n");//appends the string to the file
                System.out.println("Successfully added word");
            }
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public ArrayList<String> FileToArray(String filePath){
        String read;
        ArrayList<String> values = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while((read = br.readLine()) !=null){
                values.add(read);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return values;
    }

}
