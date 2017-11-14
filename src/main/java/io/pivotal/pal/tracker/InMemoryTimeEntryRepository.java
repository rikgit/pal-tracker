package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by e037075 on 11/14/17.
 */
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private AtomicLong timeEntryCounter = new AtomicLong(0);

    private Map<Long,TimeEntry> inMemoryMap = new HashMap<>();


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = timeEntryCounter.incrementAndGet();
        timeEntry.setId(id);
        inMemoryMap.put(id,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return inMemoryMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntries = new ArrayList<>(inMemoryMap.values());
        return timeEntries;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        inMemoryMap.replace(id,timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        inMemoryMap.remove(id);
    }
}
