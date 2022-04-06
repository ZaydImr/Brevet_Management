package com.ismo.brevets.models;

public class KeyValue {
	
	private String key;
	private long value;
	
	public KeyValue (){
		
	}
	
	public KeyValue (String key, long value ) {
		this.key = key;
		this.value = value;
	}
	
	
	/*		Getters/setters		*/

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyValue [key=" + key + ", value=" + value + "]";
	}

}
