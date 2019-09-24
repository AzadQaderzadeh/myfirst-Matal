package co.brooskasoft.matalikurdi.model;

public class Matal {
    private String Matal;
    private String Wallam;

    public Matal(String matal, String wallam) {
        Matal = matal;
        Wallam = wallam;
    }

    //Getter
    public String getMatal() {
        return Matal;
    }

    public String getWallam() {
        return Wallam;
    }

    // Setter

    public void setMatal(String matal) {
        Matal = matal;
    }

    public void setWallam(String wallam) {
        Wallam = wallam;
    }
}

