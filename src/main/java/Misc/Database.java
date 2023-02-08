package Misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Database {
    private static Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private TreeMap<Integer, Streamer> streamers;
    private TreeMap<Integer, Streams> streams;
    private TreeMap<Integer, User> users;

    private Database() {
        this.streamers = new TreeMap<>();
        this.streams = new TreeMap<>();
        this.users = new TreeMap<>();

    }

    public void loadDatabase(String streamersFile, String streamsFile, String usersFile) {
        loadStreamers(streamersFile);
        loadStreams(streamsFile);
        loadUsers(usersFile);
    }

    private void loadStreamers(String streamersFile) {
        try {
            BufferedReader streamerReader = Parser.readFile(streamersFile);
            if (streamerReader == null)
                return;
            String line;
            if ((line = streamerReader.readLine()) == null)
                return;
            while ((line = streamerReader.readLine()) != null) {
                String[] args = line.split(",");
//                for (int i = 0; i < args.length; i++) {
//                    Misc.RequestHandler.write(args[i]);
//                }
                Streamer streamer = new Streamer(Integer.parseInt(args[0].substring(1, args[0].length()-1)),
                        Integer.parseInt(args[1].substring(1, args[1].length()-1)),
                        args[2].substring(1, args[2].length()-1));
                streamers.put(streamer.getId(), streamer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStreams(String streamsFile) {
        try {
            BufferedReader streamsReader = Parser.readFile(streamsFile);
            if (streamsReader == null)
                return;
            String line;
            if ((line = streamsReader.readLine()) == null)
                return;
            while ((line = streamsReader.readLine()) != null) {
                String[] args = line.split(",");
                for (int i = 8; i < args.length; i++) {
                    args[7] = args[7].concat(",").concat(args[i]);
                }
                Streams streams = new Streams(Integer.parseInt(args[0].substring(1, args[0].length()-1)),
                        Integer.parseInt(args[1].substring(1, args[1].length()-1)),
                        Integer.valueOf(args[2].substring(1, args[2].length()-1)),
                        Long.parseLong(args[3].substring(1, args[3].length()-1)),
                        Integer.parseInt(args[4].substring(1, args[4].length()-1)),
                        Long.parseLong(args[5].substring(1, args[5].length()-1)),
                        Long.parseLong(args[6].substring(1, args[6].length()-1)),
                        args[7].substring(1, args[7].length()-1));
                streams.setStreamerName(streamers.get(streams.getStreamerId()).getName());
                this.streams.put(streams.getId(), streams);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TreeMap<Integer, Streamer> getStreamers() {
        return streamers;
    }

    public void setStreamers(TreeMap<Integer, Streamer> streamers) {
        this.streamers = streamers;
    }

    public TreeMap<Integer, Streams> getStreams() {
        return streams;
    }

    public void setStreams(TreeMap<Integer, Streams> streams) {
        this.streams = streams;
    }

    public TreeMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(TreeMap<Integer, User> users) {
        this.users = users;
    }

    private void loadUsers(String usersFile) {
        try {
            BufferedReader usersReader = Parser.readFile(usersFile);
            if (usersReader == null)
                return;
            String line;
            if ((line = usersReader.readLine()) == null)
                return;
            while ((line = usersReader.readLine()) != null) {
                String[] args = line.split(",");
                List<Integer> streamsList = new LinkedList<>();
                String[] elements = args[2].substring(1, args[2].length()-1).split(" ");
                for(String stream : elements)
                    streamsList.add(Integer.parseInt(stream));
                User user = new User(Integer.parseInt(args[0].substring(1, args[0].length()-1)),
                        args[1].substring(1, args[1].length()-1), streamsList);
                users.put(user.getId(), user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer objectTypeById(Integer id) {
        if (streamers.containsKey(id)) {
            return 1;
        } else if (streams.containsKey(id)) {
            return 2;
        } else if (users.containsKey(id)) {
            return 3;
        }
        return 0;
    }

//    private String getNameById(Integer id) {
//        if (streamers.containsKey(id)) {
//            return streamers.get(id).getName();
//            return null;
//    }

    public void cleanDatabase() {
        streamers.clear();
        streams.clear();
        users.clear();
    }



}
