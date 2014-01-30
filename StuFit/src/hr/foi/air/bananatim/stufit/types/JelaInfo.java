package hr.foi.air.bananatim.stufit.types;

public class JelaInfo {

	private String vrsta;
	private String naziv;
	private double proteini;
	private double masti;
	private double bjelancevine;
	private double kalorije;
	private double kolicina;

	/*
	 * Konstruktor za jelo. Jelo ima vrstu, naziv, proteini(g), masti(g), bjelancevine(g), kalorije i kolièinu.
	 */
	public JelaInfo(String vrsta, String naziv, double proteini, double masti,
			double bjelancevine, double kalorije, double kolicina) {
		this.vrsta = vrsta;
		this.naziv = naziv;
		this.proteini = proteini;
		this.masti = masti;
		this.bjelancevine = bjelancevine;
		this.kalorije = kalorije;
		this.kolicina = kolicina;

	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getProteini() {
		return proteini;
	}

	public void setProteini(double proteini) {
		this.proteini = proteini;
	}

	public double getMasti() {
		return masti;
	}

	public void setMasti(double masti) {
		this.masti = masti;
	}

	public double getBjelancevine() {
		return bjelancevine;
	}

	public void setBjelancevine(double bjelancevine) {
		this.bjelancevine = bjelancevine;
	}

	public double getKalorije() {
		return kalorije;
	}

	public void setKalorije(double kalorije) {
		this.kalorije = kalorije;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

}
