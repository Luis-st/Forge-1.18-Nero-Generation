package net.luis.industry.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VarArgs<T> {
	
	private final List<T> list;
	
	public VarArgs() {
		this.list = new ArrayList<T>();
	}
	
	@SafeVarargs
	public VarArgs(T... args) {
		this.list = new ArrayList<T>();
		this.addAll(args);
	}
	
	public void add(T arg) {
		this.list.add(arg);
	}
	
	public void addAll(Collection<T> args) {
		this.list.addAll(args);
	}
	
	@SuppressWarnings("unchecked")
	public void addAll(T... args) {
		this.list.addAll(Arrays.asList(args));
	}
	
	public T getType() {
		return this.list.get(0);
	}
	
	public int size() {
		return this.list.size();
	}
	
	public List<T> asList() {
		return this.list;
	}
	
}
