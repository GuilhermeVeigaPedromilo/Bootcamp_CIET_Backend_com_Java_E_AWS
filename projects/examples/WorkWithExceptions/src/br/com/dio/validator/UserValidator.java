package br.com.dio.validator;

import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;

public class UserValidator {
    private UserValidator(){}
    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName())) throw new ValidatorException("Enter a valid username");
        if (model.getName().length() <= 1) throw new ValidatorException("The name must be at least more than one character long");
        if (stringIsBlank(model.getEmail())) throw new ValidatorException("Enter a valid e-mail address");
        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains("."))) throw new ValidatorException("Enter a valid email address");
    }

    private static boolean stringIsBlank(final String value) {
        return value == null || value.isBlank();
    }
}
