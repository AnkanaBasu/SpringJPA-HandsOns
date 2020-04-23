package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	@Transactional
	public void addCountry(Country country)
	{
		countryRepository.save(country);
	}
	@Transactional
	public void UpdateByCode(String code,String name) throws CountryNotFoundException
	{
		Optional<Country> result = countryRepository.findById(code);
		if (!result.isPresent())
		{
			throw new CountryNotFoundException("Country Not Present");
		}
		Country country= new Country();
		country.setCode(code);
		country.setName(name);
		countryRepository.save(country);
	}
	@Transactional
	public void DeleteByCode(String Code)
	{
		countryRepository.deleteById(Code);
	}
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException
		{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
		{
			throw new CountryNotFoundException("Country Not Present");
		}
		Country country = result.get();
		return country;
		}
	@Transactional
	public List<Country> getAllCountries() {
		List<Country> findAll = new ArrayList<Country>();
		findAll = countryRepository.findAll();
		return findAll;
	}
}
