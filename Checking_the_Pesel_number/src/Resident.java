class Resident {
    private String city;
    private String name;
    private String surname;
    private String pesel;

    public Resident(String city, String name, String surname, String pesel) {
        this.city = city;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String toWriteableLine() {
        return this.getCity() + " " + this.getName() + " " + this.getSurname() + " " + this.getPesel() + "\n";
    }
}