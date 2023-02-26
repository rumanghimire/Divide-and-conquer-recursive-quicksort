import java.util.*;
import java.io.*;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        List<Team> teams = new ArrayList<>();  // creates ArrayList
        try {
            File file = new File("game.txt");   // read text file
            Scanner scanner = new Scanner(file);
            int count = 0;   // set count to 0
            if (scanner.hasNextLine()) {   // Check if the program has next line
                count = Integer.parseInt(scanner.nextLine());
            }

            System.out.println("The original list:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                String[] words = line.split(", ");  //Splitting the words
                String teamName = words[0].trim();  // stores the name as per the index       
                String wins = words[1].trim();      // Stores the winning scores
                String draws = words[2].trim();     // Stores the draws scores
                String losses = words[3].trim();    // Stores the losses scores
                Team team = new Team();        //Constructing a Team object
                team.setName(teamName);
                team.setWins(Integer.parseInt(wins));  // Set winning score to team object
                team.setDraws(Integer.parseInt(draws));   //Set drawing scores to team object
                team.setLosses(Integer.parseInt(losses));   
                team.calculatePoints();       // Calculate the points
                teams.add(team);
            }
            scanner.close();    // Closing the text file

            System.out.println("\nThe sorted list: ");   //Sorts the each item based on the scores
            List<Team> sortedTeams = quickSort(teams, 0, teams.size() - 1);
            sortedTeams.forEach(team -> {
                System.out.println(team.toString());
            });

        } catch (FileNotFoundException e) {     // If text file is not read
            System.err.println("Error: File not found: " + args[0]);
            System.exit(1);
        }
    }

    private static List<Team> quickSort(List<Team> teams, int left, int right) {  // Sort the information as per the criteria given
        if (left < right) {
            int pivotIndex = partition(teams, left, right);
            quickSort(teams, left, pivotIndex);
            quickSort(teams, pivotIndex + 1, right);
        }
        return teams;
    }

    private static int partition(List<Team> teams, int left, int right) {
        Team pivot = teams.get(left);
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (teams.get(i).compareTo(pivot) < 0);
            do {
                j--;
            } while (teams.get(j).compareTo(pivot) > 0);
            if (i >= j) {
                return j;
            }
            Collections.swap(teams, i, j);
        }
    }
}
