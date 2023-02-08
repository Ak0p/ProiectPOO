package Commands;

public class ListCommand implements Command {

    private Integer id;

    public ListCommand(Integer id) {
        this.id = id;
    }

    public void execute() {
        dbHandler.list(id);
    }

}
