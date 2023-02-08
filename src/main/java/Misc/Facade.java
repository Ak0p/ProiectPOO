package Misc;

import Commands.Command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Facade {
    private static Facade instance = null;

    private String COMMANDS_FILE;
    private String USERS_FILE;
    private String STREAMERS_FILE;
    private String STREAMS_FILE;
    private Parser parser;
    private Database db;
    private List<Command> commands;

    private String output;

    private Facade() {
        db = Database.getInstance();
    }

    public static Facade getInstance() {
        if (Facade.instance == null) {
            Facade.instance = new Facade();
        }
        return Facade.instance;
    }
    public void setFiles(String commandsFile, String usersFile, String streamersFile, String streamsFile) {
        this.COMMANDS_FILE = commandsFile;
        this.USERS_FILE = usersFile;
        this.STREAMERS_FILE = streamersFile;
        this.STREAMS_FILE = streamsFile;
    }

    public void loadDatabase() {

        db.loadDatabase(STREAMERS_FILE, STREAMS_FILE, USERS_FILE);
    }

    public void startParsing() {
        this.parser = new Parser(COMMANDS_FILE);
        commands = parser.getCommands();
        assert commands != null;
    }

    public void runCommands() {
        int i = 0;
        for (Command command : commands) {
            command.execute();
//            Misc.RequestHandler.write("command" + i);
            i++;
        }
        RequestHandler.getInstance().showOutput();
    }

    public void clean() {
        db.cleanDatabase();
        this.commands = new LinkedList<>();
    }

}
