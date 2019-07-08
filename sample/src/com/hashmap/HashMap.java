package com.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
	int SIZE_OF_TABLE = 10;
	List<List<HashEntry>> table;
	
	public HashMap() {
		table = new ArrayList<List<HashEntry>>();
		for(int i = 0; i < SIZE_OF_TABLE; i++) {
			table.add(i, null);
		}
	}
	
	public void put(int key, String value) {
		HashEntry newRecord = new HashEntry(key, value);
		int bucket = hashCode(key);
		if(table.get(bucket) == null) {
			List<HashEntry> list = new ArrayList<HashEntry>();
			list.add(newRecord); 
			table.set(bucket, list);
		} else {
			List<HashEntry> oldList = table.get(bucket);
			int count = 0;
			for(int i = 0; i < oldList.size(); i++) {
				if(oldList.get(i).getKey() == key) {
					oldList.get(i).setValue(value);
					break;
				}
				count = i + 1;
			}
			if(count == oldList.size()) {
				oldList.add(newRecord);
			}
		}
	}
	
	public String get(int key) {
		int bucket = hashCode(key);
		if(table.get(bucket) == null) {
			return null;
		} else {
			List<HashEntry> oldList = table.get(bucket);
			for(int i = 0; i < oldList.size(); i++) {
				if(oldList.get(i).getKey() == key) {
					return oldList.get(i).getValue();
				}
			}
		}
		return null;
	}
	
	public int hashCode(int key) {
		return (key & Integer.MAX_VALUE) % this.SIZE_OF_TABLE;
	}
	
	public static void main(String args[]) {
		HashMap hashMap = new HashMap();
	    hashMap.put(1, "suresh");
	    hashMap.put(2, "babu");
	    hashMap.put(2, "vijay");
	    hashMap.put(3, "ravi");
	    hashMap.put(11, "suresh1");
	    System.out.println("value: "+hashMap.get(2));
	}
}
