package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SecondaryTable(name = "airline_history")
public class Airline {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, updatable = false, unique = true)
	private String code;

	@Column(nullable = false)
	private String name;

	@Column(table = "airline_history", length = 2000)
	private String history;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

    public Airline() {
    }

    public Airline(int id, String code, String name, String history) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.history = history;
    }


}
