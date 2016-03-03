package edu.showcase.system.util.gson;

import java.util.List;

/*
{"menu": {
	  "id": "file",
	  "value": "File",
	  "popup": {
	    "menuitem": [
	      {"value": "New", "onclick": "CreateNewDoc()"},
	      {"value": "Open", "onclick": "OpenDoc()"},
	      {"value": "Close", "onclick": "CloseDoc()"}
	    ]
	  }
	}}
*/

public class Menu {

	String id;
	String value;
	List<MenuItem> popup;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<MenuItem> getPopup() {
		return popup;
	}
	public void setPopup(List<MenuItem> popup) {
		this.popup = popup;
	}
}
