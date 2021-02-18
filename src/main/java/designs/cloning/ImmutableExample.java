package designs.cloning;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableExample {
    private final String dataMember;
    private final Map<String, String> map;


    public ImmutableExample(String dataMember, Map<String, String> map) {
        this.dataMember = dataMember;
        this.map = new HashMap<>();
        for (String eachKey : map.keySet()) {
            this.map.put(eachKey, map.get(eachKey));
        }
    }

    public String getDataMember() {
        return dataMember;
    }

    public Map<String, String> getMap() {
        Map<String, String> copyOfMap = new HashMap<>();
        for (String eachKey : map.keySet()) {
            copyOfMap.put(eachKey, map.get(eachKey));
        }
        return copyOfMap;
    }
}
