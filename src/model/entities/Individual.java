package model.entities;

public class Individual extends TaxPayer{
	private Double healthExpentitures;

	
	public Individual() {
		super();
	}
	
	public Individual(String name, double anualIncome, Double healthExpentitures) {
		super(name, anualIncome);
		this.healthExpentitures = healthExpentitures;
	}

	public Double getHealthExpentitures() {
		return healthExpentitures;
	}

	public void setHealthExpentitures(Double healthExpentitures) {
		this.healthExpentitures = healthExpentitures;
	}

	@Override
	public double tax() {
		double basicTax;
		if (getAnualIncome() < 20000.0) {
			basicTax = getAnualIncome() * 0.15;
		}
		else {
			basicTax = getAnualIncome() * 0.25;
		}
		basicTax = basicTax - (getHealthExpentitures()*0.5);
		if(basicTax < 0.0) {
			basicTax= 0.0;
		}
		return basicTax;
	}
}