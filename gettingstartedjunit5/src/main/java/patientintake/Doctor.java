package patientintake;

public enum Doctor {
    avery("Ralph Avery"),
    johnson("Beth Johnson"),
    muphy("Pat Muphy");

    private String name;
    Doctor(String name) {this.name = name;}
    public String getName() {return name;}

}
