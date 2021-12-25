package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.TeamMenuController;

public class TeamMenu extends Menu {
    public TeamMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {

//        subMenus.put(2, new BoardMenu("BoardMenu", this));
//        super.show();
        System.out.println("In this menu you can : \n" +
                "1. Go to previous menu\n"+
                "2. See your teams information by team name or team number\n" +
                "3. See your selected team's scoreboard \n" +
                "4. See your selected team's Roadmap\n" +
                "5. See your selected team's Chatroom \n" +
                "6. Once entered the chatroom,you can send massages, \n" +
                "7. See all tasks of the selected team\n"+
                "8. Access a task by it's id\n" +
                "9. Go to Board Menu and see your team's boards(first you need to enter your team's name)\n"+
                "10. You can see all commands to performe the next action by entering :\n"+
                "show all commands\n"+
                "11. You can also see a specified command format by entering :\n" +
                "command --show <command number>\n" +
                "choose the command number from the list above \n");

        // TODO print teams
        //TeamMenuController.getTeamMenuController().showAllLoggedInUserTeams();
    }

    @Override
    public void execute() {
        Menu nextMenu = this;
        Matcher matcher;

        while (true) {
            String input = getInputFromUser("Please Enter your command");
            if((matcher =getCommandMatcher(input,"back")).find()) {
                nextMenu=this.parent;
                break;

            } else if ((matcher = getCommandMatcher(input, "show all commands")).find()) {
                showAllCommands(matcher);
            }else if((matcher=getCommandMatcher(input,"command --show <(\\d+)>$")).find()) {
                showCommand(matcher);

            } else  if ((matcher = getCommandMatcher(input, "^Enter team <([a-zA-Z]+[a-zA-Z ]*)>$")).find()) {
                showTeam(matcher);

            } else  if ((matcher = getCommandMatcher(input, "^deselect team <([a-zA-Z]+[a-zA-Z ]*)>$")).find()) {
                deselectTeam(matcher);

            } else if ((matcher = getCommandMatcher(input, "^scoreboard --show$")).find()) {
                showScoreBoard(matcher);

            } else if ((matcher = getCommandMatcher(input, "^roadmap --show$")).find()) {
                showRoadMap(matcher);

            } else if ((matcher = getCommandMatcher(input, "^chatroom --show$")).find()) {
                showChatRoom(matcher);

            } else if ((matcher = getCommandMatcher(input, "^send --massage <(.+)>$")).find()) {
                SendMassage(matcher);
            } else if ((matcher = getCommandMatcher(input, "^show tasks$")).find()) {
                showTasks(matcher);
            } else if ((matcher = getCommandMatcher(input, "^show task --id \\[(\\d+)\\]$")).find()) {
                showGivenTask(matcher);//


            } else {
                System.out.println("Invalid command");
            }

        }
        nextMenu.show();
        nextMenu.execute();
    }


