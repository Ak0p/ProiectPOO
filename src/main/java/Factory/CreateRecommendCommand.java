package Factory;

import Commands.Command;
import Commands.RecommendCommand;

public class CreateRecommendCommand extends CommandFactory {
    @Override
    public Command createCommand(String[] args) {
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
        return new RecommendCommand(Integer.parseInt(args[0]), streamType);
    }
}
