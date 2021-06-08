public class Switch {
    private String ipAddress;
    private String username;
    private String password;
    private String model;
    private String location;
    private int serial;

    private Switch(String ipAddress, String username, String password, String model, String location, int serial) {
        this.ipAddress = ipAddress;
        this.username = username;
        this.password = password;
        this.model = model;
        this.location = location;
        this.serial = serial;
    }

    public static Switch createSwitch(String ipAddress, String username, String password, String model, String location, int serial) {
        return new Switch(ipAddress, username, password, model, location, serial);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getModel() {
        return model;
    }

    public String getLocation() {
        return location;
    }

    public int getSerial() {
        return serial;
    }

}
