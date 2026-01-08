import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Scanner;

public class  Main{
    public static void main(String[] args){
       String filePath = "C:\\Users\\Lenovo\\Downloads\\song.wav";
       File file = new File(filePath);

       try(Scanner scanner = new Scanner(System.in);
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);){

           Clip clip = AudioSystem.getClip();
           clip.open(audioStream);

           String response = " ";
           while(!response.equals("Q")){
               System.out.println("""
                       P = Play
                       S = Stop
                       R = Reset
                       Q = Quit
                       Enter your choice: 
                       """);
               response = scanner.next().toUpperCase();
               switch (response){
                   case "P" -> clip.start();
                   case "S" -> clip.stop();
                   case "R" -> clip.setMicrosecondPosition(0);
                   case "Q" -> clip.close();
                   default -> System.out.println("Invalid Choice!!");
               }
           }
       }

       catch (FileNotFoundException e){
           System.out.println("Coulf not locate file.");
       }
       catch (UnsupportedAudioFileException e){
           System.out.println("Audio file is not supported.");
       }
       catch (LineUnavailableException e){
           System.out.println("Unavailable to acces audio resource.");
       }
       catch(IOException e){
           System.out.println("Something went wrong.");
       }
       finally {
           System.out.println("Bye!");
       }
    }
}