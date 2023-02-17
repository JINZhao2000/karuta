package cyou.zhaojin;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.AudioFileReader;
import java.applet.AudioClip;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Zhao JIN
 */
public class PlayerUtil {
    private static final int BUFFER_SIZE = 4096;
    public static void play(int i) {
        try (
                AudioInputStream stream = AudioSystem.getAudioInputStream(
                        Objects.requireNonNull(PlayerUtil.class.getResource("/audio/" + i + ".wav")));
                SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, stream.getFormat()));
        ) {
            dataLine.open(stream.getFormat());
            dataLine.start();
            final byte[] buffer = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = stream.read(buffer)) != -1) {
                dataLine.write(buffer, 0, readBytes);
            }
            dataLine.drain();
        } catch (Exception e) {
            System.err.println("Sound "+i+".wav error");
            e.printStackTrace();
            System.exit(2);
        }
    }
}
