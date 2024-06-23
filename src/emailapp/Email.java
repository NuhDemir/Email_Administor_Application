package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName; // Kullanıcının adı
	private String lastName; // Kullanıcının soyadı
	private String password; // Kullanıcının şifresi
	private int defaultPasswordLength = 10; // Varsayılan şifre uzunluğu
	private String department; // Kullanıcının departmanı
	private String email; // Kullanıcının e-posta adresi
	private int mailboxCapacity = 500; // Posta kutusu kapasitesi (MB)
	private String alternateEmail; // Alternatif e-posta adresi
	private String companySuffixString = "decodercompany.com"; // Şirketin e-posta uzantısı

	// İlk isim ve soy isim alan constructor
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Adı : " + this.firstName + "\nSoyadı : " + this.lastName);

		// Departman seçimi için metodu çağır - departmanı döner
		this.department = setDepartment();
		//System.out.println("Department : " + this.department);
		
		// Rastgele şifre dönen metodu çağır
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Elemanları birleştirerek e-posta adresini oluştur
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffixString ;
		System.out.println("Your email is : " + email);
	}

	// Departman seçimi için kullanıcıdan giriş alma
	private String setDepartment() {
		System.out.println(
				"Departman Kodları: \n1 için Satış\n2 için Geliştirme\n3 için Muhasebe\n0 Girmek İçin Departman Kodu :  ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if (departmentChoice == 1) {
			return "Sales";
		} else if (departmentChoice == 2) {
			return "dev";
		} else if (departmentChoice == 3) {
			return "acct";
		} else {
			return ""; // Geçersiz seçimler için boş değer döndür
		}
	}

	// Rastgele bir şifre oluşturma
	private String randomPassword(int length) {
		String passwordSet = "AaBbCcDdEeFfGgHhIıİiJjKkLlMmNnOoÖöPpRtSsŞşTtUuÜüVvYyZz0123456789?*-_.!€&^'";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Posta kutusu kapasitesini ayarlama
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Alternatif e-posta adresi ayarlama
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Şifre değiştirme
	public void changePassword(String password) {
		this.password = password;
	}

	// Posta kutusu kapasitesini döndürme
	public int getMailboxCapacity() { 
		return mailboxCapacity;
	}

	// Alternatif e-posta adresini döndürme
	public String getAlternateEmail() { 
		return alternateEmail;
	}

	// Şifreyi döndürme
	public String getPassword() { 
		return password;
	}

	// Kullanıcı bilgilerini gösterme
	public String showInfo() {
		return 	"Görünen Ad: " + firstName + " " + lastName + " " + 	
				"Şirket E-postası: " + email + " " +
				"Posta Kutusu Kapasitesi: " + mailboxCapacity + "mb";
	}
}
