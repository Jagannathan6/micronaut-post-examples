package micronaut.post.examples.excpetion;

import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import micronaut.post.examples.domain.ApiError;

import javax.inject.Singleton;

@Produces
@Singleton
@Primary
public class PostExceptionHandler
        implements ExceptionHandler<PostException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, PostException exception) {

        ApiError apiError = new ApiError();
        apiError.setCode(1);
        apiError.setMessage(exception.getMessage());
        return HttpResponse
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .body(apiError);
    }
}

