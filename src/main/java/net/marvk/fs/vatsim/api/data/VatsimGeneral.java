package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import net.marvk.fs.vatsim.api.deserialization.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Data
public class VatsimGeneral {
    @Expose
    private final int version;
    @Expose
    private final int reload;
    @Expose
    @SerializedName("update_timestamp")
    @JsonAdapter(LocalDateTimeDeserializer.class)
    private final LocalDateTime update;
    @Expose
    @SerializedName("connected_clients")
    private final int connectedClients;
    @Expose
    private final int uniqueUsers;
}
