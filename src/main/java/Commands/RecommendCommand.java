package Commands;

import Commands.Command;

public class RecommendCommand implements Command {

    private Integer userId;
    private Integer streamType;

    public RecommendCommand(Integer userId, Integer streamType) {
        this.userId = userId;
        this.streamType = streamType;
    }

    public void execute() {
        dbHandler.recommend(userId, streamType);
    }
}
