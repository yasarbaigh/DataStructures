package oy.ds.number.test;

import org.junit.Test;

import oy.ds.number.PowerofAB;

public class PowerOfABTest
{
	@Test
	public void orderNPowerCalculate()
	{
		System.out.println("PowerOfABTest.orderNPowerCalculate()");
		System.out.println(PowerofAB.calculatePowerAtOrderN(2, 11));
		System.out.println(PowerofAB.calculatePowerAtOrderN(2, -11));
		System.out.println(PowerofAB.calculatePowerAtOrderN(3, 11));
		System.out.println(PowerofAB.calculatePowerAtOrderN(3, -11));
		System.out.println("=========================================================");
	}
	
	@Test
	public void orderLogNPowerCalculate()
	{
		System.out.println("PowerOfABTest.orderLogNPowerCalculate()");
		System.out.println(PowerofAB.calculatePowerAtOrderLogN(2, 11));
		System.out.println(PowerofAB.calculatePowerAtOrderLogN(2, -11));
		System.out.println(PowerofAB.calculatePowerAtOrderLogN(3, 11));
		System.out.println(PowerofAB.calculatePowerAtOrderLogN(3, -11));
		System.out.println("=========================================================");
	}
	
	@Test
	public void nonRecurOrderLogNPowerCalculate()
	{
		System.out.println("PowerOfABTest.nonRecurOrderLogNPowerCalculate()");
		System.out.println(PowerofAB.nonRecurPowerAtOrderLogN(2, 11));
		System.out.println(PowerofAB.powFast(2, 11));
		System.out.println(PowerofAB.nonRecurPowerAtOrderLogN(2, -11));
		System.out.println(PowerofAB.nonRecurPowerAtOrderLogN(3, 11));
		System.out.println(PowerofAB.powFast(3, 11));
		System.out.println(PowerofAB.nonRecurPowerAtOrderLogN(3, -11));
		System.out.println("=========================================================");
	}
}
