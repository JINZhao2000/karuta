package cyou.zhaojin;

import javax.print.attribute.standard.PrinterLocation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao JIN
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            final List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                list.add(i);
            }
            Collections.shuffle(list);

            System.out.println("=== Prepare ===");
            PlayerUtil.play(0);
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                RecordUtil.text(num);
                PlayerUtil.play(num);
            }
            System.out.println("===   End   ===");
        } else {
            int num = Integer.valueOf(args[0]);
            RecordUtil.text(num);
            PlayerUtil.play(num);
        }
    }
}
