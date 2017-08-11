package app.model.parsers.util;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;

    public ValidationUtil() {

    }

    public static <T> boolean isValid (T t) {
        return t != null && validator.validate(t).size() == 0;
    }
}
