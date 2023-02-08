package Commands;

import Misc.RequestHandler;

public interface Command {
    RequestHandler dbHandler = RequestHandler.getInstance();

    void execute();
}
