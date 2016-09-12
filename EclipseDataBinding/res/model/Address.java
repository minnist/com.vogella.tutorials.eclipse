
package de.vogella.databinding.example.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Address {
	
	public static final String FIELD_STREET = "street";
	public static final String FIELD_NUMBER = "number";
	public static final String FIELD_POSTALCODE = "postalCode";
	public static final String FIELD_CITY = "city";
	public static final String FIELD_COUNTRY = "country";

	private String street;
	private String number;
	private String postalCode;
	private String city;
	private String country;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public Address() {
	}

	public Address(String postalCode, String city, String country) {
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		propertyChangeSupport.firePropertyChange(FIELD_STREET, this.street,
				this.street = street);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		propertyChangeSupport.firePropertyChange(FIELD_NUMBER, this.number,
				this.number = number);
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		propertyChangeSupport.firePropertyChange(FIELD_POSTALCODE, this.postalCode,
				this.postalCode = postalCode);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		propertyChangeSupport.firePropertyChange(FIELD_CITY, this.city,
				this.city = city);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		propertyChangeSupport.firePropertyChange(FIELD_COUNTRY, this.country,
				this.country = country);
	}

	public String toString() {
		String s = "";
		s += street != null ? street + " " : "";
		s += number != null ? number + " " : "";
		s += postalCode != null ? postalCode + " " : "";
		s += city != null ? city + " " : "";
		s += country != null ? country + " " : "";

		return s;
	}

}
