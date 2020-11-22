package net.marvk.fs.vatsim.api.data;

import lombok.Data;

@Data
public class Point {
    private final Double longitude;
    private final Double latitude;

    public Double getX() {
        return longitude;
    }

    public Double getY() {
        return latitude;
    }
}
