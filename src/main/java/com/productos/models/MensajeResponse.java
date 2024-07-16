package com.productos.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MensajeResponse  implements Serializable {

	public MensajeResponse() {
		
	}
	
    public MensajeResponse(String mnesaje, Object object) {
		this.mnesaje = mnesaje;
		this.object = object;
	}
	private String mnesaje;
    private Object object;
    
	public String getMnesaje() {
		return mnesaje;
	}
	public void setMnesaje(String mnesaje) {
		this.mnesaje = mnesaje;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
    
    

}

