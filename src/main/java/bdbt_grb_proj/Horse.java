package bdbt_grb_proj;

public class Horse {
	
	/* Fields */
	private int id;
	private String name;
	private String sex;
	private String dateOfBirth;
	private String maleLineage;
	private String femaleLineage;
	private String intendedUse;
	private String countryOfOrigin;
	private String dimensionOne;
	private String dimensionTwo;
	private String dimensionThree;
	private String additionalInfo;
	private int studFarmId;
	private int equineCoatColorId;
	private int breedId;
	
	
	/* Default constructor */
	public Horse() {
	}
	
	/* Constructor */
	public Horse(int id, String name, String sex, String dateOfBirth, String maleLineage, String femaleLineage,
			String intendedUse, String countryOfOrigin, String dimensionOne, String dimensionTwo, String dimensionThree,
			String additionalInfo, int studFarmId, int equineCoatColorId, int breedId) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.maleLineage = maleLineage;
		this.femaleLineage = femaleLineage;
		this.intendedUse = intendedUse;
		this.countryOfOrigin = countryOfOrigin;
		this.dimensionOne = dimensionOne;
		this.dimensionTwo = dimensionTwo;
		this.dimensionThree = dimensionThree;
		this.additionalInfo = additionalInfo;
		this.studFarmId = studFarmId;
		this.equineCoatColorId = equineCoatColorId;
		this.breedId = breedId;
	}

	
	/* Getters and setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaleLineage() {
		return maleLineage;
	}

	public void setMaleLineage(String maleLineage) {
		this.maleLineage = maleLineage;
	}

	public String getFemaleLineage() {
		return femaleLineage;
	}

	public void setFemaleLineage(String femaleLineage) {
		this.femaleLineage = femaleLineage;
	}

	public String getIntendedUse() {
		return intendedUse;
	}

	public void setIntendedUse(String intendedUse) {
		this.intendedUse = intendedUse;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getDimensionOne() {
		return dimensionOne;
	}

	public void setDimensionOne(String dimensionOne) {
		this.dimensionOne = dimensionOne;
	}

	public String getDimensionTwo() {
		return dimensionTwo;
	}

	public void setDimensionTwo(String dimensionTwo) {
		this.dimensionTwo = dimensionTwo;
	}

	public String getDimensionThree() {
		return dimensionThree;
	}

	public void setDimensionThree(String dimensionThree) {
		this.dimensionThree = dimensionThree;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public int getStudFarmId() {
		return studFarmId;
	}

	public void setStudFarmId(int studFarmId) {
		this.studFarmId = studFarmId;
	}

	public int getEquineCoatColorId() {
		return equineCoatColorId;
	}

	public void setEquineCoatColorId(int equineCoatColorId) {
		this.equineCoatColorId = equineCoatColorId;
	}

	public int getBreedId() {
		return breedId;
	}

	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}
	
	
	/* toString() */
	@Override
	public String toString() {
		return "Horse [id=" + id + ", name=" + name + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", maleLineage="
				+ maleLineage + ", femaleLineage=" + femaleLineage + ", intendedUse=" + intendedUse
				+ ", countryOfOrigin=" + countryOfOrigin + ", dimensionOne=" + dimensionOne + ", dimensionTwo="
				+ dimensionTwo + ", dimensionThree=" + dimensionThree + ", additionalInfo=" + additionalInfo
				+ ", studFarmId=" + studFarmId + ", equineCoatColorId=" + equineCoatColorId + ", breedId=" + breedId
				+ "]";
	}
	
	
}
