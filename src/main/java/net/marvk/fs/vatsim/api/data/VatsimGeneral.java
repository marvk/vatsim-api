package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class VatsimGeneral {

    private final int version;

    private final int reload;

    @SerializedName("update_timestamp")
    @JsonAdapter(ZonedDateTimeDeserializer.class)
    private final ZonedDateTime update;

    @SerializedName("connected_clients")
    private final int connectedClients;

    private final int uniqueUsers;
}
