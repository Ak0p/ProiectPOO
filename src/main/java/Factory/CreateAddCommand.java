package Factory;

import Commands.AddCommand;
import Commands.Command;

public class CreateAddCommand extends CommandFactory {
    @Override
    public Command createCommand(String[] args) {
        for (int i = 7; i < args.length; i++) {
            args[6] += " " + args[i];
        }
        return new AddCommand(Integer.parseInt(args[0]), Integer.parseInt(args[2]),
                Integer.parseInt(args[3]), Integer.parseInt(args[4]), Long.parseLong(args[5]), args[6]);
    }
}
