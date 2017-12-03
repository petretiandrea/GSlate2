package it.petretiandrea.gslate;

/**
 * Created by Petreti Andrea on 03/12/17.
 */
public class TranslatedText {

    private TranslateRequest _request;
    private String _textTarget;

    TranslatedText(TranslateRequest request, String textTarget) {
        this._request = request;
        this._textTarget = textTarget;
    }

    public TranslateRequest getRequest() {
        return _request;
    }

    public String getTranslatedText() {
        return _textTarget;
    }
}
