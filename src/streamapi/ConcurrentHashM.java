package streamapi;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashM {
public static void main(String[] args) {
	ConcurrentHashMap<Integer, Integer> map=new ConcurrentHashMap<>();
	for (int i = 0; i < 16; i++) {
		map.put(i, 10);
	}
}
}
