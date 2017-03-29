package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

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
		this.Mock = new MockSearchDbContainer();
		this.container = new SearchContainer(Mock);
		this.borg1 = new City("Vopnafjörður", 0);
		this.borg2 = new City("Borgarfjörður", 0);
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
		container.sort("lala");
	}
	
	@Test
	public void SortTest2() {
		container.sort("date");
	}
	
	@Test
	public void FilterTest() {
		String[] lala = {"WOW"};
		container.filter(lala);
	}
	 
}
