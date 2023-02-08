package Misc;

import Commands.Command;
import Factory.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private String commandsFile;


    public static Parser instance = null;


    private Parser(String fileName) {
        this.commandsFile = fileName;
    }

    public static Parser getInstance(String fileName) {
        if (instance == null) {
            instance = new Parser(fileName);
        }
        return instance;
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
                CreateAddCommand createAddCommand = new CreateAddCommand();
                command = createAddCommand.createCommand(args);
                break;
            case "LIST":
                CreateListCommand createListCommand = new CreateListCommand();
                command = createListCommand.createCommand(args);
                break;
            case "DELETE":

                CreateDeleteCommand createDeleteCommand = new CreateDeleteCommand();
                command = createDeleteCommand.createCommand(args);

                break;
            case "LISTEN":

                CreateListenCommand createListenCommand = new CreateListenCommand();
                command = createListenCommand.createCommand(args);

                break;
            case "RECOMMEND": {

                CreateRecommendCommand createRecommendCommand = new CreateRecommendCommand();
                command = createRecommendCommand.createCommand(args);

                break;
            }
            case "SURPRISE": {

                CreateSurpriseCommand createSurpriseCommand = new CreateSurpriseCommand();
                command = createSurpriseCommand.createCommand(args);

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

    public void resetInstance() {
        instance = null;
    }


}
