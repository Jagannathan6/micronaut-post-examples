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
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Produces
@Singleton
@Primary
public class ConstraintsViolationsExceptionHandler
        implements ExceptionHandler<ConstraintViolationException, HttpResponse> {

    @Override
    public HttpResponse
    handle(HttpRequest request, ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolationExceptionSet =
                exception.getConstraintViolations();

        List<String> messages = new ArrayList<>();

        for (ConstraintViolation<?> constraintViolation : constraintViolationExceptionSet) {
            messages.add(constraintViolation.getMessage());
        }

        ApiError apiError = new ApiError();
        apiError.setCode(1);
        apiError.setMessage(messages.get(0));
        return HttpResponse
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .body(apiError);
    }
}

