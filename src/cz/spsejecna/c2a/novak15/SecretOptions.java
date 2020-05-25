package cz.spsejecna.c2a.novak15;

public class SecretOptions {

	// pridavat sem
	boolean secretShop;

	public SecretOptions(boolean secretShop) {
		this.secretShop = secretShop;
	}

	public boolean isSecretShop() {
		return secretShop;
	}

	public void setSecretShop(boolean secretShop) {
		this.secretShop = secretShop;
	}

	@Override
	public String toString() {
		return "SecretOptions [ secretShop: " + secretShop + " ]";
	}

}
