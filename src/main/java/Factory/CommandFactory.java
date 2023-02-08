package Factory;

import Commands.Command;

public abstract class CommandFactory {

    public abstract Command createCommand(String[] args);

}
