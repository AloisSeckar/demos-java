package org.javademos.java14.jep352;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.javademos.commons.IDemo;

/// Demo for JDK 14 feature JEP 352 - Non-Volatile Mapped Byte Buffers.
///
/// This JEP extends the MappedByteBuffer API to provide access to non-volatile memory (NVM).
/// It adds new methods to FileChannel that allow Java programs to create MappedByteBuffer instances
/// over non-volatile memory, and provides methods to control when changes are forced to storage.
///
/// Key API additions:
/// - FileChannel.map() now supports MapMode.READ_WRITE_SYNC mode for non-volatile memory
/// - MappedByteBuffer.force() to ensure data is written to storage
///
/// JEP history:
/// - JDK 14: [JEP 352 - Non-Volatile Mapped Byte Buffers](https://openjdk.org/jeps/352)
///
/// Further reading:
/// - [JEP 352: Non-Volatile Mapped Byte Buffers](https://openjdk.org/jeps/352)
/// - [Non-Volatile Memory Access](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/nio/channels/FileChannel.html#map(java.nio.channels.FileChannel.MapMode,long,long))
///
/// @author Abhineshhh
public class NonVolatileMappedByteBuffersDemo implements IDemo {

    @Override
    public void demo() {
        info(352);

        System.out.println("=== Basic Mapped Byte Buffer ===");
        demonstrateBasicMapping();

        System.out.println("\n=== Force and Load Operations ===");
        demonstrateForceAndLoad();

        System.out.println("\n=== Read-Write-Sync Mode ===");
        demonstrateReadWriteSyncMode();
    }

    /**
     * Demonstrates basic file mapping with MappedByteBuffer.
     * This creates a memory-mapped file that can be accessed like an array.
     */
    private void demonstrateBasicMapping() {
        System.out.println("Creating and writing to a memory-mapped file...");
        
        Path tempFile = null;
        try {
            // Create a temporary file in the tmp directory
            tempFile = Path.of("tmp", "mapped-buffer-demo.dat");
            Files.createDirectories(tempFile.getParent());
            
            // Open file channel and create mapped buffer
            try (FileChannel channel = FileChannel.open(tempFile,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE)) {
                
                // Map 1KB of the file into memory
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
                
                // Write some data
                String message = "Hello, Non-Volatile Memory!";
                byte[] messageBytes = message.getBytes();
                buffer.putInt(messageBytes.length); // Write length first
                buffer.put(messageBytes);
                buffer.putInt(42);
                buffer.putDouble(3.14159);
                
                System.out.println("  Data written to mapped buffer");
                System.out.println("  Buffer position: " + buffer.position());
                System.out.println("  Buffer capacity: " + buffer.capacity());
                
                // Read back the data - reset position to beginning
                buffer.position(0);
                int stringLength = buffer.getInt();
                byte[] bytes = new byte[stringLength];
                buffer.get(bytes);
                int value = buffer.getInt();
                double pi = buffer.getDouble();
                
                System.out.println("  Read string: " + new String(bytes));
                System.out.println("  Read int: " + value);
                System.out.println("  Read double: " + pi);
            }
            
        } catch (IOException e) {
            System.err.println("  Error: " + e.getMessage());
        } finally {
            // Clean up
            try {
                if (tempFile != null && Files.exists(tempFile)) {
                    Files.delete(tempFile);
                    System.out.println("  Cleaned up temporary file");
                }
            } catch (IOException e) {
                System.err.println("  Cleanup error: " + e.getMessage());
            }
        }
    }

    /**
     * Demonstrates the force() method which ensures changes are written to storage.
     * This is crucial for non-volatile memory to guarantee data persistence.
     */
    private void demonstrateForceAndLoad() {
        System.out.println("Demonstrating force() to persist changes...");
        
        Path tempFile = null;
        try {
            tempFile = Path.of("tmp", "force-demo.dat");
            Files.createDirectories(tempFile.getParent());
            
            try (FileChannel channel = FileChannel.open(tempFile,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE)) {
                
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 512);
                
                // Write critical data
                buffer.put("Critical data that must be persisted".getBytes());
                
                System.out.println("  Data written to buffer (in memory)");
                
                // Force changes to be written to storage
                // This is important for ensuring data durability
                buffer.force();
                
                System.out.println("  force() called - changes are now in storage");
                System.out.println("  This ensures data persistence even if the system crashes");
                
                // The load() method loads the entire mapped region into physical memory
                // This can improve performance for subsequent accesses
                buffer.load();
                System.out.println("  load() called - entire region loaded into physical memory");
                
                // Check if the buffer is currently loaded
                System.out.println("  isLoaded(): " + buffer.isLoaded());
            }
            
        } catch (IOException e) {
            System.err.println("  Error: " + e.getMessage());
        } finally {
            try {
                if (tempFile != null && Files.exists(tempFile)) {
                    Files.delete(tempFile);
                }
            } catch (IOException e) {
                // Ignore cleanup errors
            }
        }
    }

    /**
     * Demonstrates the concepts behind READ_WRITE_SYNC mode for non-volatile memory.
     * Note: The actual MapMode.READ_WRITE_SYNC is primarily useful with NVM hardware.
     * 
     * MapMode.READ_WRITE_SYNC mode (introduced in JEP 352):
     * - Designed for non-volatile memory (NVM) devices
     * - Provides synchronous writes that bypass the page cache
     * - Ensures data durability without explicit force() calls
     * - Optimized for byte-addressable persistent memory
     * 
     * Key benefits:
     * - Reduced latency for persistent writes
     * - Guaranteed data durability after each write
     * - Better performance on NVM hardware like Intel Optane
     * 
     * Traditional READ_WRITE mode:
     * - Writes go through the page cache
     * - Requires force() to ensure persistence
     * - Optimized for traditional block storage
     * 
     * When to use:
     * - Use READ_WRITE_SYNC for NVM-backed files when durability is critical
     * - Use READ_WRITE for traditional storage or when buffering is acceptable
     */
    private void demonstrateReadWriteSyncMode() {
        System.out.println("Demonstrating concepts for non-volatile memory access...");
        
        // Example of how you would use it (conceptual, as NVM hardware is not common):
        Path tempFile = null;
        try {
            tempFile = Path.of("tmp", "nvm-demo.dat");
            Files.createDirectories(tempFile.getParent());
            
            try (FileChannel channel = FileChannel.open(tempFile,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE)) {
                
                // With traditional READ_WRITE mode
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 256);
                buffer.put("Data with traditional mode".getBytes());
                buffer.force(); // Explicit force needed for durability
                
                System.out.println("  Traditional mode: explicit force() required for durability");
                
                // In a real NVM environment, you would use:
                // MappedByteBuffer nvmBuffer = channel.map(
                //     FileChannel.MapMode.READ_WRITE_SYNC, 0, 256);
                // nvmBuffer.put("Data with NVM mode".getBytes());
                // No force() needed - writes are synchronous and durable
                
                System.out.println("  NVM mode: writes are automatically durable (no force needed)");
            }
            
        } catch (IOException e) {
            System.err.println("  Error: " + e.getMessage());
        } finally {
            try {
                if (tempFile != null && Files.exists(tempFile)) {
                    Files.delete(tempFile);
                }
            } catch (IOException e) {
                // Ignore cleanup errors
            }
        }
    }
}
