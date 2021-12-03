package ss;
import java.io.*;
import java.lang.reflect.Array;

public class PuzzleTwo {
    private static String CompareSonar(int[] sonar) {
        return "";
    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\tycho\\Documents\\Advent of code\\Advent of Code\\inputDay2");
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            int horizontalCount = 0;
            int depthCount = 0;
            int aim = 0;
            String sonarLord;
            String[] sonarList = new String[1000];
            String[] sonarSplit = new String[2];
            for (int k=0;(sonarLord = br.readLine()) != null; k++) {
                if (sonarLord != null) {
                    sonarSplit = sonarLord.split(" ");
                    if (sonarSplit != null && sonarSplit[0].contains("forward")) {
                        horizontalCount = horizontalCount + Integer.parseInt(sonarSplit[1]);
                        depthCount = depthCount + (aim*Integer.parseInt(sonarSplit[1]));
                    }
                    else if (sonarSplit != null && sonarSplit[0].contains("down")) {
                        aim = aim + Integer.parseInt(sonarSplit[1]);
                    }
                    else if (sonarSplit != null) {
                        aim = aim - Integer.parseInt(sonarSplit[1]);
                    }
                }
            }
            System.out.println("horizontal"+horizontalCount);
            System.out.println("depth"+depthCount);
            int multipliedSonar = horizontalCount*depthCount;
            System.out.println("multiplied"+multipliedSonar);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
