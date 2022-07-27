package com.gocahum.store.customer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tbl_customers")
@Data
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "El número de documento no puede ser valido")
	@Size(min = 8, max = 8, message = "El tamaño del número de documento es 8")
	@Column(name = "number_id", unique = true, length = 8, nullable = false)
	private String numberID;
	
	@NotEmpty(message = "El nombre no  puede ser nulo")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty(message = "El apellido no puede ser vacío")
	@Column(name ="last_name", nullable = false)
	private String lastName;
	
	@NotEmpty(message = "El correo no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formado")
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name ="photo_url")
	private String photoUrl;
	
	@NotNull(message = "La región no puede ser vacía")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;
	
	private String state;
	

}
