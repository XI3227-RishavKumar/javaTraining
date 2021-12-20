package com.rishav.mongoDbAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.rishav.mongoDbAssignment.entity.CustomSeq;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class CustomSeqService {

	@Autowired
	private MongoOperations mongoOp;
	
	public int getNextSeq(String Id) {
		
		CustomSeq count = mongoOp.findAndModify(query(where("_id").is(Id)),
				new Update().inc("seq",1),
				options().returnNew(true).upsert(true),CustomSeq.class);
		 return count.getSeq();	}
}
