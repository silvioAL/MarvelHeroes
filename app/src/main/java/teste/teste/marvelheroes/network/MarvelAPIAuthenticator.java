package teste.teste.marvelheroes.network;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import teste.teste.marvelheroes.contract.AppContract;
import teste.teste.marvelheroes.utils.StringUtils;

public class MarvelAPIAuthenticator implements Interceptor {

    private static final String QUERY_NAME_TIMESTAMP = "ts";
    private static final String QUERY_NAME_APIKEY = "apikey";
    private static final String QUERY_NAME_HASH = "hash";

    @Override
    public Response intercept(Chain chain) throws IOException {

        String ts = String.valueOf(System.currentTimeMillis());
        StringUtils formatter = new StringUtils();
        AppContract contract = new AppContract();
        String hash = formatter.md5(ts + contract.getPRIV_KEY() + contract.getAPI_KEY());

        Request currentRequest = chain.request();

        HttpUrl url = currentRequest.url().newBuilder()
                .addQueryParameter(QUERY_NAME_TIMESTAMP, ts)
                .addQueryParameter(QUERY_NAME_APIKEY, contract.getAPI_KEY())
                .addQueryParameter(QUERY_NAME_HASH, hash).build();

        Request newRequest = currentRequest.newBuilder().url(url).build();

        return chain.proceed(newRequest);
    }
}