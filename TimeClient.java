import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {
    void setTime(int hour, int minute, int second);

    void setDate(int day, int month, int year);

    void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

    LocalDateTime getLocalDateTime();

    static ZoneId getZoneId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.out.println("Invalid zone " + zoneString + "; using default time zone insted");
            return ZoneId.systemDefault();

        }
    }

    default ZonedDateTime getZoneDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(),getZoneId(zoneString));
    }
}
