package cyou.zhaojin;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Zhao JIN
 */
public class RecordUtil {
    private static final Map<Integer, String> map = new HashMap<>();
    private static void analyse() {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(RecordUtil.class.getResourceAsStream("/record.txt"))
                ))) {
            String curr = null;
            while ((curr = reader.readLine()) != null) {
                String[] pair = curr.split(" ");
                map.put(Integer.valueOf(pair[0]), pair[1]);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    static {
        analyse();
    }

    public static void text(int num) {
        System.out.println(num + " : " + map.get(num));
    }
}
