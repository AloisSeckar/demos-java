package org.javademos.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.MessageFormat;
import java.util.*;

public class JEPInfo {

    private JEPInfo() {}

    public record JEPData(int jep, int jdk, String name, String dscr, boolean link, boolean code) {}

    public static Map<Integer, JEPData> JEP_INFO = getAllEntries();

    private static Map<Integer, JEPData> getAllEntries() {
        var jeps = new HashMap<Integer, JEPData>();

        var sources = Arrays.asList(14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
        for (Integer src : sources) {
            var srcFile = MessageFormat.format("/JDK{0}Info.json", src);
            try (InputStream inputStream = JEPInfo.class.getResourceAsStream(srcFile)) {
                if (inputStream != null) {
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                        var JEPListType = new TypeToken<List<JEPData>>() {
                        }.getType();
                        var gson = new Gson();
                        List<JEPData> data = gson.fromJson(br, JEPListType);
                        data.forEach(d -> jeps.put(d.jep(), d));
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                    }
                } else {
                    System.err.println(MessageFormat.format("InputStream {0} is null", src));
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

        return jeps;
    }

}
