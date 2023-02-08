package Misc;

import Commands.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private final String commandsFile;


    public Parser(String fileName) {
        this.commandsFile = fileName;
    }


    public List<Command> getCommands() {
        List<Command> commands = new LinkedList<>();
        try {
            BufferedReader commandReader = readFile(commandsFile);
            assert commandReader != null;
            String line;
            while ((line = commandReader.readLine()) != null) {
                String[] info = line.split(" ");
                commands.add(commandParsing(info));
            }
        } catch (IOException e) {
            System.out.println("Error while reading commands file");
            return Collections.emptyList();
        }
        return commands;
    }

    private Command commandParsing(String[] args) {

        Command command = null;

        switch (args[1]) {
            case "ADD":
                for (int i = 7; i < args.length; i++) {
                    args[6] += " " + args[i];
                }
                command = new AddCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]), Integer.parseInt(args[4]), Long.parseLong(args[5]), args[6]);

                break;
            case "LIST":
                command = new ListCommand(Integer.parseInt(args[0]));
                break;
            case "DELETE":
                command = new ListenCommand.DeleteCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]));

                break;
            case "LISTEN":
               command = new ListenCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
                break;
            case "RECOMMEND": {
                int streamType = -1;
                if (args[2].equals("SONG"))
                    streamType = 1;
                else if (args[2].equals("PODCAST"))
                    streamType = 2;
                else if (args[2].equals("AUDIOBOOK"))
                    streamType = 3;
                else {
                    assert false;
                    System.out.println("Invalid stream type");
                }
                command = new RecommendCommand(Integer.parseInt(args[0]), streamType);
                break;
            }
            case "SURPRISE": {
                int streamType = -1;
                if (args[2].equals("SONG"))
                    streamType = 1;
                else if (args[2].equals("PODCAST"))
                    streamType = 2;
                else if (args[2].equals("AUDIOBOOK"))
                    streamType = 3;
                else {
                    assert false;
                    System.out.println("Invalid stream type");
                }
                command = new SurpriseCommand(Integer.parseInt(args[0]), streamType);
                break;
            }
            default:
                System.out.println("Invalid command");
        }
        return command;
    }

    public static BufferedReader readFile(String path) {
        try {
            return new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }


}
