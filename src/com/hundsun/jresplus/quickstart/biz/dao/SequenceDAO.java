package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import javax.sound.midi.Sequence;

public interface SequenceDAO {
    public List findAllSequence();

    public Sequence findSequenceByTablename(String tablename);

    public void addSequence(Sequence sequence);

    public void removeSequence(String tablename);

    public void updateSequence(Sequence sequence);

    public void increaseSeqno(String tablename);

    public Integer getMaxSeqno(String tablename);
}
