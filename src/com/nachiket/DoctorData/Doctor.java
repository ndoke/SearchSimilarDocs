package com.nachiket.DoctorData;

public class Doctor {
	String name, specialty, city, state, country;
	Long reviewScore;

	public Doctor(String name, String specialty, String city, String state, String country, Long reviewScore) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.city = city;
		this.state = state;
		this.country = country;
		this.reviewScore = reviewScore;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(Long reviewScore) {
		this.reviewScore = reviewScore;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", specialty=" + specialty + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", reviewScore=" + reviewScore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (int) (reviewScore ^ (reviewScore >>> 32));
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (reviewScore != other.reviewScore)
			return false;
		if (specialty == null) {
			if (other.specialty != null)
				return false;
		} else if (!specialty.equals(other.specialty))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
