package com.niit.e_commercebackend.dao;

import java.util.ArrayList;

import com.niit.e_commercebackend.models.Supplier;


public interface SupplierDao {

	void saveSupplier(Supplier s);
	public ArrayList<Supplier> getallSupplier();
	public Supplier getssbyid(int id);
	public void deletesupplier(int id);
	public void updatesupplier(Supplier id);
}
