package com.example.service;

import java.util.List;

import com.example.entities.Pool;

public interface IPoolService {
	boolean GeneratePool();

	boolean GeneratePoolP2();

	boolean GeneratePoolG();

	boolean GeneratePoolS();

	boolean GeneratePoolF();

	boolean GenerateMatchs(Pool P);

	boolean DeleteAllPools();

	List<Pool> GetAllPools();

}
