import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Get team names:
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Team 1 Name: ");
        String team1Name = sc.nextLine();
        System.out.println("Enter Team 2 Name: ");
        String team2Name = sc.nextLine();

        // Initalize Teams
        Team team1 = new Team(team1Name);
        Team team2 = new Team(team2Name);

        // Initalize Squads
        String[] team1Squads = new String[11];
        int[] team1Ratings = new int[11];

        String[] team2Squads = new String[11];
        int[] team2Ratings = new int[11];

        String realTeam1Name;
        String realTeam2Name;

        // CHECK IF ANYTHING NEEDS TO BE REPLACED
        System.out.println(team1);
        System.out.println(team2);
        do {
            sc.nextLine();
            System.out.println("Does a player need to be replaced? (Type yes or no)");
            String needsReplacement = sc.nextLine();
            if (needsReplacement.equals("no"))
                break;
            System.out.println("What team?");
            String team = sc.nextLine();

            if (team1.getTeamName().equals(team)) {
                System.out.println("What index (ex: Rohit Sharma is 1 and Siraj is 11)");
                int index = sc.nextInt();
                sc.nextLine();

                System.out.println("Who is the replacement?");
                String newPlayer = sc.nextLine();

                System.out.println("What is the new rating?");
                int newRating = sc.nextInt();

                replacePlayer(newPlayer, newRating, index, team1.getTeamNames(), team1.getTeamRatings());
                System.out.println(team1);
            } else if (team2.getTeamName().equals(team)) {
                System.out.println("What index (ex: Rohit Sharma is 1 and Siraj is 11)");
                int index = sc.nextInt();
                sc.nextLine();

                System.out.println("Who is the replacement?");
                String newPlayer = sc.nextLine();

                System.out.println("What is the new rating?");
                int newRating = sc.nextInt();

                replacePlayer(newPlayer, newRating, index, team2.getTeamNames(), team2.getTeamRatings());
                System.out.println(team2);
                sc.nextLine();
            }
        } while (true);
        // Toss:
        double prob = Math.random();
        if (prob >= 0 && prob < 0.25) {
            System.out.println(team1Name + " wins the toss and chooses to bat.");
            System.out.println();

            realTeam1Name = team1Name;
            realTeam2Name = team2Name;
            team1Squads = team1.getTeamNames();
            team1Ratings = team1.getTeamRatings();
            team2Squads = team2.getTeamNames();
            team2Ratings = team2.getTeamRatings();
        } else if (prob >= 0.25 && prob < 0.5) {
            System.out.println(team1Name + " wins the toss and chooses to bowl.");
            System.out.println();

            realTeam1Name = team2Name;
            realTeam2Name = team1Name;

            team1Squads = team2.getTeamNames();
            team1Ratings = team2.getTeamRatings();
            team2Squads = team1.getTeamNames();
            team2Ratings = team1.getTeamRatings();
        } else if (prob >= 0.5 && prob < 0.75) {
            System.out.println(team2Name + " wins the toss and chooses to bowl.");
            System.out.println();

            realTeam1Name = team1Name;
            realTeam2Name = team2Name;

            team1Squads = team1.getTeamNames();
            team1Ratings = team1.getTeamRatings();
            team2Squads = team2.getTeamNames();
            team2Ratings = team2.getTeamRatings();
        } else if (prob >= 0.75 && prob < 1) {
            System.out.println(team2Name + " wins the toss and chooses to bat.");
            System.out.println();

            realTeam1Name = team2Name;
            realTeam2Name = team1Name;

            team1Squads = team2.getTeamNames();
            team1Ratings = team2.getTeamRatings();
            team2Squads = team1.getTeamNames();
            team2Ratings = team1.getTeamRatings();
        } else {
            realTeam1Name = "N/A";
            realTeam2Name = "N/A";
        }

        Thread.sleep(1000);

        // FIRST INNINGS FIRST TEAM BATTING
        int[] team1Scored = new int[11];
        int firstBatTotal = 0;
        for (int i = 0; i < 11; i++) {
            team1Scored[i] = scored(team1Ratings[i]);
            firstBatTotal += team1Scored[i];
            System.out.println(team1Squads[i] + "..............." + team1Scored[i]);
        }
        System.out.println("_____________________________________");
        System.out.println(realTeam1Name + " total: " + firstBatTotal + "/10");
        System.out.println();
        System.out.println();

        Thread.sleep(2000);

        // FIRST INNINGS SECOND TEAM BATTING
        int[] team2Scored = new int[11];
        int secondBatTotal = 0;
        for (int i = 0; i < 11; i++) {
            team2Scored[i] = scored(team2Ratings[i]);
            secondBatTotal += team2Scored[i];
            System.out.println(team2Squads[i] + "..............." + team2Scored[i]);
        }
        System.out.println("_____________________________________");
        System.out.print(realTeam2Name + " total: " + secondBatTotal + "/10,");
        if (firstBatTotal - secondBatTotal == 0) {
            System.out.print(" " + realTeam1Name + " trails by 0");
        } else if (firstBatTotal - secondBatTotal > 0) {
            System.out.print(" " + realTeam1Name + " leads by " + (firstBatTotal - secondBatTotal));
        } else if (firstBatTotal - secondBatTotal < 0) {
            System.out.print(" " + realTeam1Name + " trails by " + (secondBatTotal - firstBatTotal));
        }
        System.out.println();
        System.out.println();

        Thread.sleep(1000);

        // SECOND INNINGS FIRST BAT
        int[] team1ScoredInnings2 = new int[11];
        int thirdBatTotal = 0;
        for (int i = 0; i < 11; i++) {
            team1ScoredInnings2[i] = scored(team1Ratings[i]);
            thirdBatTotal += team1ScoredInnings2[i];
            System.out.println(team1Squads[i] + "..............." + team1ScoredInnings2[i]);
        }

        int chase = ((firstBatTotal + thirdBatTotal) - secondBatTotal);
        if (chase < 0) {
            System.out.println("_____________________________________");
            System.out.println(realTeam1Name + " total: " + thirdBatTotal + "/10, " + realTeam2Name + " wins by an innings and "
                    + Math.abs(((firstBatTotal + thirdBatTotal) - secondBatTotal)));
            System.out.println();
            System.exit(0);
        }

        System.out.println("_____________________________________");
        System.out.println(realTeam1Name + " total: " + thirdBatTotal + "/10, " + realTeam2Name + " need: " + chase);
        System.out.println();
        System.out.println();

        Thread.sleep(1000);

        // SECOND INNINGS SECOND TEAM BATTING
        int fourthBatTotal = 0;
        int[] team2ScoredInnings2 = new int[11];
        int i;
        for (i = 0; i < 2; i++) {
            team2ScoredInnings2[i] = scored(team2Ratings[i]);
            fourthBatTotal += team2ScoredInnings2[i];
                System.out.println(team2Squads[i] + "..............." + team2ScoredInnings2[i]);
                if (chase - fourthBatTotal <= 0) {
                System.out.println("_____________________________________");
                System.out.println(realTeam2Name + " total: " + fourthBatTotal + "/" + i + ", " + realTeam2Name
                        + " wins by 10 wickets");

                break;
            } 
        }
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] --> [0, 1] + [2, 3, 4, 5, 6, 7, 8, 9, 10] = 10- (i - 1)
        for (i = 2; i < 11; i++) {
            team2ScoredInnings2[i] = scored(team2Ratings[i]);
            fourthBatTotal += team2ScoredInnings2[i];
            if (chase - fourthBatTotal <= 0) {
                System.out.println(team2Squads[i] + "..............." + team2ScoredInnings2[i]);
                System.out.println("_____________________________________");
                System.out.println(realTeam2Name + " total: " + fourthBatTotal + "/" + (i - 1) + ", " + realTeam2Name
                        + " wins by " + (10 - (i - 1)) + " wickets");
                int[] winningTeamScores = new int[11];
                for (int j = 0; j < 11; j++) {
                    winningTeamScores[i] = team2ScoredInnings2[i] + team2Scored[i];
                }
                System.out.println(mom(team2Squads, winningTeamScores));
                break;
            } 
        }
        if (chase - fourthBatTotal > 0) {
            for (int j = 0; j < 11; j++) {
                System.out.println(team2Squads[j] + "..............." + team2ScoredInnings2[j]);
            }
            System.out.println("_____________________________________");
            System.out.println(realTeam2Name + " total: " + fourthBatTotal + "/10, " + realTeam1Name + " wins by "
                    + (chase - fourthBatTotal) + " runs");
            int[] winningTeamScores = new int[11];
            for (int j = 0; j < 11; j++) {
                winningTeamScores[j] = team1ScoredInnings2[j] + team1Scored[j];
            }
            System.out.println(mom(team1Squads, winningTeamScores));
        }
    }

    public static int scored(int rating) {
        double prob = Math.random();
        double num = prob * 100;
        if (rating >= 90) {
            if (num >= 99.999)
                return (int) (prob * 51) + 350; // 350-400
            else if (num >= 99.989)
                return (int) (prob * 51) + 300; // 300-350
            else if (num >= 99.889)
                return (int) (prob * 51) + 250; // 250-300
            else if (num >= 99.389)
                return (int) (prob * 51) + 200; // 200-250
            else if (num >= 98.389)
                return (int) (prob * 51) + 150; // 150-200
            else if (num >= 93.389)
                return (int) (prob * 51) + 100; // 100-150
            else if (num >= 84.389)
                return (int) (prob * 21) + 80; // 80-100
            else if (num >= 69.389)
                return (int) (prob * 21) + 60; // 60-80
            else if (num >= 44.389)
                return (int) (prob * 21) + 40; // 40-60
            else if (num >= 24.389)
                return (int) (prob * 11) + 30; // 30-40
            else if (num >= 9.389)
                return (int) (prob * 21) + 10; // 10-30
            else if (num >= 0)
                return (int) (prob * 11); // 0-10
            else
                return 0;
        } else if (rating >= 80 && rating < 90) {
            if (num >= 99.99)
                return (int) (prob * 51) + 200; // 200-250
            else if (num >= 99.89)
                return (int) (prob * 51) + 150; // 150-200
            else if (num >= 98.89)
                return (int) (prob * 51) + 100; // 100-150
            else if (num >= 93.89)
                return (int) (prob * 21) + 80; // 80-100
            else if (num >= 84.89)
                return (int) (prob * 21) + 60; // 60-80
            else if (num >= 69.89)
                return (int) (prob * 21) + 40; // 40-60
            else if (num >= 39.89)
                return (int) (prob * 21) + 20; // 20-40
            else if (num >= 24.89)
                return (int) (prob * 11) + 10; // 10-20
            else if (num >= 0)
                return (int) (prob * 11) + 0; // 0-10
            else
                return 0;
        } else if (rating >= 60 && rating < 80) {
            if (num >= 99.99)
                return (int) (prob * 51) + 100; // 100-150
            else if (num >= 98.99)
                return (int) (prob * 21) + 80; // 80-100
            else if (num >= 93.99)
                return (int) (prob * 21) + 60; // 60-80
            else if (num >= 84.99)
                return (int) (prob * 21) + 40; // 40-60
            else if (num >= 59.99)
                return (int) (prob * 21) + 20; // 20-40
            else if (num >= 29.99)
                return (int) (prob * 11) + 20; // 10-20
            else if (num >= 0)
                return (int) (prob * 11) + 0; // 0-10
            else
                return 0;
        } else if (rating >= 30 && rating < 60) {
            if (num >= 95)
                return (int) (prob * 21) + 40; // 40-60
            else if (num >= 80)
                return (int) (prob * 21) + 20; // 20-40
            else if (num >= 60)
                return (int) (prob * 11) + 10; // 10-20
            else if (num >= 0)
                return (int) (prob * 11) + 0; // 0-10
            else
                return 0;
        } else
            return 0;

    }

    public static void replacePlayer(String newPlayer, int newRating, int index, String[] teamNames,
            int[] teamRatings) {
        teamNames[index - 1] = newPlayer;
        teamRatings[index - 1] = newRating;
    }

    public static String mom(String[] winningTeamNames, int[] winningTeamScores) {
        int highest = 0;
        int highestIndex = 0;
        for (int i = 0; i < 11; i++) {
            if (highest < winningTeamScores[i]) {
                highest = winningTeamScores[i];
                highestIndex = i;
            }
        }
        return "The Man of the Match Award is presented to... " + winningTeamNames[highestIndex]
                + ". Congrats on the honor, and here is a check work $10,000";
    }
}
