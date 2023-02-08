package Commands;


public class DeleteCommand implements Command {

    private Integer streamerId;
    private Integer streamId;

    public DeleteCommand(Integer streamerId, Integer streamId) {
        this.streamerId = streamerId;
        this.streamId = streamId;
    }

    public void execute() {
        dbHandler.delete(streamId);
    }
}