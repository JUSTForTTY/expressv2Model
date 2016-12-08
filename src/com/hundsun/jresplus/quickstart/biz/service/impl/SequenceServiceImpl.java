/**
* <p>Title: </p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2008</p>
* <p>Company: soft.buylog.cn</p>
* @author :James Lee
* @version 1.0
*/
package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import javax.sound.midi.Sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.SequenceDAO;
import com.hundsun.jresplus.quickstart.biz.dao.impl.SequenceDAOImpl;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;

@Service("sequenceService")
public class SequenceServiceImpl extends BaseService implements SequenceService {

    @Autowired
    private SequenceDAO sequenceDAO;

    public void setSequenceDao(SequenceDAOImpl sequenceDao) {
        this.sequenceDAO = sequenceDao;
    }

    public List getAllSequence() {
        return (List) sequenceDAO.findAllSequence();
    }

    public Sequence getSequenceByTablename(String tablename) {
        return sequenceDAO.findSequenceByTablename(tablename);
    }

    public void addSequence(Sequence sequence) {
        sequenceDAO.addSequence(sequence);
    }

    public void removeSequence(String tablename) {
        sequenceDAO.removeSequence(tablename);
    }

    public void updateSequence(Sequence sequence) {
        sequenceDAO.updateSequence(sequence);
    }

    public void increaseSeqno(String tablenamee) {
        sequenceDAO.increaseSeqno(tablenamee);
    }

    public Integer getMaxSeqno(String tablename) {
        return sequenceDAO.getMaxSeqno(tablename);
    }

    public Integer genValidSeqno(String tablename) {
        increaseSeqno(tablename);
        return getMaxSeqno(tablename);
    }
}
