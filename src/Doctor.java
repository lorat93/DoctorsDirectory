import java.util.Comparator;


public class Doctor {
	private String name;
	private String specialty;
	private String area;
	private int score;
		
	public Doctor(String name, String specialty, String area, int score) {
		this.name = name;
		this.specialty = specialty;
		this.area = area;
		if(score > 10) {
			this.score = 10;
		}
		else if(score < 0) {
			this.score = 0;
		}
		else {
			this.score = score;
		}
	}
		
	public String getName() {
		return this.name;
	}
	public String getSpecialty() {
		return this.specialty;
	}
	public String getArea() {
		return this.area;
	}
	public int getScore() {
		return this.score;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setSpecialty(String sp) {
		this.specialty = sp;
	}
	public void setArea(String a) {
		this.area = a;
	}
	public void setScore(int sc) {
		if(sc > 10) {
			sc = 10;
		}
		else if(sc < 0) {
			sc = 0;
		}
		else {
			this.score = sc;
		}
	}
	
	public static Comparator<Doctor> DocNameComparator = new Comparator<Doctor>() {
		public int compare(Doctor d1, Doctor d2) {
			String doctorName1 = d1.getName();
			String doctorName2 = d2.getName();
			
			return doctorName1.compareTo(doctorName2);
		}
	};
	public static Comparator<Doctor> DocScoreComparator = new Comparator<Doctor>() {
		public int compare(Doctor d1, Doctor d2) {
			int doctorScore1 = d1.getScore();
			int doctorScore2 = d2.getScore();
			
			return doctorScore2-doctorScore1;
		}
	};
    public String toString() {
        return "[ Name=" + name + ", Specialty=" + specialty + ", area=" + area + ", score=" + score + "]";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
