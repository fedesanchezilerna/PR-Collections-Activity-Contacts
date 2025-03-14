package contacts;

public enum TypePhone {
    H("Home"),
    M("Mobile"),
    O("Office"),
    F("Fax Office");

    private final String text;

    TypePhone(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
