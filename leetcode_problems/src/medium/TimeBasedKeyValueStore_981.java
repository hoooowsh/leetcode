package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeBasedKeyValueStore_981 {

}

class TimeMap {

    public HashMap<String, ArrayList<DataNode>> hash;

    public TimeMap() {
        hash = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        DataNode node = new DataNode(timestamp, value);
        if (hash.containsKey(key)) {
            hash.get(key).add(node);
        } else {
            ArrayList<DataNode> list = new ArrayList<>();
            list.add(node);
            hash.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        String result = "";
        if (!hash.containsKey(key)) {
            return result;
        }
        ArrayList<DataNode> list = hash.get(key);
        if (timestamp < list.get(0).timestamp) {
            return result;
        }
        if (list.size() == 1) {
            return list.get(0).value;
        }
        int left = 0;
        int right = list.size() - 1;
        int index = 0;
        while (left <= right) {
            index = left + (right - left) / 2;
            int timestamp_cur = list.get(index).timestamp;
            if (timestamp_cur == timestamp) {
                result = list.get(index).value;
                break;
            } else if (timestamp_cur < timestamp) {
                left = index + 1;
                continue;
            } else {
                right = index - 1;
                continue;
            }
        }
        if (result != "") {
            return result;
        } else {
            if (list.get(index).timestamp > timestamp) {
                index = index - 1;
            }
            return list.get(index).value;
        }
    }

    class DataNode {
        int timestamp;
        String value;

        public DataNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}