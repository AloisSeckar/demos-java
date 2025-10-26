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

        public static final Map<Integer, org.javademos.init.JEPInfo.JEPData> JEP_DATA = getAllInfos();
        public static final Map<Integer, IDemo> JEP_DEMO = getAllDemos();

        private static Map<Integer, org.javademos.init.JEPInfo.JEPData> getAllInfos() {
            var jeps = new HashMap<Integer, org.javademos.init.JEPInfo.JEPData>();

            var sources = Arrays.asList(14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
            for (Integer src : sources) {
                var srcFile = MessageFormat.format("/JDK{0}Info.json", src);
                try (InputStream inputStream = org.javademos.init.JEPInfo.class.getResourceAsStream(srcFile)) {
                    if (inputStream != null) {
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                            var JEPListType = new TypeToken<List<org.javademos.init.JEPInfo.JEPData>>() {
                            }.getType();
                            var gson = new Gson();
                            List<org.javademos.init.JEPInfo.JEPData> data = gson.fromJson(br, JEPListType);
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

        getJava11Demos(demos);
        getJava12Demos(demos);
        getJava14Demos(demos);
        getJava15Demos(demos);
        getJava16Demos(demos);
        getJava17Demos(demos);
        getJava18Demos(demos);
        getJava19Demos(demos);
        getJava20Demos(demos);
        getJava21Demos(demos);
        getJava22Demos(demos);
        getJava23Demos(demos);
        getJava24Demos(demos);
        getJava25Demos(demos);

        return demos;
    }

    private static void getJava11Demos(Map<Integer, IDemo> demos) {
        //TODO align old demos and add necessary JDKInfo.json

        // Java 11
//        demos.put(11, new J9Demo());
//        demos.put(11, new VarDemo());
//        demos.put(11, new HttpDemo());
//        demos.put(11, new String11Demo());
    }

    private static void getJava12Demos(Map<Integer, IDemo> demos) {
        //TODO align old demos and add necessary JDKInfo.json

        // Java 12
//        demos.put(12, new String12Demo());
    }

    private static void getJava14Demos(Map<Integer, IDemo> demos) {
        demos.put(305, new org.javademos.java14.jep305.InstanceofPatternMatchingPreview());
        demos.put(359, new org.javademos.java14.jep359.RecordsPreviewDemo());
        demos.put(370, new org.javademos.java14.jep370.ForeignMemoryAccessDemo());
    }

    private static void getJava15Demos(Map<Integer, IDemo> demos) {
        demos.put(339, new org.javademos.java15.jep339.EdDSADemo());
        demos.put(360, new org.javademos.java15.jep360.SealedClassesDemo());
        demos.put(371, new org.javademos.java15.jep371.HiddenClassesDemo());
        demos.put(372, new org.javademos.java15.jep372.NashornRemovalDemo());
        demos.put(373, new org.javademos.java15.jep373.DatagramSocketDemo());
        demos.put(375, new org.javademos.java15.jep375.InstanceofPatternMatchingSecondPreview());
        demos.put(381, new org.javademos.java15.jep381.SolarisSparcRemovalDemo());
        demos.put(383, new org.javademos.java15.jep383.ForeignMemoryAccessDemo());
        demos.put(384, new org.javademos.java15.jep384.RecordsSecondPreviewDemo());
    }

    private static void getJava16Demos(Map<Integer, IDemo> demos) {
        demos.put(338, new org.javademos.java16.jep338.VectorAPIDemo());
        demos.put(347, new org.javademos.java16.jep347.Cpp14FeaturesDemo());
        demos.put(380, new org.javademos.java16.jep380.UnixDomainSocketsDemo());
        demos.put(386, new org.javademos.java16.jep386.AlpineLinuxPortDemo());
        demos.put(388, new org.javademos.java16.jep388.WindowsPortDemo());
        demos.put(389, new org.javademos.java16.jep389.ForeignLinkerDemo());
        demos.put(390, new org.javademos.java16.jep390.ValueBasedClassesDemo());
        demos.put(392, new org.javademos.java16.jep392.PackagingToolDemo());
        demos.put(393, new org.javademos.java16.jep393.ForeignMemoryAccessDemo());
        demos.put(394, new org.javademos.java16.jep394.InstanceofPatternMatchingDemo());
        demos.put(395, new org.javademos.java16.jep395.RecordDemo());
        demos.put(396, new org.javademos.java16.jep396.EncapsulationDemo());
        demos.put(397, new org.javademos.java16.jep397.SealedClassesDemo());
    }

    private static void getJava17Demos(Map<Integer, IDemo> demos) {
        demos.put(356, new org.javademos.java17.jep356.RandomGeneratorsDemo());
        demos.put(306, new org.javademos.java17.jep306.RestoreAlwaysStrictFloatingPointSemanticsDemo());
        demos.put(382, new org.javademos.java17.jep382.MacosRenderingPipelineDemo());
        demos.put(391, new org.javademos.java17.jep391.MacOsAarch64PortDemo());
        demos.put(398, new org.javademos.java17.jep398.DeprecateAppletApiForRemovalDemo());
        demos.put(403, new org.javademos.java17.jep403.StronglyEncapsulateInternalsDemo());
        demos.put(406, new org.javademos.java17.jep406.PatternMatchingForSwitchPreview());
        demos.put(407, new org.javademos.java17.jep407.RemoveRmiActivationDemo());
        demos.put(409, new org.javademos.java17.jep409.SealedDemo());
        demos.put(410, new org.javademos.java17.jep410.RemoveAotJitDemo());
        demos.put(411, new org.javademos.java17.jep411.DeprecateSecurityManagerDemo());
        demos.put(412, new org.javademos.java17.jep412.ForeignFunctionMemoryDemo());
        demos.put(414, new org.javademos.java17.jep414.VectorAPIDemo());
        demos.put(415, new org.javademos.java17.jep415.ContextSpecificDeserializationFiltersDemo());
    }

    private static void getJava18Demos(Map<Integer, IDemo> demos) {
        demos.put(400, new org.javademos.java18.jep400.DefaultUTF8Demo());
        demos.put(408, new org.javademos.java18.jep408.SimpleWebServerDemo());
        demos.put(413, new org.javademos.java18.jep413.CodeSnippetsInJavadoc());
        demos.put(416, new org.javademos.java18.jep416.CoreReflectionWithMethodHandles());
        demos.put(417, new org.javademos.java18.jep417.VectorAPIDemo());
        demos.put(418, new org.javademos.java18.jep418.InternetAddressResolutionSPI());
        demos.put(419, new org.javademos.java18.jep419.ForeignFunctionMemoryDemo());
        demos.put(420, new org.javademos.java18.jep420.PatternMatchingForSwitchSecondPreview());
        demos.put(421, new org.javademos.java18.jep421.DeprecateFinalization());
    }

    private static void getJava19Demos(Map<Integer, IDemo> demos) {
        demos.put(405, new org.javademos.java19.jep405.RecordPatterns());
        demos.put(422, new org.javademos.java19.jep422.LinuxRiscVPort());
        demos.put(424, new org.javademos.java19.jep424.ForeignFunctionMemoryDemo());
        demos.put(425, new org.javademos.java19.jep425.VirtualThreads());
        demos.put(426, new org.javademos.java19.jep426.VectorAPIDemo());
        demos.put(427, new org.javademos.java19.jep427.PatternMatchingForSwitchThirdPreview());
        demos.put(428, new org.javademos.java19.jep428.StructuredConcurrencyDemo());
    }

    private static void getJava20Demos(Map<Integer, IDemo> demos) {
        demos.put(429, new org.javademos.java20.jep429.ScopedValuesDemo());
        demos.put(432, new org.javademos.java20.jep432.RecordPatterns());
        demos.put(433, new org.javademos.java20.jep433.PatternMatchingForSwitchFourthPreview());
        demos.put(434, new org.javademos.java20.jep434.ForeignFunctionMemoryDemo());
        demos.put(436, new org.javademos.java20.jep436.VirtualThreads());
        demos.put(437, new org.javademos.java20.jep437.StructuredConcurrencyDemo());
        demos.put(438, new org.javademos.java20.jep438.VectorAPIDemo());
    }

    private static void getJava21Demos(Map<Integer, IDemo> demos) {
        demos.put(430, new org.javademos.java21.jep430.StringTemplatesDemo());
        demos.put(431, new org.javademos.java21.jep431.SequencedCollectionsDemo());
        demos.put(439, new org.javademos.java21.jep439.GenerationalZGC21());
        demos.put(440, new org.javademos.java21.jep440.RecordPatternsDemo());
        demos.put(441, new org.javademos.java21.jep441.PatternMatchingForSwitchDemo());
        demos.put(442, new org.javademos.java21.jep442.ForeignFunctionMemoryDemo());
        demos.put(443, new org.javademos.java21.jep443.UnnamedPatternsAndVariablesPreview());
        demos.put(444, new org.javademos.java21.jep444.VirtualThreadsDemo());
        demos.put(445, new org.javademos.java21.jep445.UnnamedClassesDemo());
        demos.put(446, new org.javademos.java21.jep446.ScopedValuesDemo());
        demos.put(448, new org.javademos.java21.jep448.VectorAPIDemo());
        demos.put(449, new org.javademos.java21.jep449.DeprecateWindows32BitX86Demo());
        demos.put(451, new org.javademos.java21.jep451.DisallowDynamicAgentLoading());
        demos.put(452, new org.javademos.java21.jep452.KeyEncapsulationMechanismAPIDemo());
        demos.put(453, new org.javademos.java21.jep453.StructuredConcurrencyDemo());
    }

    private static void getJava22Demos(Map<Integer, IDemo> demos) {
        demos.put(423, new org.javademos.java22.jep423.RegionPinningForG1());
        demos.put(447, new org.javademos.java22.jep447.StatementsBeforeSuper());
        demos.put(454, new org.javademos.java22.jep454.ForeignFunctionMemoryDemo());
        demos.put(456, new org.javademos.java22.jep456.UnnamedPatternsAndVariablesDemo());
        demos.put(457, new org.javademos.java22.jep457.ClassFileAPIDemo());
        demos.put(458, new org.javademos.java22.jep458.LaunchMultiFileSourceDemo());
        demos.put(459, new org.javademos.java22.jep459.StringTemplatesSecondPreview());
        demos.put(460, new org.javademos.java22.jep460.VectorAPIDemo());
        demos.put(461, new org.javademos.java22.jep461.StreamGatherersDemo());
        demos.put(462, new org.javademos.java22.jep462.StructuredConcurrencyDemo());
        demos.put(463, new org.javademos.java22.jep463.ImplicitlyDeclaredClassesDemo());
        demos.put(464, new org.javademos.java22.jep464.ScopedValuesDemo());
    }

    private static void getJava23Demos(Map<Integer, IDemo> demos) {
        demos.put(455, new org.javademos.java23.jep455.PrimitiveTypesInPatterns());
        demos.put(466, new org.javademos.java23.jep466.ClassFileAPIDemo());
        demos.put(467, new org.javademos.java23.jep467.MarkdownComments());
        demos.put(469, new org.javademos.java23.jep469.VectorAPIDemo());
        demos.put(471, new org.javademos.java23.jep471.DeprecateMemoryAccessMethods());
        demos.put(473, new org.javademos.java23.jep473.StreamGatherersDemo());
        demos.put(474, new org.javademos.java23.jep474.GenerationalZGC23());
        demos.put(476, new org.javademos.java23.jep476.ModuleImportDeclarations());
        demos.put(477, new org.javademos.java23.jep477.ImplicitlyDeclaredClassesDemo());
        demos.put(480, new org.javademos.java23.jep480.StructuredConcurrency());
        demos.put(481, new org.javademos.java23.jep481.ScopedValuesDemo());
        demos.put(482, new org.javademos.java23.jep482.FlexibleConstructorBodies());
    }

    private static void getJava24Demos(Map<Integer, IDemo> demos) {
        demos.put(404, new org.javademos.java24.jep404.GenerationalShenandoahExperimental());
        demos.put(450, new org.javademos.java24.jep450.CompactObjectHeadersExperimental());
        demos.put(472, new org.javademos.java24.jep472.PrepareToRestrictJNI());
        demos.put(475, new org.javademos.java24.jep475.LateBarrierExpansionG1());
        demos.put(478, new org.javademos.java24.jep478.KeyDerivationApiPreview());
        demos.put(479, new org.javademos.java24.jep479.RemovedWindows32BitX86Demo());
        demos.put(483, new org.javademos.java24.jep483.AotLoadingAndLinking());
        demos.put(484, new org.javademos.java24.jep484.ClassFileAPIDemo());
        demos.put(485, new org.javademos.java24.jep485.StreamGatherersDemo());
        demos.put(486, new org.javademos.java24.jep486.DisableSecurityManager());
        demos.put(487, new org.javademos.java24.jep487.ScopedValuesDemo());
        demos.put(488, new org.javademos.java24.jep488.PrimitiveTypesSecondPreview());
        demos.put(489, new org.javademos.java24.jep489.VectorAPIDemo());
        demos.put(490, new org.javademos.java24.jep490.ZgcNonGenerationalModeRemoval());
        demos.put(491, new org.javademos.java24.jep491.SynchronizedNoPinning());
        demos.put(493, new org.javademos.java24.jep493.LinkingRunTimeImages493());
        demos.put(494, new org.javademos.java24.jep494.ModuleImportSecondPreview());
        demos.put(495, new org.javademos.java24.jep495.SimpleSourceFilesDemo());
        demos.put(496, new org.javademos.java24.jep496.QuantumResistantModuleLatticeBasedKeyEncapsulation());
        demos.put(497, new org.javademos.java24.jep497.QuantumResistantModuleLatticeBasedDigitalSignature());
        demos.put(498, new org.javademos.java24.jep498.MemoryAccessMethods());
        demos.put(499, new org.javademos.java24.jep499.StructuredConcurrencyDemo());
        demos.put(501, new org.javademos.java24.jep501.Deprecate32BitX86Demo());
    }

    private static void getJava25Demos(Map<Integer, IDemo> demos) {
        demos.put(470, new org.javademos.java25.jep470.PemEncodingsDemo());
        demos.put(502, new org.javademos.java25.jep502.StableValuesDemo());
        demos.put(503, new org.javademos.java25.jep503.Remove32BitX86Demo());
        demos.put(505, new org.javademos.java25.jep505.StructuredConcurrencyDemo());
        demos.put(506, new org.javademos.java25.jep506.ScopedValuesDemo());
        demos.put(507, new org.javademos.java25.jep507.PrimitiveTypesDemo());
        demos.put(508, new org.javademos.java25.jep508.VectorAPIDemo());
        demos.put(509, new org.javademos.java25.jep509.CpuTimeProfilingDemo());
        demos.put(510, new org.javademos.java25.jep510.KeyDerivationFunctionDemo());
        demos.put(511, new org.javademos.java25.jep511.ModuleImportDeclarationsDemo());
        demos.put(512, new org.javademos.java25.jep512.CompactSourceFilesDemo());
        demos.put(513, new org.javademos.java25.jep513.FlexibleConstructorBodiesDemo());
        demos.put(514, new org.javademos.java25.jep514.AheadOfTimeCLIDemo());
        demos.put(515, new org.javademos.java25.jep515.AheadOfTimeMethodProfilingDemo());
        demos.put(518, new org.javademos.java25.jep518.JFRCooperativeSamplingDemo());
        demos.put(519, new org.javademos.java25.jep519.CompactObjectHeaderDemo());
        demos.put(520, new org.javademos.java25.jep520.Jep520MethodTracingDemo());
        demos.put(521, new org.javademos.java25.jep521.GenerationalShenandoahDemo());
    }
}
