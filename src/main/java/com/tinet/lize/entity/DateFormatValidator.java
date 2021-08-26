package com.tinet.lize.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * @author lize
 * @date 2021年08月23日 19:57
 */
public class DateFormatValidator  implements ConstraintValidator<DateFormat, String> {

    private DateFormat dateFormat;

    @Override
    public void initialize(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String format = dateFormat.format();
        if (format.equals("yyyy-MM")) {
            DateTimeFormatter dtf1 = new DateTimeFormatterBuilder()
                    .appendPattern(format)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .toFormatter();
            try {
                LocalDate.parse(s, dtf1);
            } catch (Exception e) {
                return false;
            }
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            try {
                simpleDateFormat.parse(s);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
