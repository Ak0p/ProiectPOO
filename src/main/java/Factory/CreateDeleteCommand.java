package Factory;

import Commands.Command;
import Commands.DeleteCommand;

public class CreateDeleteCommand extends CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new DeleteCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
    }
}
