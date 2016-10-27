package com.nachiket.DoctorSearchApp;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.nachiket.DoctorData.Doctor;

public class FindSimilarDoctors {

	public ArrayList<Doctor> docList;
	public ArrayList<Doctor> retList;
	public ArrayList<Doctor> subList;

	public FindSimilarDoctors(String path) {
		// read the doctor list
		String pathname = path;
		JSONParser parser = new JSONParser();
		JSONArray a;
		docList = new ArrayList<Doctor>();

		try {
			a = (JSONArray) parser.parse(new FileReader(pathname));
			for (Object o : a) {
				JSONObject doctor = (JSONObject) o;

				String name = (String) doctor.get("name");
				String specialty = (String) doctor.get("specialty");
				String city = (String) doctor.get("city");
				String state = (String) doctor.get("state");
				String country = (String) doctor.get("country");
				Long reviewScore = (Long) doctor.get("reviewScore");

				Doctor doc = new Doctor(name, specialty, city, state, country, reviewScore);

				// save it in a ArrayList
				docList.add(doc);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Doctor> findSimilar(Doctor doctor) {
		// Take the Doctor input from user
		retList = new ArrayList<Doctor>();
		subList = new ArrayList<Doctor>();

		for (Doctor doc : docList) {
			if (doc.getSpecialty().equals(doctor.getSpecialty())) {
				retList.add(doc);
				continue;
			} else if (doc.getCity().equals(doctor.getCity())) {
				subList.add(doc);
				continue;
			} else if (doc.getState().equals(doctor.getState())) {
				subList.add(doc);
				continue;
			} else if (doc.getCountry().equals(doctor.getCountry())) {
				subList.add(doc);
				continue;
			} else if (doc.getReviewScore() == doctor.getReviewScore()) {
				subList.add(doc);
				continue;
			}
		}

		// Output the similar doctors
		Collections.sort(retList, new DoctorReviewComparator());
		Collections.sort(subList, new DoctorReviewComparator());
		retList.addAll(subList);
		return retList;
	}

	class DoctorReviewComparator implements Comparator<Doctor> {
		@Override
		public int compare(Doctor o1, Doctor o2) {
			return (int) Long.compare(o2.getReviewScore(), o1.getReviewScore());
		}
	}

}
