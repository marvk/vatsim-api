package net.marvk.fs.vatsim.api.data;

import lombok.Data;

import java.util.Iterator;
import java.util.List;

@Data
public class Line implements Iterable<Point> {
    private final List<Point> points;

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
