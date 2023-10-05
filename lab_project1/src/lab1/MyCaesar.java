package lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}
	// Method 1 : // Phương thức để mã hóa một ký tự.
	// ciphertext : bản mã
	// encryptedText : văn bản được mã hóa
	public char encrypt(char c) {
		 // Method to encrypt(mã hóa) a character.
		// Dời ký tự theo số dịch.
		char encryptedChar = (char) (c + n);
		// Quấn lại đầu bảng chữ cái nếu cần thiết.
		if (encryptedChar > 'z') {
			encryptedChar -= 26;
		}
		return encryptedChar;
	
	}
	// Method to encrypt a text.
	public String encrypt(String input) {
	    StringBuilder encryptedText = new StringBuilder();
	    for (char c : input.toCharArray()) {
	        encryptedText.append(encrypt(c));
	    }
	    return encryptedText.toString();
	}
	// Method 2 : // Phương thức để giải mã một ký tự.
	 // Method to decrypt(giải mã) a character.
    public char decrypt(char c) {
    	// Dời ký tự ngược lại theo số dịch.
    	char decryptedChar = (char) (c - n);
        // Wrap around to the end of the alphabet if necessary.
    	//(Quấn lại cuối bảng chữ cái nếu cần thiết).
        if (decryptedChar < 'a') {
            decryptedChar += 26;
        }
        return decryptedChar;
    }
    // Method to decrypt a text.
    public String decrypt(String input) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            decryptedText.append(decrypt(c));
        }
        return decryptedText.toString();
    }

	public static void main(String[] args) {
		// method 1 :
		// Create a MyCaesar object with a shift of 3.
        MyCaesar caesar = new MyCaesar(3);
        // Encrypt the text "hello".
        String encryptedText = caesar.encrypt("hello");
        // Print the encrypted text.
        System.out.println("Encrypted text: " + encryptedText);
        
        // method 2 :
        // Decrypt the decrypted text.
        String decryptedText = caesar.decrypt(encryptedText);
        // Print the decrypted text.
        System.out.println("Decrypted text: " + decryptedText);
	}
}
