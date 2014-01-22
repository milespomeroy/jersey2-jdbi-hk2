package com.milespomeroy.jersey2jdbi2hk2.service;

import com.lingotek.jdbi.ondemand.OnDemand;
import com.milespomeroy.jersey2jdbi2hk2.dao.LearnDao;

public class MagicService
{
    @OnDemand
    private LearnDao learnDao;

    public int getMagicNumber() {
		return 42;
	}

    public int getMagicNumberFromDao() {
        return this.learnDao.getMagicNumber();
    }
}
