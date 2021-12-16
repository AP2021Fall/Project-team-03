package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeamMenu extends Menu {
    public TeamMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {

        subMenus.put(2, new BoardMenu("BoardMenu", this));
        super.show();
        System.out.println("\nIn this menu you can : \n" +
                "1. Go to previous menu\n" +
                "2. View your teams\n" +
                "3. View your team's scoreboards\n" +
                "4. View your team's roadmaps\n" +
                "5. View your team's chatroom\n" +
                "6. View your task's options\n" +
                "7. Go to Board Menu\n" +
                "You can see all commands to perform the next action by writing :\n"+
                " show all commands\n" +
                "You can see a specified command format by entering :\n" +
                "Command --show <command number>\n");
        //TODO case insensitive // a method for all
        // TODO print teams
    }

    @Override
    public void execute() {
        Menu nextMenu = this;
        Matcher matcher;

        while (true) {
            String input = getInputFromUser("Please Enter your command");

            if ((matcher = getCommandMatcher(input, "show all commands")).find()) {
                showAllCommands(matcher);
            }else if((matcher=getCommandMatcher(input,"Command --show <(\\d+)>$")).find()) {
                showCommand(matcher);

            } else if ((matcher = getCommandMatcher(input, "^show team-- ([a-zA-Z]+[a-zA-Z ]*)$")).find()) {
                showTeam(matcher);

            } else  if ((matcher = getCommandMatcher(input, "^Enter team <([a-zA-Z]+[a-zA-Z ]*)>$")).find()) {
                showTeam(matcher);

            } else if ((matcher = getCommandMatcher(input, "^Scoreboard --show$")).find()) {
                showScoreBoard(matcher);

            } else if ((matcher = getCommandMatcher(input, "^Roadmap --show$")).find()) {
                showRoadMap(matcher);

            } else if ((matcher = getCommandMatcher(input, "^chatroom --show$")).find()) {
                showChatRoom(matcher);

            } else if ((matcher = getCommandMatcher(input, "^send --massage <(.+)>$")).find()) {
                SendMassage(matcher);
            } else if ((matcher = getCommandMatcher(input, "^Show tasks$")).find()) {
                showTasks(matcher);
            } else if ((matcher = getCommandMatcher(input, "^show task --id \\[(\\d+)\\]$")).find()) {
                showGivenTask(matcher);//

            } else if ((matcher = getCommandMatcher(input, "^end$")).find()) {
                break;

            } else {
                System.out.println("invalid command");
            }

        }
    }

    public String showAllCommands(Matcher matcher) {
        return "Enter your commands in the specified format\n " +
                "1* to see your teams information  enter yor team's name:\n" +
                "Enter team <teamName>\n" +
                "2* you can also enter the number of the team :\n" +
                "team's number " +
                "3* to see your selected team's scoreboard enter :\n" +
                "show Scoreboard \n" +
                "4* to see your selected team's Scoreboard enter :\n" +
                "Scoreboard --show \n" +
                "5* to see your selected team's Roadmap enter :\n" +
                "Roadmap --show \n" +
                "6* to see your selected team's Chatroom enter :\n" +
                "Chatroom --show  \n" +
                "7* once entered the chatroom, to send massage, enter : \n" +
                "send --massage <massage>\n" +
                "8* to access a task by it's id (each task has it's own unique id), enter :\n" +
                "show task --id [task id]\n" +
                "9* you can see a specified command format by entering :\n" +
                "Command --show <command number>\n" +
                "** if you don't enter the command your command in the specified format you will see this output :\n" + "" +
                "invalid command \n";
    }
    private void showCommand(Matcher matcher) {
        System.out.println("this is show command");
        int commandNumber= Integer.parseInt(matcher.group(1));
        System.out.println("your command number : "+ commandNumber);
    }

    private void showGivenTask(Matcher matcher) {
        System.out.println("this is show given task");
        int taskID = Integer.parseInt(matcher.group(1));
        System.out.println(taskID);
        if (taskID != 22) System.out.println("invalid id");

    }

    private void showTasks(Matcher matcher) {
        System.out.println("this is show tasks");

    }

    private void SendMassage(Matcher matcher) {
        System.out.println("this is send massage");
        String massageText = matcher.group(1);
        System.out.println("<senderName> : " + "<" + massageText + ">");


    }


    private void showRoadMap(Matcher matcher) {
        System.out.println("this is show roadmap");


    }

    private void showChatRoom(Matcher matcher) {
        System.out.println("this is show chatroom");
    }

    private void showScoreBoard(Matcher matcher) {
        System.out.println("this is show scoreboard");
    }

    public void showTeam(Matcher matcher) {
        System.out.println("this is your team name : ");
        String teamName = matcher.group(1);
        System.out.println(teamName);
    }

    public Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input.trim());
    }
}

