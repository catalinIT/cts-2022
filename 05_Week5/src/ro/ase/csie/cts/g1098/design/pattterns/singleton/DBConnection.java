package ro.ase.csie.cts.g1098.design.pattterns.singleton;

public class DBConnection {

    private static DBConnection connection;

    String IPAddress;
    String username;
    String userPass;

    private DBConnection(String IPAddress, String username, String userPass) {
        this.IPAddress = IPAddress;
        this.username = username;
        this.userPass = userPass;
    }

    private DBConnection(){

    }

    //method marked as synchronized as it is possible that the instance is required on 2 different threads in the same time
    public static synchronized DBConnection getInstance() {
        if(connection == null) {
            connection = new DBConnection();
        }
        return connection;
    }
}
