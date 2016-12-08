package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import javax.sound.midi.Sequence;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.SequenceDAO;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("sequenceDAO")
public class SequenceDAOImpl extends BaseDAO implements SequenceDAO {
    private static final String SQL_SPACE = "Sequence.";

    public List findAllSequence() {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "selectAllSequence",
            null);
        return list;
    }

    public Sequence findSequenceByTablename(String tablename) {
        Sequence sequence = (Sequence) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "selectSequenceByTablename", tablename);
        return sequence;
    }

    public void addSequence(Sequence sequence) {
        this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "insertSequence", sequence);

    }

    public void removeSequence(String tablename) {
        this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "deleteSequence", tablename);

    }

    public void updateSequence(Sequence sequence) {
        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateSequence", sequence);
    }

    public void increaseSeqno(String tablename) {
        this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseSeqno", tablename);
    }

    public Integer getMaxSeqno(String tablename) {
        Integer seqno = (Integer) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "getMaxSeqno", tablename);
        return seqno;
    }
}
