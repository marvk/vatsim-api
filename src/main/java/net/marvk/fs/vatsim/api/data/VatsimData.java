package net.marvk.fs.vatsim.api.data;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class VatsimData {

    private final VatsimGeneral general;

    private final List<VatsimPilot> pilots;

    private final List<VatsimController> controllers;

    private final List<VatsimAtis> atis;

    @Setter(AccessLevel.PACKAGE)
    private transient List<VatsimClient> clients;

    private final List<VatsimServer> servers;

    private final List<VatsimPrefile> prefiles;

    private final List<VatsimFacility> facilities;

    @SerializedName("ratings")
    private final List<VatsimControllerRating> controllerRatings;

    @SerializedName("pilot_ratings")
    private final List<VatsimPilotRating> pilotRatings;

    public List<VatsimClient> getClients() {
        if (clients == null) {
            clients = Stream
                    .of(pilots, controllers, atis)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }

        return clients;
    }
}
