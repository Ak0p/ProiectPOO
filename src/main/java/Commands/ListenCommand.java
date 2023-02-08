package Commands;

public class ListenCommand implements Command {
    private Integer userId;
    private Integer streamId;

    public ListenCommand(Integer userId, Integer streamId) {
        this.userId = userId;
        this.streamId = streamId;
    }

    public void execute() {
        dbHandler.listen(userId, streamId);
    }


}
