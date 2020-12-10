package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true, exclude = {"serverId"})
public abstract class VatsimClient extends VatsimClientBase {
    public VatsimClient(final String cid, final String name, final String callsign, final ZonedDateTime lastUpdate, final String serverId, final VatsimServer server, final ZonedDateTime logon) {
        super(cid, name, callsign, lastUpdate);
        this.serverId = serverId;
        this.server = server;
        this.logon = logon;
    }

    @Getter(AccessLevel.PACKAGE)
    @SerializedName("server")
    private final String serverId;

    @Setter(AccessLevel.PACKAGE)
    private transient VatsimServer server;

    @SerializedName("logon_time")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime logon;

    public abstract VatsimClientType getClientType();
}
