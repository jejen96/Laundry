package com.jejen.test.laundry.system.common;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final String APP_KEY = "app";
    public static final String FUNCTION_KEY = "function";
    public static final String VERSION_KEY = "version";
    public static final String TYPE_KEY = "type";
    public static final String TRANS_ID_KEY = "trans-id";
    public static final String OPERAND_NAME = "operand";
    public static final String FIELD_NAME = "fieldName";
    public static final String VALUE_NAME = "value";
    public static final String[] READ_ONLY_FIELDS = {
            "CONTROL.DESC", "CONTROL.APPLICATION",
          
            "AUDITOR.CODE", "AUDIT.DATE.TIME"
    };
    public static final char[] PROTECT_CHARS = {'\'', '"', ',', '(', ')', '/'};
    public static final char[] REPLACE_CHARS = {'@', '|', '?', '{', '}', '^'};

    public static final String[] IGONRE_CHILD = {"ENQ", "COS", "TAB", "QUERY"};


    public static final String[] SKIP_NAMES = {APP_KEY, FUNCTION_KEY, VERSION_KEY, TRANS_ID_KEY, "transId", OPERAND_NAME, FIELD_NAME, VALUE_NAME,"type","target"};

    public static final Map<String, String> DEFAULT_PARAM = ImmutableMap.of(
            APP_KEY, "",
            FUNCTION_KEY, "",
            VERSION_KEY, "",
            TYPE_KEY, "",
            TRANS_ID_KEY, ""
    );

    public static String escapeOFS(String params) {
        StringBuilder response = new StringBuilder(escapeOFSApp(params));
        if (response.toString().contains(" ")) {
            return "\"" + response.toString() + "\"";
        }
        return response.toString();
    }

    public static String escapeOFSApp(String params) {
        StringBuilder response = new StringBuilder();
        for (char c : params.toCharArray()) {
            char tmp = c;
            for (int i = 0; i < PROTECT_CHARS.length; i++) {
                if (c == PROTECT_CHARS[i]) {
                    tmp = REPLACE_CHARS[i];
                    break;
                }
            }
            response.append(tmp);
        }

        return response.toString();
    }



    public static String clearQuotes(String search) {
        Pattern pattern = Pattern.compile("\"(.*)\"");
        Matcher matcher = pattern.matcher(search);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return search;
    }
}
