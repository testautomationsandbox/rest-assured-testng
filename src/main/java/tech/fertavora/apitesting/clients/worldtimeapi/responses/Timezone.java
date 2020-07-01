package tech.fertavora.apitesting.clients.worldtimeapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timezone {
    private int weekNumber;
    private String utcOffset;
    private String utcDatetime; // would be Date
    private int unixtime;
    private String timezone;
    private int rawOffset;
    private String dstUntil;
    private int dstOffset;
    private String dstFrom;
    private Boolean dst;
    private int dayOfYear;
    private int dayOfWeek;
    private String datetime; // would be Date
    private String clientIp; // would be IP
    private String abbreviation;

    @JsonProperty("week_number")
    public int getWeekNumber() {
        return weekNumber;
    }

    @JsonProperty("utc_offset")
    public String getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utc_datetime")
    public String getUtcDatetime() {
        return utcDatetime;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("raw_offset")
    public int getRawOffset() {
        return rawOffset;
    }

    @JsonProperty("dst_until")
    public String getDstUntil() {
        return dstUntil;
    }

    @JsonProperty("dst_offset")
    public int getDstOffset() {
        return dstOffset;
    }

    @JsonProperty("dst_from")
    public String getDstFrom() {
        return dstFrom;
    }

    public Boolean getDst() {
        return dst;
    }

    @JsonProperty("day_of_year")
    public int getDayOfYear() {
        return dayOfYear;
    }

    @JsonProperty("day_of_week")
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("client_ip")
    public String getClientIp() {
        return clientIp;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
