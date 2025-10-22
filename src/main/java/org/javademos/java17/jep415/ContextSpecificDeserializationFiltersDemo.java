package org.javademos.java17.jep415; // Only ONE package declaration

import org.javademos.commons.IDemo;
import java.io.*;
import java.util.function.BinaryOperator;

/// Demo for JDK 17 feature JEP 415 - Context-Specific Deserialization Filters.
///
/// Allows configuring context-specific and dynamically-selected deserialization
/// filters via a JVM-wide filter factory. This factory is invoked for each
/// deserialization operation to select an appropriate filter.
///
/// JEP history:
/// - JDK 17: [JEP 415 - Context-Specific Deserialization Filters](https://openjdk.org/jeps/415)
///
/// Further reading:
/// - [JEP 290 - Filter Incoming Serialization Data](https://openjdk.org/jeps/290)
/// - [Understanding Java Deserialization Filters](https://foojay.io/today/understanding-java-deserialization-filters/)
///
/// @author Adarsh80416
public class ContextSpecificDeserializationFiltersDemo implements IDemo { // Only ONE class definition starts here

    // Simple class for demonstration
    static class UserData implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;

        UserData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "UserData{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    // A simple filter factory implementation
    static class MyFilterFactory implements BinaryOperator<ObjectInputFilter> {
        @Override
        public ObjectInputFilter apply(ObjectInputFilter currentFilter, ObjectInputFilter requestedFilter) {
            System.out.println("Filter Factory invoked!");
            System.out.println("  Current filter: " + currentFilter);
            System.out.println("  Requested filter: " + requestedFilter);

            // Create a specific filter for this context
            // Allows our UserData class and basic Java types, rejects everything else.
            ObjectInputFilter myContextFilter = ObjectInputFilter.Config.createFilter(
                    UserData.class.getName() + ";java.base/*;!*"
            );

            // If a filter was requested (e.g., via OIS constructor), merge it
            if (requestedFilter != null) {
                 System.out.println("  Merging requested filter with context filter.");
                 // Merge: reject if either rejects, allow if either allows, else undecided
                 return ObjectInputFilter.merge(requestedFilter, myContextFilter);
            } else {
                 System.out.println("  Applying context filter.");
                 return myContextFilter;
            }
            // For simplicity, we are not using the 'currentFilter' here,
            // but a real factory might combine current, requested, and context filters.
        }
    }


    @Override
    public void demo() {
        info(415);

        System.out.println("Setting a JVM-wide filter factory...");
        BinaryOperator<ObjectInputFilter> originalFactory = ObjectInputFilter.Config.getSerialFilterFactory();
        MyFilterFactory factory = new MyFilterFactory();
        
        try {
            ObjectInputFilter.Config.setSerialFilterFactory(factory);
            System.out.println("Filter factory set successfully.\n");
        } catch (IllegalStateException e) {
            System.out.println("Filter factory already set (can only be set once per JVM).");
            System.out.println("This is expected behavior in JEP 415 - proceeding with existing factory.\n");
            // Continue with demo using existing factory
        }

        // --- Simulate Serialization ---
        UserData originalUser = new UserData("Alice", 30);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(originalUser);
            System.out.println("Serialized: " + originalUser);
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
            // Attempt to restore original factory in case of error during setup
            try {
                ObjectInputFilter.Config.setSerialFilterFactory(originalFactory);
            } catch (IllegalStateException ex) {
                System.out.println("Cannot restore factory during error cleanup.");
            }
            return;
        }
        byte[] serializedData = baos.toByteArray();
        System.out.println();

        // --- Simulate Deserialization ---
        System.out.println("Attempting deserialization...");
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            // Setting a JVM-wide filter is often done via system properties,
            // but we demonstrate the factory intercepts even without a per-stream filter.
            // The OIS constructor implicitly calls the factory.
            UserData deserializedUser = (UserData) ois.readObject();
            System.out.println("Deserialized successfully: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed as expected by filter or other error: " + e.getMessage());
        } finally {
             // --- Cleanup: Attempt to restore original filter factory ---
             // Note: This will only work if we successfully set our factory earlier
             System.out.println("\nAttempting to restore original filter factory...");
             try {
                 ObjectInputFilter.Config.setSerialFilterFactory(originalFactory);
                 System.out.println("Original filter factory restored.");
             } catch (IllegalStateException e) {
                 System.out.println("Cannot restore factory (factory can only be set once per JVM).");
             }
        }
    }
}