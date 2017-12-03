package it.petretiandrea.gslate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by andrea on 03/12/17.
 */
public class GSlate {

    private static GSlate _instance;

    public static GSlate getInstance()
    {
        if(_instance == null)
            _instance = new GSlate();
        return _instance;
    }

    public TranslatedText performRequest(TranslateRequest request) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(new Translator(request)).get();
    }

    public CompletableFuture<TranslatedText> performAsyncRequest(TranslateRequest request)
    {
        return CompletableFuture.supplyAsync(new Translator(request));
    }

}
