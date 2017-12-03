package it.petretiandrea.gslate;

/**
 * Created by Petreti Andrea on 03/12/17.
 */
public class TranslateRequest {

    private GLanguage.Code _codeSource;
    private GLanguage.Code _codeTarget;
    private String _stringSource;

    public TranslateRequest(GLanguage.Code languageSource, GLanguage.Code languageTarget, String textSource)
    {
        _codeSource = languageSource;
        _codeTarget = languageTarget;
        _stringSource = textSource;
    }

    public GLanguage.Code getCodeLangSource() {
        return _codeSource;
    }

    public GLanguage.Code getCodeLangTarget() {
        return _codeTarget;
    }

    public String getTextSource() {
        return _stringSource;
    }
}
