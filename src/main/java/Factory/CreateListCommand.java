package Factory;

import Commands.Command;
import Commands.ListCommand;

public class CreateListCommand extends CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        return new ListCommand(Integer.parseInt(args[0]));
    }
}
