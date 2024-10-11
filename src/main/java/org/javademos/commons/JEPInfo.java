package org.javademos.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JEPInfo {

    private JEPInfo() {}

    public record JEPDataInfo(String name, String dscr) {}
    public record JEPData(int jep, JEPDataInfo info) {}

    public static Map<Integer, JEPDataInfo> JEP_INFO = getAllEntries();

    private static Map<Integer, JEPDataInfo> getAllEntries() {
        var jeps = new HashMap<Integer, JEPDataInfo>();

        InputStream inputStream = JEPInfo.class.getResourceAsStream("/JEPInfo.json");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            var JEPListType = new TypeToken<List<JEPData>>() {}.getType();
            var gson = new Gson();
            List<JEPData> data = gson.fromJson(br, JEPListType);
            data.forEach(d -> jeps.put(d.jep(), d.info()));
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return jeps;
    }

}
