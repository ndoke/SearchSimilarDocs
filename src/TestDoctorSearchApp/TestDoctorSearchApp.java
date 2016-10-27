package TestDoctorSearchApp;

import java.util.ArrayList;

import com.nachiket.DoctorData.Doctor;
import com.nachiket.DoctorSearchApp.FindSimilarDoctors;

public class TestDoctorSearchApp {

	public static void printSimilar(Doctor doc, ArrayList<Doctor> list) {
		System.out.println(doc);
		System.out.println();
		if (list.isEmpty())
			System.out.println("No match found!");
		else {
			for (Doctor tempDoc : list)
				System.out.println(tempDoc);
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		FindSimilarDoctors findSimilarDoctors = new FindSimilarDoctors(args[0]);
		Doctor doc1 = new Doctor("Alex Vincent", "Allergy and immunology", "Jersey City", "New Jersey", "USA",
				(long) 7);
		Doctor doc2 = new Doctor("Haresh Patel", "Cardiothoracic surgery", "Surat", "Gujrat", "India", (long) 4);
		Doctor doc3 = new Doctor("Charles White", "Pathology", "Ottawa", "Ontario", "Canada", (long) 5);
		Doctor doc4 = new Doctor("Yi Hu", "Orthopedic", "Beijing", "Hebei", "China", (long) 2);
		printSimilar(doc1, findSimilarDoctors.findSimilar(doc1));
		printSimilar(doc2, findSimilarDoctors.findSimilar(doc2));
		printSimilar(doc3, findSimilarDoctors.findSimilar(doc3));
		printSimilar(doc4, findSimilarDoctors.findSimilar(doc4));
	}

}
