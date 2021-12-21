package com.sai.shortening.service.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "URL_MAPPING")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class URLMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MAPPING_ID")
	private Long mappingId;
	@Column(name = "SHORT_URL", unique = true)
	private String shortURL;
	@Lob
	@Column(name = "LONG_URL")
	private String longURL;
}
