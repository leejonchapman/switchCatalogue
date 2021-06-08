import java.util.ArrayList;

public class Site {
    ArrayList<Switch> computerNetwork = new ArrayList<>();
    String location;

    public Site(String location) {
        ArrayList<Switch> computerNetwork = new ArrayList<>();
        this.location = location;
    }

    public String queryContact(Switch queriedSwitch) {
        if (findSwitch(queriedSwitch) >= 0) {
            return queriedSwitch.getSerial() + "\t" + queriedSwitch.getLocation();
        }
        return null;
    }

    private int findSwitch(Switch switchToFind) {
        return this.computerNetwork.indexOf(switchToFind);
    }

    public int findSwitch(int serial) {
        int newSwitch = serial;
        int oldSwitch;
        for (int i = 0; i < this.computerNetwork.size(); i++) {
            oldSwitch = this.computerNetwork.get(i).getSerial();
            if (oldSwitch == newSwitch) {
                return i;
            }
        }
        return -1;
    }

    public boolean createSwitch(Switch newSwitch) {
        if (findSwitch(newSwitch) < 0) {
            System.out.println("Adding switch to database \t\t - " + newSwitch.getSerial() + "\n");
            this.computerNetwork.add(newSwitch);
            return true;
        }
        System.out.println("Cannot add switch\t\t\t\t - " + newSwitch.getSerial());
        return false;
    }

    public boolean removeSwitch(Switch removedSwitch) {
        int foundPosition = findSwitch(removedSwitch);
        if (foundPosition >= 0) {
            this.computerNetwork.remove(foundPosition);
            System.out.println("Switch deleted");
            return true;
        }
        return false;
    }

    public boolean updateSwitch(Switch newSwitch, Switch oldSwitch) {
        int tempIndex = findSwitch(oldSwitch);
        if (tempIndex < 0) {
            System.out.println("Switch not found - creating a switch in database");
            createSwitch(newSwitch);
        } else {
            this.computerNetwork.set(tempIndex, newSwitch);
            System.out.println("Updated switch");
        }

        return false;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
