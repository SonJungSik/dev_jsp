package service;

import dto.NumDto;

public class AdditionService {
	private NumDto numDto;
	
	public AdditionService(NumDto numDto) {
		this.numDto = numDto;
	}
	
	public int add() {
		return numDto.getNum1() + numDto.getNum2();
	}
}
