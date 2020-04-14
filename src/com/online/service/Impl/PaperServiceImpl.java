package com.online.service.Impl;

import com.online.dao.IPaperDao;
import com.online.domain.QuestionDomain;
import com.online.domain.SubjectDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.service.IPaperService;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
 *管理员
* 试卷业务层实现类
* */
@Service
public class PaperServiceImpl implements IPaperService {

	@Autowired
    private IPaperDao ipd;


    public void setIpaperDao(IPaperDao ipd){
        this.ipd = ipd;
    }



    @Override
    public List<TestDomain> paperFindAll() {
    	

        return ipd.paperFindAll();

    }

    @Override
    public List<TestDomain> findTypeAll(String sname) {

        return ipd.findTypeAll(sname);

    }

    @Override
    public List<TestDomain> findNameAll(String tname) {

        return ipd.findNameAll(tname);

    }

    @Override
    public List<TestQuestionDomain> findQuestAll(int tid){
    	
    	return ipd.findQuestAll(tid);
    }
    
    
    
    
    
    @Override
    public TestDomain savePaper(TestDomain td,List<Integer> list,UserDomain user) {

    		return ipd.savePaper(td,list,user);

    }

    @Override
    public int updatePaper(TestDomain td) {

         return ipd.updatePaper(td);
        	
    }
    
    
    @Override
    public int updateState(TestDomain td) {
    	
    	return ipd.updateState(td);
    }
    
    @Override
    public int updatePaperAdd(TestDomain td,List<Integer> list) {
    	
    	return ipd.updatePaperAdd(td,list);
    	
    }
    
    @Override
    public int updatePaperDel(TestDomain td,List<Integer> list) {
    	
    	return ipd.updatePaperDel(td,list);
    	
    }
    
    
    
    @Override
    public int updatePaperOpen(TestDomain tid) {
    	
    	return ipd.updatePaperOpen(tid);
    	
    }
    
    

    @Override
    public int deletePaper(int tid) {

    	return ipd.deletePaper(tid);

    }

    @Override
    public List<TestDomain> tasterFindAll() {
    	
        return ipd.tasterFindAll();
    }
    
    
    @Override
    public List<QuestionDomain> lastFindTQT(int tid,int sid){
    	
    	return ipd.lastFindTQT(tid,sid);
    	
    }
    
    
    @Override
    public List<QuestionDomain> findQuestType(int gid,int sid){
    	
    	return ipd.findQuestType(gid,sid);
    }
    
    
    
    
}
