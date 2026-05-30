package de.tha.prog2.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffManagement {
	public HashMap<Integer, Employee> data = new HashMap<Integer, Employee>();
	
	public void addEmployee(Employee e) {
		if (data.containsKey(e.getEmployeeID())) {
			throw new DuplicateEmployeeException();
		}
		data.put(e.getEmployeeID(), e);
	}
	
	public List<Employee> getEmployeesSortedByName(){
		List<Employee> result = new ArrayList<>(data.values());
		
		result.sort(Comparator.comparing(e -> e.getName()));
		
		return result;
	}
	
	public List<Employee> getEmployeesSortedByYearsEmployed(){
		List<Employee> result = new ArrayList<>(data.values());
		
		result.sort(Comparator.comparingDouble(e -> ((Employee) e).getYearsEmployed()).reversed());
		return result;
	}
	
	public List<Employee> getEmployeesFromDepartment(String department){
		List<Employee> result = new ArrayList<>(data.values());
		
		List<Employee> filteredList = result.stream().filter(e -> e.getDepartment() == department).toList();
		return filteredList;
	}
	
	public Map<String, Employee> getLongestEmployedEmployeePerDepartement(){
		List<Employee> result = new ArrayList<>(data.values());
		HashMap<String, Employee> data = new HashMap<String, Employee>();
		
		for (Employee e : result) 
		{
			if (!data.containsKey(e.getDepartment())) {
				data.put(e.getDepartment(), e);
			}
			else {
				if (e.getYearsEmployed() > data.get(e.getDepartment()).getYearsEmployed()) {
					data.put(e.getDepartment(), e);
				}
			}
		}
		return data;
	}
}
