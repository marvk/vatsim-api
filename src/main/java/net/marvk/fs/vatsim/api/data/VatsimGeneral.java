package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import net.marvk.fs.vatsim.api.deserialization.ZonedDateTimeDeserializer;

import java.time.ZonedDateTime;

@Data
public class VatsimGeneral {
    @Expose
    private final int version;

    @Expose
    private final int reload;

    @Expose
    @SerializedName("update_timestamp")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime update;

    @Expose
    @SerializedName("connected_clients")
    private final int connectedClients;

    @Expose
    private final int uniqueUsers;
}
