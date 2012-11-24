package es.uc3m.ctw.me_gustauto.controller;


public class AutoAdBean {
	
	private int ad_id; // delete later
	private String title = "";
	private String brand = "";
	private String model = "";
	private String engine = "";
	private String registration_number = "";
	private String years = "";
	private double price;
	private int mileage;
	private String colour = "";
	private String description = "";
	private String auto_moto = "";
	private String add_date = "";
	private String valid_to = null;

	public void fillWithData() { // this will be deleted
		this.setAd_id(1);
		this.setAdd_date("23-10-2013");
		this.setAuto_moto("auto");
		this.setBrand("Toyota");
		this.setColour("Bloody Red");
		this.setDescription("Description description description description description. " +
							"Description description description.");
		this.setEngine("diesel");
		this.setMileage(100000);
		this.setModel("Corolla");
		this.setPrice(5000);
		this.setRegistration_number("123-1234");
		this.setTitle("A beautiful red toyota corolla for sale");
		this.setValid_to("24-10-2014");
		this.setYears("1998");
	}

	public void reset() {
		this.setAdd_date("");
		this.setAuto_moto("");
		this.setBrand("");
		this.setColour("");
		this.setDescription("");
		this.setEngine("");
		this.setMileage(0);
		this.setModel("");
		this.setPrice(0);
		this.setRegistration_number("");
		this.setTitle("");
		this.setValid_to("");
		this.setYears("");
	}

	public int getAd_id() {
		return ad_id;
	}

	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuto_moto() {
		return auto_moto;
	}

	public void setAuto_moto(String auto_moto) {
		this.auto_moto = auto_moto;
	}

	public String getAdd_date() {
		return add_date;
	}

	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}

	public String getValid_to() {
		return valid_to;
	}

	public void setValid_to(String valid_to) {
		this.valid_to = valid_to;
	}
}
