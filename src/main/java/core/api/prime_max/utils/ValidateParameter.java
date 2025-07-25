package core.api.prime_max.utils;

import core.api.prime_max.exceptions.ValidateParameterException;

public class ValidateParameter {

    private ValidateParameter() {}

    public static Long validate(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            throw new ValidateParameterException("Parâmetro Inválido " + ex.getMessage());
        }
    }
}