    public void showAllCommands(Matcher matcher) {
        System.out.println( "Enter your commands in the specified format\n " +
                "1* to go to previous menu, enter : \n"+
                "back\n"+
                "2* To see your teams information, enter yor team's name:\n" +
                "Enter team <teamName>\n" +
                "** you can also enter the number of the team :\n" +
                "<team's number> " +
                "*** once selected a team if you want to select another team first" +
                "deselect your current team by entering :\n"+
                "deselect team <teamName>\n"+
                "then enter your next team's name\n"+
                "3* To see your selected team's scoreboard enter :\n" +
                "scoreboard --show \n" +
                "4* To see your selected team's Roadmap enter :\n" +
                "roadmap --show \n" +
                "5* To see your selected team's Chatroom enter :\n" +
                "chatroom --show  \n" +
                "6* Once entered the chatroom, to send massage, enter : \n" +
                "send --massage <massage>\n" +
                "7* To see all tasks of the selected team, enter :\n"+
                "show tasks\n"+
                "8* To access a task by it's id (each task has it's own unique id), enter :\n" +
                "show task --id [task id]\n" +
                "9* To go to Board Menu and see your team's boards(first you need to enter your team's name)\n"+
                "\n"+//TODO finish this command
                "10* You can see all commands by entering :\n"+
                "show all commands\n"+
                "11* You can see a specified command format by entering :\n" +
                "command --show <command number>\n" +
                "** if you don't enter the command your command in the specified format you will see this output :\n" + "" +
                "invalid command \n");
    }
    private void showCommand(Matcher matcher) {
        System.out.println("this is show command");
        int commandNumber = Integer.parseInt(matcher.group(1));
        System.out.println("your command number : " + commandNumber);

        if (commandNumber == 1) {
            System.out.println("1* to go to previous menu, enter : \n" +
                    "back\n");
        } else if (commandNumber == 2) {
            System.out.println("2* to see your teams information, enter yor team's name:\n" +
                    "Enter team <teamName>\n" +
                    "* you can also enter the number of the team :\n" +
                    "<team's number> "+
                    "** once selected a team if you want to select another team first" +
                    "deselect your current team by entering :\n"+
                    "deselect team <teamName>\n"+
                    "then enter your next team's name\n");
        } else if (commandNumber == 3) {
            System.out.println("3* To see your selected team's scoreboard enter :\n" +
                    "scoreboard --show \n");
        } else if (commandNumber == 4) {
            System.out.println("4* To see your selected team's Roadmap enter :\n" +
                    "roadmap --show \n");
        } else if (commandNumber == 5) {
            System.out.println("5* To see your selected team's Chatroom enter :\n" +
                    "chatroom --show  \n");
        } else if (commandNumber == 6) {
            System.out.println("6* Once entered the chatroom, to send massage, enter : \n" +
                    "send --massage <massage>\n");
        } else if (commandNumber == 7) {
            System.out.println("7* To see all tasks of the selected team, enter :\n" +
                    "show tasks\n");
        } else if (commandNumber == 8) {
            System.out.println("8* To access a task by it's id (each task has it's own unique id), enter :\n" +
                    "show task --id [task id]\n");
        } else if (commandNumber == 9) {
            System.out.println("9* To go to Board Menu and see your team's boards(first you need to enter your team's name)\n" +
                    "\n");
        } else if (commandNumber == 10) {
            System.out.println("10* You can see all commands by entering :\n" +
                    "show all commands\n");
        } else if (commandNumber == 11) {
            System.out.println("11* You can see a specified command format by entering :\n" +
                    "command --show <command number>\n");
        }else  System.out.println("your command number is out of range !\n" +
                "please enter a number ,starting from 1 , till 11 !\n ");
    }



    private void deselectTeam(Matcher matcher) {
        String teamName = matcher.group(1);
        TeamMenuController.deselectTeam(teamName);

    }
    private void showGivenTask(Matcher matcher) {
        int taskID = Integer.parseInt(matcher.group(1));
        TeamMenuController.showTaskInfoByID(taskID);

    }

    private void showTasks(Matcher matcher) {
        TeamMenuController.showAllTasks();

    }

    private void SendMassage(Matcher matcher) {
        String massageText = matcher.group(1);
        System.out.println("<senderName> : " + "<" + massageText + ">");
        TeamMenuController.sendMassage(massageText);


    }


    private void showRoadMap(Matcher matcher) {
        TeamMenuController.getTeamMenuController().showRoadMap();


    }

    private void showChatRoom(Matcher matcher) {
        TeamMenuController.getTeamMenuController().showChatRoom();
    }

    private void showScoreBoard(Matcher matcher) {
        TeamMenuController.getTeamMenuController().showScoreBoard();
    }

    public void showTeam(Matcher matcher) {
        System.out.println("this is your team name : ");
        String teamName = matcher.group(1);
        System.out.println(teamName);

        TeamMenuController.selectTeam(teamName);
        //TeamMenuController.showSelectedTeam(teamName);


    }

    public Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input.trim());
    }
}



