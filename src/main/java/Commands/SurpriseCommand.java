package Commands;

import Commands.Command;

public class SurpriseCommand implements Command {
    private Integer userId;

    private Integer streamType;

    public SurpriseCommand(Integer userId, Integer streamType) {
        this.userId = userId;
        this.streamType = streamType;
    }

    public void execute() {
        dbHandler.surprise(userId, streamType);
    }
}
