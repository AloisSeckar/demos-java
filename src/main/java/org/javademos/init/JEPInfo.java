package org.javademos.init;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.javademos.commons.IDemo;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;

    public class JEPInfo {

        private JEPInfo() {}

        public record JEPData(int jep, int jdk, String name, String dscr, boolean link, boolean code) {}

        public static final Map<Integer, JEPData> JEP_DATA = getAllInfos();
        public static final Map<Integer, IDemo> JEP_DEMO = getAllDemos();

        private static Map<Integer, JEPData> getAllInfos() {
            var jeps = new HashMap<Integer, JEPData>();

            var sources = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
            for (Integer src : sources) {
                var srcFile = MessageFormat.format("/JDK{0}Info.json", src);
                try (InputStream inputStream = org.javademos.init.JEPInfo.class.getResourceAsStream(srcFile)) {
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

    private static Map<Integer, IDemo> getAllDemos() {
        var demos = new HashMap<Integer, IDemo>();

        new Java11DemoLoader().loadDemos(demos);
        new Java12DemoLoader().loadDemos(demos);
        new Java13DemoLoader().loadDemos(demos);
        new Java14DemoLoader().loadDemos(demos);
        new Java15DemoLoader().loadDemos(demos);
        new Java16DemoLoader().loadDemos(demos);
        new Java17DemoLoader().loadDemos(demos);
        new Java18DemoLoader().loadDemos(demos);
        new Java19DemoLoader().loadDemos(demos);
        new Java20DemoLoader().loadDemos(demos);
        new Java21DemoLoader().loadDemos(demos);
        new Java22DemoLoader().loadDemos(demos);
        new Java23DemoLoader().loadDemos(demos);
        new Java24DemoLoader().loadDemos(demos);
        new Java25DemoLoader().loadDemos(demos);

        return demos;
    }

}
