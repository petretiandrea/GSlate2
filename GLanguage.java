package it.petretiandrea.gslate;


/**
 * Created by Petreti Andrea on 03/12/17.
 */
public class GLanguage {

    /**
     * This enum contains all LanguageCode supported by Google Translate.
     * @author Petreti Andrea
     */
    public enum Code {
        AF,
        SQ,
        AR,
        AZ,
        EU,
        BN,
        BE,
        BG,
        CA,
        ZH_CN,
        ZH_TW,
        HR,
        CS,
        DA,
        NL,
        EN,
        EO,
        ET,
        TL,
        FI,
        FR,
        GL,
        KA,
        DE,
        EL,
        GU,
        HT,
        IW,
        HI,
        HU,
        IS,
        ID,
        GA,
        IT,
        JA,
        KN,
        KO,
        LA,
        LV,
        LT,
        MK,
        MS,
        MT,
        NO,
        FA,
        PL,
        PT,
        RO,
        RU,
        SR,
        SK,
        SL,
        ES,
        SW,
        SV,
        TA,
        TE,
        TH,
        TR,
        UK,
        UR,
        VI,
        CY,
        YI,
        YO,
        ZU,
        AUTO
    }

    /**
     * This enum contains all LanguageName supported by Google Translate.
     * @author Petreti Andrea
     */
    public enum Name {
        AFRIKAANS,
        ALBANIAN,
        ARABIC,
        AZERBAIJANI,
        BASQUE,
        BENGALI,
        BELARUSIAN,
        BULGARIAN,
        CATALAN,
        CHINESE_SIMPLIFIED,
        CHINESE_TRADITIONAL,
        CROATIAN,
        CZECH,
        DANISH,
        DUTCH,
        ENGLISH,
        ESPERANTO,
        ESTONIAN,
        FILIPINO,
        FINNISH,
        FRENCH,
        GALICIAN,
        GEORGIAN,
        GERMAN,
        GREEK,
        GUJARATI,
        HAITIAN_CREOLE,
        HEBREW,
        HINDI,
        HUNGARIAN,
        ICELANDIC,
        INDONESIAN,
        IRISH,
        ITALIAN,
        JAPANESE,
        KANNADA,
        KOREAN,
        LATIN,
        LATVIAN,
        LITHUANIAN,
        MACEDONIAN,
        MALAY,
        MALTESE,
        NORWEGIAN,
        PERSIAN,
        POLISH,
        PORTUGUESE,
        ROMANIAN,
        RUSSIAN,
        SERBIAN,
        SLOVAK,
        SLOVENIAN,
        SPANISH,
        SWAHILI,
        SWEDISH,
        TAMIL,
        TELUGU,
        THAI,
        TURKISH,
        UKRAINIAN,
        URDU,
        VIETNAMESE,
        WELSH,
        YIDDISH,
        YORUBA,
        ZULU,
        AUTO
    }

    private GLanguage(){}

    static String getGoogleLang(Code code)
    {
        if(code.toString().equals("ZH_CN") || code.toString().equals("ZH_TW"))
        {
            String p[] = code.toString().split("_");
            return p[0].toLowerCase() + "-" + p[1].toUpperCase();
        }
        return code.toString().toLowerCase();
    }

    public static Code getCodeFromLanguageName(Name name) throws GLanguageInvalidException {
        if(name != null && name.ordinal() <= Code.values().length)
            return Code.values()[name.ordinal()];
        else
            throw new GLanguageInvalidException("Invalid language - " + (name != null ? name.toString() : null));
    }

    public static Name getNameFromLanguageCode(Code code) throws GLanguageInvalidException {
        if(code != null && code.ordinal() <= Name.values().length)
            return Name.values()[code.ordinal()];
        else
            throw new GLanguageInvalidException("Invalid language code - " + (code != null ? code.toString() : null));
    }

    private static class GLanguageInvalidException extends Exception {
        GLanguageInvalidException(String s) {
            super(s);
        }
    }
}
