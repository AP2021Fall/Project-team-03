package model;

public class User {
    private final String name;

    private final String username;
    public int id;
    private String password1;
    private String password2;
    private String email;
    private Role role;
    private final String birthday;

    public static void main(String[] args) {
        Admin admin = new Admin("", "", ",", "");

    }

    Database database = new Database();

    public User(String name, String username, String password, String email) {
        this.name = name;
    public User(String username, String password, String email, String birthday) {
            this.username = username;
            this.password1 = password;
            this.email = email;
            this.birthday = birthday;

        }

        public String getName () {
            return name;
        }

        public String getUsername () {
            return username;
        }

        public Role getRole () {
            return role;
            public String getPassword () {
                return password1;
            }

            public void setRole (Role newRole){
                role = newRole;
                public String getEmail () {
                    return email;
                }

                public int getId () {
                    return id;
                    public String getBirthday () {
                        return birthday;
                    }

                    public void setPassword (String password, String password2){
                        @ -48, 93 + 44, 20 @@public class User {
        this.password2 =password2;
                        }

                        public String showTeams () {
                            String showTeam = "";
                            String teamName;
                            for (int i = teams.size(); i > 0; i--) {
                                teamName = teams.get(i).getName();
                                showTeam += String.valueOf(teams.size() - i + 1) + ". " + teamName + "\n";
                            }
                            return showTeam;
                            public boolean isPasswordCorrect (String password){
                                return this.password1.equals(password);
                            }

                            public String showTeam (String teamName){
                                Team team = Team.getTeamByName(teamName);
                                //  Team team = Team.getTeamByName(teamName);
                                String showTeam;
                                ArrayList<String> member = team.getMember();
                                //  ArrayList<String> member = team.getMember();
                                int n = 1;
                                showTeam = "name: " + teamName + "\n";
                                showTeam += "leader: " + team.getLeader().name + "\n";
                                if (!team.getLeader().name.equals(name)) {
                                    showTeam += "1. " + name + "\n";
                                    n++;
                                }
                                for (int i = 1; i <= member.size(); i++) {
                                    if (member.get(i).equals(name)) {
                                        member.remove(name);
                                    }
                                }
                                for (String Name : member) {
                                    showTeam += n + ". " + Name + "\n";
                                }
                                // showTeam += "leader: "+team.getLeader().name+"\n";
                                // if(!team.getLeader().name.equals(name)){
                                //showTeam += "1. " + name + "\n";
                                n++;
                                return showTeam;
                            }

                            public String showTeamTasks (String teamName){
                                Team team = Team.getTeamByName(teamName);
                                return team.showTasks();
                            }

                            public String showTeam (String teamName){
                                Team team = Team.getTeamByName(teamName);
                                String showTeam;
                                ArrayList<String> member = team.getMember();
                                int n = 1;
                                showTeam = "name: " + teamName + "\n";
                                showTeam += "leader: " + team.getLeader().name + "\n";
                                if (!team.getLeader().name.equals(name)) {
                                    showTeam += "1. " + name + "\n";
                                    n++;
                                }
                                for (int i = 1; i <= member.size(); i++) {
                                    if (member.get(i).equals(name)) {
                                        member.remove(name);
                                    }
                                }
                                for (String Name : member) {
                                    showTeam += n + ". " + Name + "\n";
                                }
                                return showTeam;
                            }

                            public static String showProfile (String username){
                                User user = getUserByUsername(username);
                                return user.showProfile();
                            }

                            public boolean teamsExists () {
                                if (teams.size() > 0) {
                                    return true;
                                }
                                return false;
                            }

                            public boolean teamExists (String Name){
                                for (Team team : teams) {
                                    if (team.getName().equals(Name)) {
                                        return true;
                                    }
                                }
                                return false;
                            }

                            public boolean teamExists ( int Id){
                                for (Team team : teams) {
                                    if (team.getId() == id) {
                                        return true;
                                    }
                                }
                                return false;
                            }

                        }