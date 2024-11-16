public class Team {
    private String[] teamNames;
    private int[] teamRatings;
    private String team = "";

    public Team(String teamName) {
        switch (teamName) {
            case "Australia":
                teamNames = new String[] { "David Warner", "Usman Khawaja", "Marnus Labuschagne", "Steve Smith",
                        "Travis Head", "Cameron Green", "Alex Carey", "Mitchell Starc", "Pat Cummins", "Nathan Lyon",
                        "Scott Boland" };
                teamRatings = new int[] { 97, 90, 90, 98, 85, 83, 87, 65, 72, 47, 40 };
                team = "Australia";
                break;
            case "India":
                teamNames = new String[] { "Rohit Sharma", "Shubman Gill", "Cheteshwar Pujara", "Virat Kohli",
                        "Ajinkya Rahane", "Ravindra Jadeja", "KS Bharat", "Shardul Thakur", "Umesh Yadav",
                        "Mohammed Shami",
                        "Mohammed Siraj" };
                teamRatings = new int[] { 95, 90, 81, 98, 80, 87, 75, 78, 67, 45, 40 };
                team = "India";
                break;
            case "England":
                teamNames = new String[] { "Zak Crawley", "Ben Duckett", "Joe Root", "Harry Brook",
                        "Ben Stokes", "Jonny Bairstow", "Chris Woakes", "Mark Wood", "Stuart Broad", "James Anderson",
                        "Ollie Robinson" };
                teamRatings = new int[] { 85, 80, 95, 88, 92, 90, 68, 62, 55, 48, 50 };
                team = "England";
                break;
            case "New Zealand":
                teamNames = new String[] { "Devon Conway", "Tom Latham", "Kane Williamson", "Daryl Mitchell",
                        "Tom Blundell", "Henry Nicholls", "Michael Bracewell", "Mitchell Santner", "Matt Henry",
                        "Tim Southee",
                        "Trent Boult" };
                teamRatings = new int[] { 88, 83, 97, 85, 82, 80, 70, 65, 60, 50, 48 };
                team = "New Zealand";
                break;
            case "Pakistan":
                teamNames = new String[] { "Abdullah Shafique", "Imam-ul-Haq", "Babar Azam", "Mohammad Rizwan",
                        "Saud Shakeel", "Agha Salman", "Naseem Shah", "Shaheen Afridi", "Hasan Ali", "Abrar Ahmed",
                        "Mohammad Nawaz" };
                teamRatings = new int[] { 85, 80, 98, 88, 81, 77, 67, 62, 50, 47, 45 };
                team = "Pakistan";
                break;
            case "Sri Lanka":
                teamNames = new String[] { "Dimuth Karunaratne", "Pathum Nissanka", "Kusal Mendis", "Angelo Mathews",
                        "Dhananjaya de Silva", "Charith Asalanka", "Dinesh Chandimal", "Wanindu Hasaranga",
                        "Kasun Rajitha",
                        "Lahiru Kumara", "Prabath Jayasuriya" };
                teamRatings = new int[] { 87, 82, 89, 90, 84, 78, 85, 70, 58, 50, 45 };
                team = "Sri Lanka";
                break;
            default:
                teamNames = new String[] { "Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7",
                        "Player8",
                        "Player9", "Player10", "Player11" };
                teamRatings = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                team = "Default";
        }
    }

    public String getTeamName() {
        return team;
    }

    public String[] getTeamNames() {
        return teamNames;
    }

    public int[] getTeamRatings() {
        return teamRatings;
    }

    public String toString() {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < 11; i++) {
            s1 += teamNames[i] + ", ";
            s2 += teamRatings[i] + ", ";
        }
        return s1 + "\n" + s2;
    }
}
