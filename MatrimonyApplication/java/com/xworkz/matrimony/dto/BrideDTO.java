package com.xworkz.matrimony.dto;

public class BrideDTO {
	private int id;
	private String name;
	private int age;
	private double height;
	private double weight;
	private String qualification;
	private String expectation;
	private String phone_number;
	private double salary;
	private String occupation;
	private String address;

	public BrideDTO() {
		super();
	}
	

	@Override
	public String toString() {
		return "Bride [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", qualification=" + qualification + ", expectation=" + expectation + ", phone_number=" + phone_number
				+ ", salary=" + salary + ", occupation=" + occupation + ", address=" + address + "]";
	}


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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String string) {
		this.phone_number = string;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
