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

    public void FileWrite(String input, String filePath){
        try
        {
            FileWriter fw = new FileWriter(filePath,true); //the true will append the new data
            fw.write(input+"\n");//appends the string to the file
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

        System.out.println(values);
        return values;
    }

}
