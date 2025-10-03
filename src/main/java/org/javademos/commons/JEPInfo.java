package org.javademos.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.MessageFormat;
import java.util.*;

public class JEPInfo {

    private JEPInfo() {}

    public record JEPDataInfo(String name, String dscr) {}
    public record JEPData(int jep, JEPDataInfo info) {}

    public static Map<Integer, JEPDataInfo> JEP_INFO = getAllEntries();

    private static Map<Integer, JEPDataInfo> getAllEntries() {
        var jeps = new HashMap<Integer, JEPDataInfo>();

        var sources = Arrays.asList(21, 22, 23, 24, 25);
        for (Integer src : sources) {
            var srcFile = MessageFormat.format("/JDK{0}Info.json", src);
            try (InputStream inputStream = JEPInfo.class.getResourceAsStream(srcFile)) {
                if (inputStream != null) {
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                        var JEPListType = new TypeToken<List<JEPData>>() {
                        }.getType();
                        var gson = new Gson();
                        List<JEPData> data = gson.fromJson(br, JEPListType);
                        data.forEach(d -> jeps.put(d.jep(), d.info()));
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
