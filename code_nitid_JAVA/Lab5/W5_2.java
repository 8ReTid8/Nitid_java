import java.util.ArrayList;
import java.util.Scanner;

public class W5_2{

	static void removeStar(ArrayList<String> list) {
		for(int i = 1;i < list.size(); i++) {
			if (list.get(i)=="*") {
				list.remove(i);
			}
		}
	}

	static void addStar(ArrayList<String> list) {
		int size = list.size()*2;
		for(int i = 1;i < size; i+=2) {
			list.add(i,"*");
		}
	}
	
	public static String toString(ArrayList<String> list) {
		String array = "";
		for (String value: list) {
			array += value + " ";
		}
		return array;
	}

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String choice = scanner.next();
			if (choice.equals("0")) {
				break;
			}
			if (choice.equals("1")) {
				addStar(alist);
				System.out.println(toString(alist));
			} else if (choice.equals("2")) {
				removeStar(alist);
				System.out.println(toString(alist));
			} else {
				alist.add(choice);
			}
		}
	}
}