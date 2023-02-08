package Commands;

public class AddCommand implements Command {

    private Integer streamerId;
    private Integer streamType;
    private Integer id;
    private Integer streamGenre;
    private Long length;
    private String name;

    public AddCommand(Integer streamerId, Integer streamType, Integer id,
                      Integer streamGenre, Long length, String name) {
        this.streamerId = streamerId;
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.length = length;
        this.name = name;
    }

    public void execute() {
//        Misc.RequestHandler.write("id = " + id);
        Command.dbHandler.add(streamerId, streamType, id, streamGenre, length, name);
    }
}
