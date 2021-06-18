package services;

import api.services.NumberClassConverter;

public class NumberClassConverterRus implements NumberClassConverter {
    private static final String[][] className={
        {"тысяч"},
        {"миллион"},
            {"миллиард"},
            {"триллион"},
            {"квадриллион"},
            {"квинтиллион"},
            {"секстиллион"},
            {"септиллион"},
            {"октиллион"},
            {"нониллион"},
            {"дециллион"},
            {"ундециллион"},

        };

    @Override
    public String getNumberClassText(String numberClass) {
        return null;
    }
}
