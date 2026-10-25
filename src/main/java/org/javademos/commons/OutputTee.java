package org.javademos.commons;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/// Duplicates everything written to `System.out` and `System.err` into a UTF-8 file.
///
/// The file is truncated on every run. Console output remains unchanged.
///
/// @author Alois Seckar <alois.seckar@gmail.com>
public final class OutputTee {

    public static final String DEFAULT_OUTPUT = "demos-java.output";

    private OutputTee() {
    }

    /// Redirects `System.out` and `System.err` to both the console and the given file.
    ///
    /// @param file target file (created or truncated), relative paths are resolved against the CWD,
    ///             missing parent directories are created
    /// @throws IllegalArgumentException if the file cannot be opened for writing
    public static void install(Path file) {
        OutputStream fileStream;
        try {
            Files.createDirectories(file.toAbsolutePath().getParent());
            // Unbuffered on purpose, so nothing is lost when a demo crashes or calls System.exit
            fileStream = Files.newOutputStream(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open output file: " + file, e);
        }

        // Single lock keeps stdout and stderr in their original order within the file
        var lock = new Object();
        System.setOut(wrap(System.out, fileStream, lock));
        System.setErr(wrap(System.err, fileStream, lock));
    }

    private static PrintStream wrap(PrintStream console, OutputStream file, Object lock) {
        return new PrintStream(new TeeStream(console, file, lock), true, StandardCharsets.UTF_8);
    }

    /// Receives UTF-8 bytes. The file gets them as they are, the console gets them
    /// re-encoded in its own charset, so the file does not lose characters the console cannot show.
    private static final class TeeStream extends OutputStream {

        private final PrintStream console;
        private final OutputStream file;
        private final Object lock;
        private final CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder()
                .onMalformedInput(CodingErrorAction.REPLACE)
                .onUnmappableCharacter(CodingErrorAction.REPLACE);
        // incomplete multi-byte sequence split between two writes
        private final byte[] carry = new byte[4];
        private int carryLen;

        TeeStream(PrintStream console, OutputStream file, Object lock) {
            this.console = console;
            this.file = file;
            this.lock = lock;
        }

        @Override
        public void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            synchronized (lock) {
                file.write(b, off, len);

                var data = new byte[carryLen + len];
                System.arraycopy(carry, 0, data, 0, carryLen);
                System.arraycopy(b, off, data, carryLen, len);
                var in = ByteBuffer.wrap(data);
                var chars = CharBuffer.allocate(data.length);
                decoder.decode(in, chars, false);
                carryLen = in.remaining();
                in.get(carry, 0, carryLen);

                chars.flip();
                if (chars.hasRemaining()) {
                    console.print(chars.toString());
                    console.flush();
                }
            }
        }

        @Override
        public void flush() throws IOException {
            synchronized (lock) {
                console.flush();
                file.flush();
            }
        }
    }
}
