package service;

import static environment.Constants.ID;
import static environment.Constants.KEY;
import static environment.Constants.TOKEN;

import beans.Board;
import beans.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CommonService {

    protected Method requestedMethod;
    protected Map<String, String> queryParameters;
    protected Map<String, String> pathParameters;

    public CommonService(Method requestedMethod, Map<String, String> queryParameters,
                         Map<String, String> pathParameters) {
        this.requestedMethod = requestedMethod;
        this.queryParameters = queryParameters;
        this.pathParameters = pathParameters;
    }

    public String convertToString() {
        StringBuilder builder = new StringBuilder();
        pathParameters.keySet().forEach(p -> builder.append("{").append(p).append("}").append("/"));
        return builder.toString();
    }

    public Response sendRequest(URI url) {
        return RestAssured
                .given(Specifications.requestSpecification(url)).log().all()
                .pathParams(pathParameters)
                .queryParams(queryParameters)
                .queryParam(KEY, "74ecb1e868a46b2e1513f84af0e8ac6a")
                .queryParam(TOKEN, "92c25dda00b665a0fe64f4fcdd999f86"
                        + "2ac9e6fdbdef1e84f3b4093cc7a93199")
                .request(requestedMethod, convertToString())
                .prettyPeek();
    }

    public static Response sendRequestAndGetResponse(CommonService.CommonApiBuilder api,
                                                     ResponseSpecification responseSpec, URI url) {
        Response response = api
                .buildCommonApiRequest()
                .sendRequest(url);
        response.then()
                .assertThat()
                .spec(responseSpec);
        return response;
    }

    public static Board extractBoardFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {
        }.getType());
    }

    public static List extractListFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List>() {
        }.getType());
    }

    public static class CommonApiBuilder {

        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;

        public CommonService.CommonApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public CommonService.CommonApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public CommonApiBuilder setQueryParameter(String parameter, String value) {
            queryParameters.put(parameter, value);
            return this;
        }

        public CommonService buildCommonApiRequest() {
            return new CommonService(requestedMethod, queryParameters, pathParameters);
        }
    }

    public static CommonService.CommonApiBuilder commonApiBuilder() {
        return new CommonService.CommonApiBuilder();
    }
}
