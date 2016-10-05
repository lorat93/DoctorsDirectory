/*
 * Author : Lora Tam
 * Description: Directory of Doctors
 * Can Filter Search of Doctors by Name, Specialty, Area, and Score
 */

import java.util.ArrayList;
import java.util.Collections;

public class DoctorsDir {
	private ArrayList<Doctor> listOfDocs;
	public DoctorsDir() {
		listOfDocs = new ArrayList<Doctor>();
	}
	public boolean isEmpty() {
		return listOfDocs.size() == 0;
	}
	/*
	 * Shows all Doctors in List
	 */
	public ArrayList<Doctor> showAllDoctors() {
		Collections.sort(listOfDocs,Doctor.DocNameComparator);
		// return list sorted by Name ascending order
		return listOfDocs;
	}
	/*
	 * Returns Filtered Doctors List by Name
	 */
	public ArrayList<Doctor> docByName(String docName) {
		ArrayList<Doctor> res = new ArrayList<Doctor>();
		for(int i = 0; i < listOfDocs.size();i++) {
			// while traversing through list, check if name in list contains user given name
			if(listOfDocs.get(i).getName().contains(docName)) {
				// if true, add to res list
				res.add(listOfDocs.get(i));
			}
		}
		// sort res list by Name ascending order
		Collections.sort(res,Doctor.DocNameComparator);
		return res;
	}
	/*
	 * Returns Filtered Doctors List by Specialty
	 * Assuming User input must be exactly the same as in list
	 */
	public ArrayList<Doctor> docBySpecialty(String docSpecialty) {
		ArrayList<Doctor> res = new ArrayList<Doctor>();
		for(int i = 0; i < listOfDocs.size();i++) {
			// while traversing through list, check if specialty in list is same as user given spec.
			if(listOfDocs.get(i).getSpecialty() == docSpecialty) {
				// add to res list
				res.add(listOfDocs.get(i));
			}
		}
		// sort res list by Name ascending order
		Collections.sort(res,Doctor.DocNameComparator);
		return res;		
	}
	/*
	 * Returns Filtered Doctors List by Area
	 * Assuming User input must be exactly the same as in list
	 */
	public ArrayList<Doctor> docByArea(String docArea) {
		ArrayList<Doctor> res = new ArrayList<Doctor>();
		for(int i = 0 ; i < listOfDocs.size();i++) {
			// while traversing through list, check if area in list is same as use given area
			if(listOfDocs.get(i).getArea() == docArea) {
				// add to res list
				res.add(listOfDocs.get(i));
			}
		}
		// sort by name ascending order
		Collections.sort(res,Doctor.DocNameComparator);
		return res;
	}
	/*
	 * Returns Filtered Doctors List by Score
	 * with range from score-1 to score+1
	 * Assuming score can only be int (whole numbers)
	 * Assuming score is from 0 - 10.
	 */
	public ArrayList<Doctor> docByScore(int docScore) {
		ArrayList<Doctor> res = new ArrayList<Doctor>();
		for(int i = 0; i < listOfDocs.size();i++) {
			int currScore = listOfDocs.get(i).getScore();
			// check if current score is within range of user given score by -1 to +1
			if( currScore == docScore || currScore + 1 == docScore || currScore - 1 == docScore) {
				// add to res
				res.add(listOfDocs.get(i));
			}
		}
		// sort by score in descending order
		Collections.sort(res, Doctor.DocScoreComparator);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorsDir directory = new DoctorsDir();
		// Add random Doctors to List
		directory.listOfDocs.add(new Doctor("John Smith","Pediatrician","SF",21)); // score over 10
		directory.listOfDocs.add(new Doctor("Mary Lam","Optometrist","SD",8));
		directory.listOfDocs.add(new Doctor("Eileen So","PT","NY",7));
		directory.listOfDocs.add(new Doctor("Sam Cole","General","SD",7));
		directory.listOfDocs.add(new Doctor("Samantha T.","Pediatrician","SF",5));
		directory.listOfDocs.add(new Doctor("John Jr.","Optometrist","LA",4));
		directory.listOfDocs.add(new Doctor("Jude Smith","PT","LA",7));
		directory.listOfDocs.add(new Doctor("Jane Doe","General","SF",8));
		directory.listOfDocs.add(new Doctor("Ariel Sea","Pediatrician","LA",9));
		directory.listOfDocs.add(new Doctor("Sharon Chow","General","LA",2));
		directory.listOfDocs.add(new Doctor("John Low","Optometrist","NY",-10)); // score less than 0
		directory.listOfDocs.add(new Doctor("Shannon Pim","General","NY",3));
		directory.listOfDocs.add(new Doctor("Teresa Well","Pediatrician","NY",5));
		directory.listOfDocs.add(new Doctor("James Lead","Surgeon","CA",6));
		
		/* Show All */
		System.out.println("Showing All Doctors:");
		ArrayList<Doctor> all = new ArrayList<Doctor>();
		all = directory.showAllDoctors();
		for(Doctor doc : all) {
			System.out.println(doc);
		}
		
		/* Filter by Name */
		System.out.println("Showing Filter By Names:");
		ArrayList<Doctor> FilteredByName = new ArrayList<Doctor>();
		FilteredByName = directory.docByName("John");
		for(Doctor doc : FilteredByName) {
			System.out.println(doc);
		}
		
		/* Filter by Specialty */
		System.out.println("Showing Filter By Specialty:");
		ArrayList<Doctor> FilteredBySpecialty = new ArrayList<Doctor>();
		FilteredBySpecialty = directory.docBySpecialty("Pediatrician");
		for(Doctor doc : FilteredBySpecialty) {
			System.out.println(doc);
		}
		
		/* Filter by Area */
		System.out.println("Showing Filter By Area:");
		ArrayList<Doctor> FilteredByArea = new ArrayList<Doctor>();
		FilteredByArea = directory.docByArea("SF");
		for(Doctor doc : FilteredByArea) {
			System.out.println(doc);
		}
		
		/* Filter by Score */
		System.out.println("Showing Filter By Score:");
		ArrayList<Doctor> FilteredByScore = new ArrayList<Doctor>();
		FilteredByScore = directory.docByScore(5);
		for(Doctor doc : FilteredByScore) {
			System.out.println(doc);
		}
		
	}

}
