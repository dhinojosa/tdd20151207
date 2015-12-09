package com.example;

import java.util.Collections;
import java.util.List;

public class CalcStats {

	public static final String LIST_CANNOT_BE_NULL_MSG = 
			               "List cannot be null";

	private List<Integer> list;

	public CalcStats(List<Integer> list) {
		if (list == null) throw 
		  new IllegalArgumentException
		     (LIST_CANNOT_BE_NULL_MSG);
		this.list = list;
	}

	public Integer getMinimum() {
		if (list.isEmpty()) return null;
	    return Collections.min(list);
	}

	public Integer getMaximum() {
		if (list.isEmpty()) return null;
		return Collections.max(list);
	}

	public int getSize() {
		return list.size();
	}

	public double getAverage() {
		if (list.isEmpty()) return Double.NaN;
		double sum = 0.0;
		for (Integer item : list) {
			sum += item;
		}
		return sum / getSize();
	}
}
