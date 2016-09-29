package solutions;

public class Offsets {

	public static void main(String[] args) {

		String chain = "14839";
		System.out.println(new Offsets().offsets(chain));

	}

	int offsets(String chain) {

		int result = 0;
		int offset = Integer.parseInt(chain.charAt(0) + "");
		result += offset;

		for (int i = chain.length() - 1; i > 1; i--) {
			result += Integer.parseInt(chain.charAt(i) + "") - Integer.parseInt(chain.charAt(i - 1) + "");
		}

		return result;

	}

}
