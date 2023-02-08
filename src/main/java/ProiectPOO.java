import Misc.Facade;
import Misc.RequestHandler;

public class ProiectPOO {

    private static String USERS_FILE;
    private static String STREAMERS_FILE;
    private static String STREAMS_FILE;
    private static String COMMANDS_FILE;



    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
            return;
        }
        getFilenames(args);
        RequestHandler.flush();
        Facade facade = Facade.getInstance();
        facade.setFiles(COMMANDS_FILE, USERS_FILE, STREAMERS_FILE, STREAMS_FILE);
        facade.loadDatabase();
        facade.startParsing();
        facade.runCommands();
        facade.clean();
        RequestHandler.getInstance().reset();

    }

    public static void getFilenames(String[] args) {
        String folder = "src/main/resources/";
        STREAMERS_FILE = folder + args[0];
        STREAMS_FILE = folder + args[1];
        USERS_FILE = folder + args[2];
        COMMANDS_FILE = folder + args[3];
    }









}