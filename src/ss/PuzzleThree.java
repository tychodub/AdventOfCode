package ss;
import java.io.*;

public class PuzzleThree {
    private static String gamma = "";
    private static String epsilon = "";
    private static int oneCount = 0;
    private static int zeroCount = 0;
    private static String[] sonarSplit = new String[12];
    private static String oxygen = "";
    private static String lifeRating = "";
    private static String epsilonUpdate = "";
    private static String gammaUpdate = "";

    private static void CompareSonar(String[] sonar) {
        for (int j = 0; j <= 11; j++) {
            oneCount = 0;
            zeroCount = 0;
            for (int i = 0; i < sonar.length; i++) {
                sonarSplit = sonar[i].split("");
                if (Integer.parseInt(sonarSplit[j]) == 1) {
                    oneCount = oneCount + 1;
                } else {
                    zeroCount = zeroCount + 1;
                }
            }
            if (oneCount >= zeroCount) {
                gamma = gamma + 1;
                epsilon = epsilon + 0;
            } else {
                gamma = gamma + 0;
                epsilon = epsilon + 1;
            }
        }
    }

    private static void CompareGamma(String[] sonar) {
        gamma = "";
        for (int j = 0; j <= 11; j++) {
            oneCount = 0;
            zeroCount = 0;
            for (int i = 0; i < sonar.length; i++) {
                if (sonar[i] != null) {
                    sonarSplit = sonar[i].split("");
                    if (Integer.parseInt(sonarSplit[j]) == 1) {
                        oneCount = oneCount + 1;
                    } else {
                        zeroCount = zeroCount + 1;
                    }
                }
            }
            if (oneCount >= zeroCount) {
                gamma = gamma + 1;
            } else {
                gamma = gamma + 0;
            }
        }
    }

    private static void CompareEpsilon(String[] sonar) {
        epsilon = "";
        for (int j = 0; j <= 11; j++) {
            oneCount = 0;
            zeroCount = 0;
            for (int i = 0; i < sonar.length; i++) {
                if (sonar[i] != null) {
                    sonarSplit = sonar[i].split("");
                    if (Integer.parseInt(sonarSplit[j]) == 1) {
                        oneCount = oneCount + 1;
                    } else {
                        zeroCount = zeroCount + 1;
                    }
                }
            }
            if (oneCount >= zeroCount) {
                epsilon = epsilon + 0;
            } else {
                epsilon = epsilon + 1;
            }
        }
    }
    public static void oxygenListUpdater(String[] sonar) {
        for (int p = 1; p <= 12; p++) {
            oxygen = "";
            for (int l = 0; l < sonar.length; l++) {
                if (sonar[l] != null) {
                    sonarSplit = sonar[l].split("");
                    if (!sonarSplit[p].equals(gamma.split("")[p])) {
                        sonar[l] = null;
                    }
                }
            }
            CompareGamma(sonar);
            for (int k = 0; k<sonar.length; k++) {
                if (sonar[k] != null) {
                    oxygen = oxygen + sonar[k];
                }
            }
            if (oxygen.length() == 12) {
                break;
            }
        }
    }

    public static void liferatingListUpdater(String[] sonar) {
        for (int p = 1; p <= 12; p++) {
            lifeRating = "";
            for (int l = 0; l < sonar.length; l++) {
                if (sonar[l] != null) {
                    sonarSplit = sonar[l].split("");
                    if (!sonarSplit[p].equals(epsilon.split("")[p])) {
                        sonar[l] = null;
                    }
                }
            }
            CompareEpsilon(sonar);
            for (int k = 0; k<sonar.length; k++) {
                if (sonar[k] != null) {
                    lifeRating = lifeRating + sonar[k];
                }
            }
            if (lifeRating.length() == 12) {
                break;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\tycho\\Documents\\SoftwareSystemsModule\\TESTLAMP\\src\\ss\\input");
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String sonarLord;
            String[] sonarList = new String[1000];
            for (int k = 0; (sonarLord = br.readLine()) != null; k++) {
                sonarList[k] = sonarLord;
            }

            CompareSonar(sonarList);
            System.out.println("gamma: " + gamma);
            System.out.println("epsilon: " + epsilon);
            String[] oxygenList = new String[1000];
            String[] lifeRatingList = new String[1000];
            for (int l = 0; l < sonarList.length; l++) {
                sonarSplit = sonarList[l].split("");
                if (sonarSplit[0].equals(gamma.split("")[0])) {
                    oxygenList[l] = sonarList[l];
                }
                if (sonarSplit[0].equals(epsilon.split("")[0])) {
                    lifeRatingList[l] = sonarList[l];
                }
            }
            CompareGamma(oxygenList);
            CompareEpsilon(lifeRatingList);
            liferatingListUpdater(lifeRatingList);
            oxygenListUpdater(oxygenList);
            System.out.println("oxygen: "+oxygen);
            System.out.println("liferating: "+lifeRating);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
