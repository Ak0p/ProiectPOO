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

    public static class DeleteCommand implements Command {

        private Integer streamerId;
        private Integer id;

        public DeleteCommand(Integer streamerId, Integer id) {
            this.streamerId = streamerId;
            this.id = id;
        }

        public void execute() {
            //TODO: Call dbhandler to delete stream
        }
    }
}
