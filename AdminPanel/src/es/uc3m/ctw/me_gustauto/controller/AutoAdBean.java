package es.uc3m.ctw.me_gustauto.controller;




//@Stateless
//@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class AutoAdBean {
	//Only needed to get the user_id
	private String username = "";
	
	//Saved to db
	private int ad_id;
	private String title = "";
	private String brand = "";
	private String model = "";
	private String engine = "";
	private String registration_number = "";
	private String years = "";
	private String price = "";
	private String mileage = "";
	private String colour = "";
	private String description = "";
	private int user_id;
	private String auto_moto = "";
	private String add_date = "";
	private String valid_to = "";	
	
//	@PersistenceUnit
//	private EntityManagerFactory emf;
//	
//    @Resource
//    private UserTransaction utx;
	
    /*
     * temporary, just to see if the jsp works 
     */
    public void fillWithData(){
    	this.setAd_id(42);
		this.setAdd_date("23-10-2013");
		this.setAuto_moto("auto");
		this.setBrand("Toyota");
		this.setColour("Bloody Red");
		this.setDescription("An awesome car. A smart choice. A great deal. Just buy it. " +
				"You will not regret it. It's definitely worth it." +
				"I recommend it to you. It will not disappoint you.");
		this.setEngine("diesel");
		this.setMileage("100000");
		this.setModel("Corolla");
		this.setPrice("5000");
		this.setRegistration_number("123-1234");
		this.setTitle("A beautiful red toyota corolla for sale");
		this.setUser_id(0);
		this.setUsername("Username123");
		this.setValid_to("24-10-2014");
		this.setYears("1998");		
	}
    
    public void reset(){
		this.setAdd_date("");
		this.setAuto_moto("");
		this.setBrand("");
		this.setColour("");
		this.setDescription("");
		this.setEngine("");
		this.setMileage("");
		this.setModel("");
		this.setPrice("");
		this.setRegistration_number("");
		this.setTitle("");
		this.setUser_id(0);
		this.setUsername("");
		this.setValid_to("");
		this.setYears("");		
	}
    
	public boolean storeAutoAd(){		
		//check if data is filled
		if(title.length()==0||brand.length()==0||model.length()==0||engine.length()==0||
				registration_number.length()==0||years.length()==0||price.length()==0||mileage.length()==0||
				colour.length()==0||description.length()==0||username.length()==0||auto_moto.length()==0||
				add_date.length()==0||valid_to.length()==0){
			System.out.println("Could not store auto ad becase of empty fields"); //TO DO more details
			System.out.println("auto_moto = " + auto_moto);
			System.out.println("add_date = " + add_date);
			System.out.println("description = " + description);
			System.out.println("username = " + username);
			System.out.println("user_id before query  = " + user_id);
			return false;
		}
		
//		******OLD QUERY FOR NO JPA******
//		String query = "INSERT INTO auto_ads (title,brand,model,engine,registration_number,years,price,mileage,colour,description,user_id,auto_moto) VALUES ('" + 
//		title + "','" + brand + "','" + model + "','" + engine + "','" + registration_number + "','" + years + "','" +
//		price + "','" + mileage + "','" + colour + "','" + description + "','" + user_id + "','" + 
//		auto_moto/* + "','" + add_date/*mysql_date_format.format(add_date) + "','" + valid_to/*mysql_date_format.format(valid_to)*/+"');";
		
//		MySQLConnector.execute(query);
/*
		System.out.println("BEFORE CREATING entitymanager");
		
		if(emf == null){
			 emf = Persistence.createEntityManagerFactory("PU");
		}
		EntityManager em = emf.createEntityManager();
		
		System.out.println("AFTER CREATING entitymanager username = " + username);
		*/
		// Retrieve user_id knowing username
		/*
		String query = "SELECT u FROM User u WHERE u.username = ?1";		
		user_id = ((model.User)em.createQuery(query).setParameter(1, username).getSingleResult()).getUserId();
		System.out.println("AFTER QUERYing for userid = " + user_id);
		
		model.AutoAd newautoad = new model.AutoAd();
		newautoad.setAddDate(Date.valueOf(add_date));
		newautoad.setValidTo(Date.valueOf(valid_to));
		newautoad.setAutoMoto(auto_moto);
		newautoad.setBrand(brand);
		newautoad.setColour(colour);
		newautoad.setDescription(description);
		newautoad.setEngine(engine);
		newautoad.setMileage(Integer.parseInt(mileage));
		newautoad.setModel(model);
		newautoad.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
		newautoad.setRegistrationNumber(registration_number);
		newautoad.setTitle(title);
		newautoad.setUser(em.find(model.User.class, user_id));
		newautoad.setYears(years);

		try {
			utx.begin();
		} catch (Exception ex) {} 
		System.out.println("Before persisting newautoad");
		em.persist(newautoad); 
		System.out.println("After persisting newautoad"); 
		try { 
			utx.commit(); 
		} catch (Exception ex) {} 


		em.close();
		*/
		
		return true;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAuto_moto() {
		return auto_moto;
	}
	public void setAuto_moto(String auto_moto) {
		this.auto_moto = auto_moto;
	}
	

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
