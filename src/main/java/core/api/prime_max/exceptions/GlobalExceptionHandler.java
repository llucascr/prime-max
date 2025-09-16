package core.api.prime_max.exceptions;

import core.api.prime_max.exceptions.followers.AlreadyFollowThisUser;
import core.api.prime_max.exceptions.followers.FollowerNotFound;
import core.api.prime_max.exceptions.followers.UserCannotFollowHimself;
import core.api.prime_max.exceptions.users.InactiveUser;
import core.api.prime_max.exceptions.users.UserAlreadyExist;
import core.api.prime_max.exceptions.users.UserAlreadyPremium;
import core.api.prime_max.exceptions.users.UserNotFound;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // User
    @ExceptionHandler(UserNotFound.class)
    public ProblemDetail handleUserNotFound (UserNotFound ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(InactiveUser.class)
    public ProblemDetail inactiveUser(InactiveUser ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(UserAlreadyExist.class)
    public ProblemDetail userAlreadyExist(UserAlreadyExist ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(UserAlreadyPremium.class)
    public ProblemDetail userAlreadyPremium(UserAlreadyPremium ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    // Follower
    @ExceptionHandler(UserCannotFollowHimself.class)
    public ProblemDetail userCannotFollowHimself(UserCannotFollowHimself ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(AlreadyFollowThisUser.class)
    public ProblemDetail alreadyFollowThisUser(AlreadyFollowThisUser ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(FollowerNotFound.class)
    public ProblemDetail followerNotFound(FollowerNotFound ex) {
        ProblemDetail problem = ProblemDetail.forStatus(ex.getHttpStatus());
        problem.setTitle(ex.getCode());
        problem.setDetail(ex.getMessage());
        return problem;
    }

}
