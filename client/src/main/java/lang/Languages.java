package lang;

public enum Languages {
    POLISH("Language_pl"),ENGLISH("Language_en");

    private String value;

    Languages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
