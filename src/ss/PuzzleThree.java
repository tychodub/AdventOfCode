package ss;
import java.io.*;
import java.util.Arrays;

public class PuzzleThree {
    private static String CompareSonar(int[] sonar) {
        return "";
    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\tycho\\Documents\\SoftwareSystemsModule\\TESTLAMP\\src\\ss\\input");
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String sonarLord;
            String[] sonarList = new String[1000];
            String[] sonarSplit = new String[12];
            int oneCount = 0;
            int zeroCount = 0;
            String gamma = "";
            String epsilon = "";
            for (int k=0; (sonarLord = br.readLine()) != null; k++) {
                sonarList[k] = sonarLord;
            }
            for (int j=0;j <=11 ; j++) {
                oneCount = 0;
                zeroCount = 0;
                for (int i = 0; i < sonarList.length; i++) {
                    sonarSplit = sonarList[i].split("");
                    if (Integer.parseInt(sonarSplit[j]) == 1) {
                        oneCount = oneCount + 1;
                    }
                    else {
                        zeroCount = zeroCount + 1;
                    }
                }
                if (oneCount > zeroCount) {
                    gamma = gamma+1;
                    epsilon = epsilon+0;
                }
                else {
                    gamma = gamma+0;
                    epsilon = epsilon+1;
                }
            }
            System.out.println("gamma: "+gamma);
            System.out.println("epsilon: "+epsilon);
            int lastNumber = 0;
            int lastLifeNumber = 0;
            String oxygen = "";
            String lifeRating = "";
            for (int l=0;l<sonarList.length;l++) {
                sonarSplit = sonarList[l].split("");
                for (int h=0; sonarSplit[h].equals(gamma.split("")[h]); h++) {
                    if (sonarSplit[h+1] != gamma.split("")[h+1] && lastNumber<h) {
                        lastNumber = h;
                        oxygen = sonarList[l];
                    }
                }
                for (int m=0; sonarSplit[m].equals(epsilon.split("")[m]); m++) {
                    if (sonarSplit[m+1] != epsilon.split("")[m+1] && lastLifeNumber<m) {
                        lastLifeNumber = m;
                        lifeRating = sonarList[l];
                    }
                }
            }
            System.out.println("oxygen: "+oxygen);
            System.out.println("liferating: "+lifeRating);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
