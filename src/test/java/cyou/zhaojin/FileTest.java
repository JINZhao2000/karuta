package cyou.zhaojin;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

/**
 * @author Zhao JIN
 */

public class FileTest {
    @Test
    public void sound() {
        Assert.assertNotNull(PlayerUtil.class.getResource("/audio/0.wav"));
    }

    @Test
    public void record() {
        Assert.assertNotNull(RecordUtil.class.getResourceAsStream("/record.txt"));
    }
}
