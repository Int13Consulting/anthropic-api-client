/*
Copyright (c) 2024 Int13 Consulting Inc.

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package ca.int13.anthropic.api.client;

import ca.int13.anthropic.api.client.classes.AnthropicResponse;
import ca.int13.anthropic.api.client.classes.AnthropicRequest;

import com.google.gson.Gson;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Future;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;

/**
 *
 * @author mgamble
 */
public class AnthropicAIClient implements Closeable {

    private static final String JSON = "application/json; charset=UTF-8";
    private final boolean closeClient;
    private final AsyncHttpClient client;
    private static final Version version = new Version();
    private String apiKey;
    private String apiVersion;
    private final String url;
    private boolean closed = false;
    Gson gson = new Gson();

    public AnthropicAIClient(String authToken, String apiEndpoint, String apiVersion) throws Exception {
        this.client = new DefaultAsyncHttpClient();

        this.url = apiEndpoint;
        this.apiKey = authToken;
        this.apiVersion = apiVersion;
        closeClient = true;
    }

 
    //////////////////////////////////////////////////////////////////////
    // Closeable interface methods
    //////////////////////////////////////////////////////////////////////
    public boolean isClosed() {
        return closed || client.isClosed();
    }

    public void close() {
        if (closeClient && !client.isClosed()) {
            try {
                client.close();
            } catch (IOException ex) {

            }
        }
        closed = true;
    }

    public String getVersion() {
        return version.getBuildNumber();
    }

    public String getBuildName() {
        return version.getBuildName();
    }

    public AnthropicResponse submitRequest(AnthropicRequest predictRequest) throws Exception {
        //chat/completions
        Future<Response> f = client.executeRequest(buildRequest("POST", "/v1/messages", gson.toJson(predictRequest)));
        Response r = f.get();
        if (r.getStatusCode() != 200) {
            System.out.println(gson.toJson(predictRequest));
            throw new Exception("Could not get prediction result - HTTP Status was: " + r.getStatusCode());
        } else {
            //    System.out.println(gson.toJson(r.getResponseBody()));
            // Clean up any whitespace from the reponse to make things cleaner for clients
            //System.out.println(r.getResponseBody());
            AnthropicResponse response = gson.fromJson(r.getResponseBody(), AnthropicResponse.class);
            
            return response;
        }

    }

    private Request buildRequest(String type, String subUrl) {
        RequestBuilder builder = new RequestBuilder(type);
        Request request = builder.setUrl(this.url + subUrl)
                .addHeader("Accept", JSON)
                .addHeader("Content-Type", JSON)
                .addHeader("anthropic-version", apiVersion)
                .addHeader("x-api-key", this.apiKey)
                .build();
        return request;
    }

    private Request buildRequest(String type, String subUrl, String requestBody) {
        RequestBuilder builder = new RequestBuilder(type);
        Request request = builder.setUrl(this.url + subUrl)
                .addHeader("Accept", JSON)
                .addHeader("Content-Type", JSON)
                .addHeader("anthropic-version", apiVersion)
                .addHeader("x-api-key", this.apiKey)
                .setBody(requestBody)
                .build();
        return request;
    }

}
