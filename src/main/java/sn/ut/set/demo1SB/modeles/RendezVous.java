package sn.ut.set.demo1SB.modeles;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RendezVous implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String codeRV;
	private String description;
	private String lieu;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RendezVous(String codeRV, String description, String lieu, LocalDate date) {
		super();
		this.codeRV = codeRV;
		this.description = description;
		this.lieu = lieu;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeRV() {
		return codeRV;
	}
	public void setCodeRV(String codeRV) {
		this.codeRV = codeRV;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
