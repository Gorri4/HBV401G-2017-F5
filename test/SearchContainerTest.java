package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;


import org.junit.*;

import control.*;
import model.*;

public class SearchContainerTest {
	
	private SearchContainer container;
	private SearchDbManagerInterface Mock;
	private City borg1;
	private City borg2;
	private Date dags1;
	
	@Before 
	public void setUp() {
		this.Mock = new MockSearchDbManager();
		this.container = new SearchContainer(Mock);
		this.borg1 = new City("Berlin", 0);
		this.borg2 = new City("Paris", 0);
		this.dags1 = new Date(1497803417);
		this.container.search(1,dags1,borg1,borg2,1);
	}
	
	@After
	public void tearDown() {
		this.container = null;
		this.Mock = null;
		this.borg1 = null;
		this.borg2 = null;
		this.dags1 = null;
	}
	
	@Test
	public void SortTest1() {
		ArrayList<Flight> fyrstiListi = container.getList();
		ArrayList<Flight> priceSortedList = container.sort(fyrstiListi, "lala", false);
		assertNotNull(priceSortedList);
		double currPrice = 0;
		double prevPrice = 0;
		for (Flight flug : priceSortedList) {
			currPrice = flug.getPrice();
			assertTrue(currPrice >= prevPrice);
			prevPrice = currPrice;
		}
	}
	
	@Test
	public void SortTest2() {
		ArrayList<Flight> fyrstiListi = container.getList();
		ArrayList<Flight> reversePriceSortedList = container.sort(fyrstiListi, "", true);
		assertNotNull(reversePriceSortedList);
		double currPrice = 10000000;
		double prevPrice = 10000000;
		for (Flight flug : reversePriceSortedList) {
			currPrice = flug.getPrice();
			assertTrue(currPrice <= prevPrice);
			prevPrice = currPrice;
		}
	}
	
	@Test
	public void SortTest3() {
		ArrayList<Flight> tomurListi = new ArrayList<Flight>();
		ArrayList<Flight> emptySortedList = container.sort(tomurListi, "date", false);
		assertNotNull(emptySortedList);
		assertTrue(emptySortedList.isEmpty());
	}
	
	@Test
	public void SortTest4() {
		ArrayList<Flight> fyrstiListi = container.getList();
		ArrayList<Flight> DateSortedList = container.sort(fyrstiListi, "date", false);
		assertNotNull(DateSortedList);
		Date currDate = new Date(0);
		Date prevDate = new Date(0);
		for (Flight flug : DateSortedList) {
			currDate = flug.getDepTime();
			assertTrue(currDate.compareTo(prevDate) >=0 ) ;
			prevDate = currDate;
		}
	}
	
	@Test
	public void FilterTest1Airline() {
		ArrayList<Flight> fyrstiListi = container.getList();
		String[] flugfelog = {"WOW","Emirates"};
		ArrayList<Flight> filteredList = container.filter(flugfelog);
		String airline;
		for (Flight flug : filteredList) {
			airline = flug.getAirline().getName();
			assertTrue(Arrays.asList(flugfelog).contains(airline));
		}
		assertTrue(filteredList.size() <= fyrstiListi.size());
	}
	
	@Test
	public void FilterTest2Airline() {
		String[] flugfelog = {"EgErEkkiFlugfelag"};
		ArrayList<Flight> filteredList = container.filter(flugfelog);
		assertTrue(filteredList.isEmpty());
	}
	
	@Test
	public void FilterTest3Airline() {
		ArrayList<Flight> fyrstiListi = container.getList();
		String[] flugfelog = {"WOW","EgErEkkiFlugfelag"};
		ArrayList<Flight> filteredList = container.filter(flugfelog);
		String airline;
		for (Flight flug : filteredList) {
			airline = flug.getAirline().getName();
			assertTrue(Arrays.asList(flugfelog).contains(airline));
		}
		assertTrue(filteredList.size() <= fyrstiListi.size());
	}
	
	@Test
	public void FilterTest4Airline() {
		String[] flugfelog = {};
		ArrayList<Flight> fyrstiListi = container.getList();
		ArrayList<Flight> filteredList = container.filter(flugfelog);
		assertTrue(filteredList.size() == fyrstiListi.size());
	}
	
}
