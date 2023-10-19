package com.apdois.app.rules.shared.objectvalues;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Birthday {
    private Date date;

    public Birthday(String date) throws ParseException {
        if (!this.validateDateFormat(date)) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.date = dateFormat.parse(date);
    }

    public Date getDate() {
        return this.date;
    }

    public int getAge() {
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH) ||
                (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    private boolean validateDateFormat(String date) {
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
