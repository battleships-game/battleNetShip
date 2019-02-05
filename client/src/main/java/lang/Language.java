package lang;

public class Language {
    private static Language ourInstance = new Language();

    public static Language getInstance() {
        return ourInstance;
    }

    private Languages language;

    private Language() {
    }

    public static Language getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Language ourInstance) {
        Language.ourInstance = ourInstance;
    }

    public String getLanguage() {
        return language.toString();
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }
}
