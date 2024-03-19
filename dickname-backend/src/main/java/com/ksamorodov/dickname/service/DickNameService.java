package com.ksamorodov.dickname.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DickNameService {
    private static final String PREFIX = "Хуи";
    private static final String PREFIX_EXCEPTION = "Хуй";
    private static final String PREFIX_EXCEPTION_ANTON = "Антон";

    public String generateDickSentence(String sentence) {
        String[] words = sentence.split("\\s+");

        // Обрабатываем каждое слово с помощью createDickName
        String[] dickNames = Arrays.stream(words)
                .map(i -> createDickName(i))
                .toArray(String[]::new);

        // Объединяем обработанные слова обратно в строку
        return String.join(" ", dickNames);

    }

    private String createDickName(String name) {
        name = name.toLowerCase();

        boolean isFirstLetterVowel = name.matches("^(?ui:[аеёиоуыэюя]).*");
        boolean isFirstLetterVowelCompositePart = name.matches("^(?ui:[эоуа]).*");
        boolean isFirstLetterVowelComposite = name.matches("^(?ui:[еёюя]).*");

        boolean isSecondLetterVowel = name.matches("^(?ui:.[аиоуыэеёюя]).*");
        boolean isSecondLetterShortI = name.matches("^(?ui:.[й]*)");
        boolean isSecondLetterVowelCompositePart = name.matches("^(?ui:.[эоуа]).*");
        boolean isSecondLetterVowelComposite = name.matches("^(?ui:.[еёюя]).*");

        boolean isThirdLetterVowel = name.matches("^(?ui:..[аиоуыэеёюя]).*");
        boolean isThirdLetterVowelCompositePart = name.matches("^(?ui:..[эоуа]).*");
        boolean isThirdLetterVowelComposite = name.matches("^(?ui:..[еёюя]).*");

        if (name.equals(PREFIX.toLowerCase())) {
            return PREFIX;
        }

        if (name.equals(PREFIX_EXCEPTION.toLowerCase())) {
            return PREFIX_EXCEPTION;
        }

        if (name.equals(PREFIX_EXCEPTION_ANTON.toLowerCase())) {
            return "Гондон";
        }

        if (name.length() == 1 && isFirstLetterVowelCompositePart) {
            return PREFIX.substring(0, 2).concat(compositePartVowelToFullComposite(name.charAt(0)));
        } else if (isFirstLetterVowelComposite) {
            return PREFIX.substring(0, 2).concat(name);
        } else if (name.length() == 1) {
            return name;
        }

        if (isSecondLetterShortI) {
            return PREFIX_EXCEPTION.concat(name.substring(2));
        } else if (isFirstLetterVowel && isFirstLetterVowelCompositePart) {
            return PREFIX.substring(0, 2).concat(compositePartVowelToFullComposite(name.charAt(0)) + name.substring(1));
        }else if (isFirstLetterVowel) {
            return PREFIX.substring(0, 2).concat(name);
        } else if (isSecondLetterVowel && isSecondLetterVowelCompositePart) {
            return PREFIX.substring(0, 2).concat(compositePartVowelToFullComposite(name.charAt(1)) + name.substring(2));
        } else if (isSecondLetterVowel && isSecondLetterVowelComposite) {
            return PREFIX.substring(0, 2).concat(name.substring(1));
        } if (isSecondLetterVowel) {
            return PREFIX.concat(name.substring(2));
        } else if (isThirdLetterVowel && isThirdLetterVowelCompositePart) {
            return PREFIX.substring(0, 2).concat(compositePartVowelToFullComposite(name.charAt(2))).concat(name.substring(3));
        } else if (isThirdLetterVowel) {
            return PREFIX.substring(0, 2).concat(String.valueOf(name.charAt(2))).concat(name.substring(3));
        } else {
            return PREFIX.concat(name.substring(1));
        }
    }

    public String compositePartVowelToFullComposite(Character compositePart) {
        switch (compositePart) {
            case 'а': return "я";
            case 'э': return "е";
            case 'о': return "ё";
            case 'у': return "ю";
            default: return "";
        }
    }
}
