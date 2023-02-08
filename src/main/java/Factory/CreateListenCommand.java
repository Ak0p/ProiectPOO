package Factory;

import Commands.Command;
import Commands.ListenCommand;

public class CreateListenCommand extends CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new ListenCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
    }
}

