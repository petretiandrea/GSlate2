package it.petretiandrea.gslate;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import it.petretiandrea.gslate.utils.Constants;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.function.Supplier;

/**
 * Created by Petreti Andrea on 03/12/17.
 */

/**
 * Definisce il comportamento del thread di traduzione.
 */
public class Translator implements Supplier<TranslatedText> {

    private TranslateRequest _request;

    public Translator(TranslateRequest request)
    {
        _request = request;
    }

    @Override
    public TranslatedText get() {

        TranslatedText translatedText = null;

        try
        {
            URL url = new URL(Constants.MAIN_API_URL_GOOGLE_TRANSLATE +
                    "&" + Constants.PARAM_SOURCE_LANG + "=" + GLanguage.getGoogleLang(_request.getCodeLangSource()) +
                    "&" + Constants.PARAM_TARGET_LANG + "=" + GLanguage.getGoogleLang(_request.getCodeLangTarget()) +
                    "&dt=t" +
                    "&" + Constants.PARAM_TEXT + "=" + URLEncoder.encode(_request.getTextSource(), "UTF-8"));

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            SSLContext sc;
            sc = SSLContext.getInstance("TLS");
            sc.init(null, null, new SecureRandom());

            urlConnection.setSSLSocketFactory(sc.getSocketFactory());
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            if (urlConnection.getResponseCode() == 200) {
                String line = null;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null)
                    builder.append(line).append("\n");
                reader.close();

                JsonArray jsonArray = (JsonArray) new JsonParser().parse(builder.toString());

                /*if(_request.getSourceLanguage() == GLanguage.Code.AUTO)
                    _request.setSourceLanguage(GLanguage.getCodeLanguageFromStringName(jsonArray.get(2).getAsString()));*/

                translatedText = new TranslatedText(_request, jsonArray.get(0).getAsJsonArray().get(0).getAsJsonArray().get(0).getAsString());
            }
        }
        catch (IOException | NoSuchAlgorithmException | KeyManagementException e)
        {
            e.printStackTrace();
        }
        return translatedText;
    }
}
