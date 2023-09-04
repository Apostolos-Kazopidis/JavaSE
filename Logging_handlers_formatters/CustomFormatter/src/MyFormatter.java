import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        Instant instant = record.getInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDate date = LocalDate.ofInstant(instant, zone);

        return record.getMessage() + " [" +
                date.getDayOfWeek() + " " + date.getDayOfMonth() +
                " " + date.getMonth() + " " + date.getYear() + "]\n";
    }
}
