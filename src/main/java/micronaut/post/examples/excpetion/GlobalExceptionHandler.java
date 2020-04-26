package micronaut.post.examples.excpetion;

import io.micronaut.context.annotation.Context;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Error;
import micronaut.post.examples.domain.ApiError;

@Context
public class GlobalExceptionHandler {

    @Error(exception = PostException.class, global = true)
    public ApiError onPostException(HttpRequest request, PostException ex) {
        ApiError apiResponse = new ApiError();
        apiResponse.setCode(800);
        apiResponse.setMessage(ex.getMessage());
        return apiResponse;
    }

}
