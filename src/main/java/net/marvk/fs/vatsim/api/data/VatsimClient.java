package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import net.marvk.fs.vatsim.api.deserialization.ZonedDateTimeDeserializer;

import java.time.ZonedDateTime;

@Data
public class VatsimClient {
    @Expose
    private final String callsign;

    @Expose
    private final String cid;

    @Expose
    @SerializedName("realname")
    private final String realName;

    @Expose
    @SerializedName("clienttype")
    private final String clientType;

    @Expose
    private final String frequency;

    @Expose
    private final String latitude;

    @Expose
    private final String longitude;

    @Expose
    private final String altitude;

    @Expose
    @SerializedName("groundspeed")
    private final String groundSpeed;

    @Expose
    @SerializedName("planned_aircraft")
    private final String plannedAircraft;

    @Expose
    @SerializedName("planned_tascruise")
    private final String plannedTrueAirspeedCruise;

    @Expose
    @SerializedName("planned_depairport")
    private final String plannedDepartureAirport;

    @Expose
    @SerializedName("planned_altitude")
    private final String plannedAltitude;

    @Expose
    @SerializedName("planned_destairport")
    private final String plannedDestinationAirport;

    @Expose
    private final String server;

    @Expose
    @SerializedName("protrevision")
    private final String protRevsion;

    @Expose
    private final String rating;

    @Expose
    private final String transponder;

    @Expose
    @SerializedName("facilitytype")
    private final String faciliyType;

    @Expose
    @SerializedName("visualrange")
    private final String visualRange;

    @Expose
    @SerializedName("planned_revision")
    private final String plannedRevision;

    @Expose
    @SerializedName("planned_flighttype")
    private final String plannedFlightType;

    @Expose
    @SerializedName("planned_deptime")
    private final String plannedDepartureTime;

    @Expose
    @SerializedName("planned_actdeptime")
    private final String plannedAtcDepartureTime;

    @Expose
    @SerializedName("planned_hrsenroute")
    private final String plannedHoursEnroute;

    @Expose
    @SerializedName("planned_minenroute")
    private final String plannedMinutesEnroute;

    @Expose
    @SerializedName("planned_hrsfuel")
    private final String plannedHoursFuel;

    @Expose
    @SerializedName("planned_minfuel")
    private final String plannedMinutesFuel;

    @Expose
    @SerializedName("planned_altairport")
    private final String plannedAlternativeAirport;

    @Expose
    @SerializedName("planned_remarks")
    private final String plannedRemarks;

    @Expose
    @SerializedName("planned_route")
    private final String plannedRoute;

    @Expose
    @SerializedName("planned_depairport_lat")
    private final String plannedDepartureAirportLatitude;

    @Expose
    @SerializedName("planned_depairport_lon")
    private final String plannedDepartureAirportLongitude;

    @Expose
    @SerializedName("planned_destairport_lat")
    private final String plannedArrivalAirportLatitude;

    @Expose
    @SerializedName("planned_destairport_lon")
    private final String plannedArrivalAirportLongitude;

    @Expose
    @SerializedName("atis_message")
    private final String atisMessage;

    @Expose
    @SerializedName("time_last_atis_received")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime timeLastAtisReceived;

    @Expose
    @SerializedName("time_logon")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime timeLogon;

    @Expose
    private final String heading;

    @Expose
    @SerializedName("qnh_i_hg")
    private final String qnhInchesMercury;

    @Expose
    @SerializedName("qnh_mb")
    private final String qnhMillibars;
}
